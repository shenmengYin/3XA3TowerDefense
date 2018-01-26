package models;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Tower_AreaAttack extends Tower {
	private int amountOfTargets = 3;
	static int buyCost = 900;

    public Tower_AreaAttack(String n, Point p, ArrayList<Critter> crittersOnMap) {
		super(n, p, crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats

		try{image[0] = ImageIO.read(getClass().getResourceAsStream("/img/area4.png"));
		image[1] = ImageIO.read(getClass().getResourceAsStream("/img/area2.png"));
		image[2] = ImageIO.read(getClass().getResourceAsStream("/img/area3.png"));
		image[3] = ImageIO.read(getClass().getResourceAsStream("/img/area4.png"));} catch (Exception e){e.printStackTrace();}
		damage = 0.8;
		rateOfFire = 10;
		range = 200;
		sellPrice = 400;
		upCost = 2000;
		tColor = Color.YELLOW;
		shotColor = Color.YELLOW;
		buyCost = 900;

	}
	
	

    public void updateAndDraw(Graphics g){	
    	//initialize in range critters and targets
		ArrayList<Critter> inRangeC = new ArrayList<Critter>();
		ArrayList<Critter> targets = new ArrayList<Critter>();

		//find our critters in range
		inRangeC = this.findCrittersInRange(potentialCrittersInRange);
		//select the target critter
		Critter targetedCritter = this.selectTarget(this, inRangeC);
		//remove this target from the list and find the next target
		for(int i = 0; i < amountOfTargets; i++){
			targets.add(targetedCritter);
			inRangeC.remove(targetedCritter);
			targetedCritter = this.selectTarget(this, inRangeC);
		}
		//shoot all of the targets
		if(!targets.isEmpty()){
			for(Critter c : targets){
				if(c != null){
					this.shootTarget(c, g);
				}
			}
		}
		//draw our tower
		this.drawTower(g);
	}

    public static int getBuyPrice(){	
		return buyCost;
	}

}
