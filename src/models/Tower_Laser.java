package models;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * 
 * 
 */
public class Tower_Laser extends Tower{
	static int buyCost = 200;

    /**
     *
     * @param name
     * @param p
     * @param crittersOnMap
     */
    public Tower_Laser(String name, Point p, ArrayList<Critter> crittersOnMap) {
		super(name,p,crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats
		damage = 0.5;
		rateOfFire = 10;
		range = 250;
		sellPrice = 80;
		upCost = 600;
		tColor = Color.black;
		shotColor = Color.black;
		buyCost = 200;
		try{image[0] = ImageIO.read(getClass().getResourceAsStream("/img/laser2.png"));
		image[1] = ImageIO.read(getClass().getResourceAsStream("/img/laser4.png"));
		image[2] = ImageIO.read(getClass().getResourceAsStream("/img/laser3.png"));
		image[3] = ImageIO.read(getClass().getResourceAsStream("/img/laser4.png"));} catch (Exception e){e.printStackTrace();}
	}
	
    /**
     *
     * @return
     */
    public static int getBuyPrice(){	
		return buyCost;
	}

	
}
