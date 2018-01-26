package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


/*
 * Pink critter is Strong but slow
 */

/**
 *
 * 
 */

public class Critter_Dragon extends Critter{

    /**
     *
     * @param level
     * @param m
     */
    public Critter_Dragon(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter3.gif"));} catch (Exception e){e.printStackTrace();}
		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (10*levelMultiplier);
		//high hitpoints
		currHitPoints = (300*levelMultiplier);
		maxHitPoints = currHitPoints;
		//medium regen
		regen = 2*levelMultiplier;
		//low speed
		speed = Math.min(1.75*levelMultiplier, MAXSPEED);
		//med resistance
		resistance = 0.3*levelMultiplier;
		//set name
		name = "Shuriken Critter";
		cColor = Color.PINK;
	}
}
