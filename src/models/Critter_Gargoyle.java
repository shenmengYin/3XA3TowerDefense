package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

/*
 * Critter X is completely resitant to effects from towers. Average apart from that.
 */

/**
 *
 * 
 * 
 */

public class Critter_Gargoyle extends Critter {

    /**
     *
     * @param level
     * @param m
     */
    public Critter_Gargoyle(int level, TDMap m) {
		super(level, m);
		try{image = ImageIO.read(getClass().getResourceAsStream("/img/critter2.gif"));} catch (Exception e){e.printStackTrace();}
		double levelMultiplier = calculateLevelMultiplier();
		//high reward
		reward = (int) (12*levelMultiplier);
		//med hitpoints
		currHitPoints = (175*levelMultiplier);
		maxHitPoints = currHitPoints;
		//low regen
		regen = 1*levelMultiplier;
		//low speed
		speed = Math.min(3.5*levelMultiplier, MAXSPEED);
		//pure resistancfe
		resistance = 1;
		//set name
		name = "X Critter";
		cColor = Color.ORANGE;
	}
}
