package controllers;

import views.MenuApplicationFrame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import views.SetupClass;

/**
 *  THE PRIMARY CLASS FROM WHERE THE GAME STARTS
 */
public class Game {

    /**
     *  This method is where the game kick-starts.
     * @param args
     * @throws SlickException 
     */
    public static void main(String[] args) throws SlickException{

        /*final NimbusLookAndFeel nimbus = new NimbusLookAndFeel();

        try {
            UIManager.setLookAndFeel(nimbus);
        }
        catch (UnsupportedLookAndFeelException e){
            System.out.println("Exception occurred");
        }*/

		//Begin the game by displaying the main menu
        AppGameContainer app = new AppGameContainer(new SetupClass("Group 30 Tower Defence"));
		
		app.setDisplayMode(1000, 700, false);
		
		
		app.start();
		//new MenuApplicationFrame();
	}
}
