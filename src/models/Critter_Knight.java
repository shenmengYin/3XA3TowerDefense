package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


/*
 * Red Critters are weak 
 */

/**
 *
 * 
 * 
 */

public class Critter_Knight extends Critter{

    /**
     *
     * @param level
     * @param m
     */
    public Critter_Knight(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter4.gif"));} catch (Exception e){e.printStackTrace();}

		double levelMultiplier = calculateLevelMultiplier();
		//low reward
		reward = (int) (12*levelMultiplier);
		//low hitpoints
		currHitPoints = (180*levelMultiplier);
		maxHitPoints = currHitPoints;
		//no regen
		regen = 0;
		//low speed
		speed = Math.min(3.5*levelMultiplier, MAXSPEED);
		resistance = 0;
		//set name
		name = "Square Critter";
		cColor = Color.RED;
	}

}
