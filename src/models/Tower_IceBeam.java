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
public class Tower_IceBeam extends Tower {
	//properties for the ice beam tower
	static int buyCost = 150;
	double slowFactor;
	int slowTime;
    /**
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower_IceBeam(String n, Point p, ArrayList<Critter> crittersOnMap) {
		super(n, p, crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats
		damage = 0.25;
		rateOfFire = 10;
		range = 100;
		sellPrice = 75;
		upCost = 350;
		slowFactor = 0.5;
		tColor = Color.WHITE;
		shotColor = Color.WHITE;
		buyCost = 150;
		slowTime = 30;
		try{image[0] = ImageIO.read(getClass().getResourceAsStream("/img/ice1.png"));
		image[1] = ImageIO.read(getClass().getResourceAsStream("/img/ice3.png"));
		image[2] = ImageIO.read(getClass().getResourceAsStream("/img/ice4.png"));
		image[3] = ImageIO.read(getClass().getResourceAsStream("/img/ice4.png"));} catch (Exception e){e.printStackTrace();}
	}
	
	/*
	 * (non-Javadoc)
	 * @see models.Tower#shootTarget(models.Critter, java.awt.Graphics)
	 * Shoots the target and applies slow
	 */
    protected void shootTarget(Critter target, Graphics g){
		super.shootTarget(target, g);
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
     * Upgrades the tower and the slow
     */
    public void upgradeTower(){
    	if(level < MAXTOWERLEVEL){
	    	super.upgradeTower();
			this.slowTime = (this.slowTime + 20);
			this.slowFactor = this.slowFactor + 0.1;
    	}
    }

}
