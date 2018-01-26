package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

/*
 * Circle critter is average, run of the mill critter
 */

/**
 *
 * 
 */

public class Critter_Mage extends Critter{
	
    /**
     *
     * @param level
     * @param m
     */
    public Critter_Mage(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter1.gif"));} catch (Exception e){e.printStackTrace();}

		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (10*levelMultiplier);
		//average hitpoints
		currHitPoints = (140*levelMultiplier);
		maxHitPoints = currHitPoints;
		//low regen
		regen = (0.5*levelMultiplier);
		//average speed
		speed = Math.min(3.5*levelMultiplier, MAXSPEED);
		//no resistance
		resistance = 0;
		//set name
		name = "Circle Critter";
		cColor = Color.CYAN;
	}

	
}
