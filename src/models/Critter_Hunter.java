package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


/*
 * White critter is fast but weak compared to other critters
 */

/**
 *
 * 
 */

public class Critter_Hunter extends Critter{

    /**
     *
     * @param level
     * @param m
     */
    public Critter_Hunter(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter6fast.gif"));} catch (Exception e){e.printStackTrace();}
		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (7*levelMultiplier);
		//low hitpoints
		currHitPoints = (140*levelMultiplier);
		maxHitPoints = currHitPoints;
		//does not regenerate health
		regen = 0;
		//fast
		speed = Math.min(8*levelMultiplier, MAXSPEED);
		//does not resist effects
		resistance = 0;
		//set name
		name = "Arrow Critter";
		cColor = Color.WHITE;
	}
}
