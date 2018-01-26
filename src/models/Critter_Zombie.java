package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


/*
 * infinity critter is BOSS critter. Hard to kill, but high rewards
 */

/**
 *
 * 
 */

public class Critter_Zombie extends Critter{

    /**
     *
     * @param level
     * @param m
     */
    public Critter_Zombie(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter5.gif"));} catch (Exception e){e.printStackTrace();}
		double levelMultiplier = calculateLevelMultiplier();
		//high reward
		reward = (int) (20*levelMultiplier);
		//high hitpoints
		currHitPoints = (150*levelMultiplier);
		maxHitPoints = currHitPoints;
		//high regen
		regen = (2*levelMultiplier);
		//medium-high speed
		speed = Math.min(6*levelMultiplier, MAXSPEED);
		//high resistance
		resistance = 0.5*levelMultiplier;
		//set name
		name = "Infinity Critter";
		cColor = Color.YELLOW;
	}
}
