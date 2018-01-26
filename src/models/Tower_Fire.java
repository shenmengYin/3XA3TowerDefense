package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * 
 * 
 */
public class Tower_Fire extends Tower {
	//properties for the fire tower
	double DOT;
	int damageOverTimeLength = 30;
	static int buyCost = 200;
	double slowFactor;
	int slowTime;
    /**
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower_Fire(String n, Point p, ArrayList<Critter> crittersOnMap) {
		super(n, p, crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats
		damage = 0.25;
		rateOfFire = 10;
		range = 100;
		sellPrice = 100;
		upCost = 400;
		slowFactor = 0.1;
		tColor = Color.red;
		shotColor = Color.red;
		buyCost = 200;
		slowTime = 25;
		DOT = 2;
		try{image[0] = ImageIO.read(getClass().getResourceAsStream("/img/fire1.png"));
		image[1] = ImageIO.read(getClass().getResourceAsStream("/img/fire2.png"));
		image[2] = ImageIO.read(getClass().getResourceAsStream("/img/fire3.png"));
		image[3] = ImageIO.read(getClass().getResourceAsStream("/img/fire4.png"));} catch (Exception e){e.printStackTrace();}
	}
	
	/*
	 * (non-Javadoc)
	 * @see models.Tower#shootTarget(models.Critter, java.awt.Graphics)
	 * Shoots the critter and applies damage over time
	 */
    protected void shootTarget(Critter target, Graphics g){
		super.shootTarget(target, g);
		target.damageOverTimeCritter(this.DOT, this.damageOverTimeLength);
		target.slowCritter(this.slowFactor, this.slowTime);
	}
	
    /**
     *
     * @return
     */
    public static int getBuyPrice(){	
		return buyCost;
	}
    /*
     * (non-Javadoc)
     * @see models.Tower#upgradeTower()
     * This upgrades the tower and the DOT and slow
     */
    public void upgradeTower(){
    	if(level < MAXTOWERLEVEL){
	    	super.upgradeTower();
			this.slowTime = (this.slowTime + 20);
			this.slowFactor = this.slowFactor + 0.1;
			this.DOT = this.DOT*2;
			this.damageOverTimeLength = (int) (this.damageOverTimeLength*1.5);
    	}
    }

}
