package models;

import helpers.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

import strategies.*;

/**
 *
 * 
 * 
 */
public abstract class Tower implements DrawableEntity{
	//final variables
	final static int MAXTOWERLEVEL = 4;
	final static String DEFAULTSTRATEGY = "Closest";
	
	//Tower properties
	Point position;
	double damage;
	int rateOfFire;
	int range;
	int sellPrice;	
	int upCost;
	String name;
	int level;
	Color tColor;
	Color shotColor;
	Image[] image = new Image[4];
	ImageIcon icon;
	private IStrategy strategy; 
	ArrayList<Critter> potentialCrittersInRange;
	private boolean enabled;
	private boolean selected;
	
    /**
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower(String n, Point p, ArrayList<Critter> crittersOnMap){
		position = p;
		name = n;
		level = 1;
		this.potentialCrittersInRange = crittersOnMap;
		strategy = new Closest();
		enabled = true;
		selected = false;
	}
	
    /**
     *
     * @return
     */
    public int getSellPrice(){	
		return sellPrice;
	}

    /**
     *
     * @return
     */
    public int getUpPrice(){
		return upCost;
	}

    /**
     *
     * @param strategy
     */
    public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
    /**
     *
     * @return
     */
    public int getPosX(){	
		return position.getX();
	}
	
    /**
     *
     * @return
     */
    public int getPosY(){	
		return position.getY();
	}
	
    /**
     *
     * @return
     */
    public int getRange(){	
		return range;
	}
	
    /**
     *
     * @return
     */
    public String getName(){	
		return name;
	}

	public Image getImage(int n) {
		return image[n];
	}

	/**
     *
     * @return
     */
    public boolean getEnabled(){	
		return enabled;
	}

    /**
     *
     * @param state
     */
    public void setEnabled(boolean state){
		enabled = state;
	}

    /**
     *
     * @return
     */
    public Color getColor(){
		return tColor;
	}

    /**
     *
     * @return
     */
    public boolean isSelected(){
		return selected;
	}

    /**
     *
     * @return
     */
    public IStrategy getStrategy(){
		return this.strategy;
	}

    /**
     *
     * @param s
     */
    public void setSelected(boolean s){
		selected = s;
	}

    /**
     *
     * @return
     */
    public static String getDefaultStrategy(){
		return DEFAULTSTRATEGY;
	}

    /**
     *
     * @param newColor
     */
    public void setColor(Color newColor){
		
		tColor = newColor;
	}

    /**
     *
     * @return
     */
    public Color getShotColor(){
		return shotColor;
	}

    /**
     *
     * @return
     */
    public static int getMaxTowerLevel(){
		return MAXTOWERLEVEL;
	}

    /**
     *
     * @param crittersOnMap
     */
    public void setCrittersOnMap(ArrayList<Critter> crittersOnMap){
		this.potentialCrittersInRange = crittersOnMap;
	}

    /**
     *
     * @return
     */
    public int getLevel(){
		return level;
	}
	
    /**
     * Updates and draws the Tower (and the shot to critter if any)
     * @param g
     */
    public void updateAndDraw(Graphics g){	
    	//get in range critters
		ArrayList<Critter> inRangeC = new ArrayList<Critter>();
		//get in range
		inRangeC = this.findCrittersInRange(potentialCrittersInRange);
		//select target
		Critter targetedCritter = this.selectTarget(this, inRangeC);
		if(targetedCritter != null){
			if(enabled){
				//shoot target
				this.shootTarget(targetedCritter, g);
			}
		}
		//draw the tower
		this.drawTower(g);
	}
	
    /**
     *
     * @param g
     */
    public void drawTower(Graphics g) {
		//Draws the tower with the Artist
		Artist_Swing.drawTower(this,g);
    }
	
    /**
     *
     * @param tf1
     * @param crittersInR
     * @return
     */
    protected Critter selectTarget(Tower tf1, ArrayList<Critter> crittersInR){
    	//selects the tower based on strategy
		Critter target = strategy.findTarget(tf1, crittersInR);
		return target;
	}

    /**
     *
     * @param a
     * @return
     */
    public double distanceToCritter(Critter a){
    	//get delta x and deltay
	    double deltaX = a.getPixelPosition().getX()-this.getPosX();
	    double deltaY = a.getPixelPosition().getY()-this.getPosY();
		//finds the distance between a creep and a tower.
		double critterDistance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
		
		return critterDistance;
	}
	
	//checking if a critter is in range of a tower
	private boolean inRange(Critter a){
		boolean result = true;
		//finds the distance between a creep and a tower.
		int critterDistance = (int) distanceToCritter(a);
		
		if(a.getSize()+this.getRange()<critterDistance){
			result = false;
		}
		
		return result;
	}
	
	//returns the critters that are in range of a tower

    /**
     *
     * @param a
     * @return
     */
    	public ArrayList<Critter> findCrittersInRange(ArrayList<Critter> a){
		//initialize arrayList
		ArrayList<Critter> crittersInRange = new ArrayList<Critter>();
		if(a != null){
			//go through and get any that are in range
			for(int i = 0; i<a.size();i++){
				if(a.get(i).isActive()){
					if(inRange(a.get(i))){
						crittersInRange.add(a.get(i));
					}
				}
			}
		}
		return crittersInRange;
		
	}
	
	//deals damage based on amount of damage of the tower

    /**
     *
     * @param target
     * @param g
     */
    protected void shootTarget(Critter target, Graphics g){
		for(int i = 0; i < this.rateOfFire * GameClock.getInstance().deltaTime(); i++){
			target.damage(damage);
			Artist_Swing.drawShot(this, target, g);
		}
	} 
	//upgrade the towers values and level

    /**
     *
     */
    public void upgradeTower(){
    	//upgrades the tower based on properties
		if(level < MAXTOWERLEVEL){
			level = level + 1;
			upCost = upCost*3;
			damage = damage*2; 
			rateOfFire = rateOfFire + level;
			sellPrice = sellPrice*2;
			range = (int)(1.5*range);
		}
	}

	public String toString(){
		String result = "";
		result += this.getName() + ", ";
		result += "Level " + this.getLevel() + "/" + MAXTOWERLEVEL;
		
		return result;
	}
	

}
