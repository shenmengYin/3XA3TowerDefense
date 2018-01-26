package views;


import helpers.Artist_Swing;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.TDMap;
import controllers.GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * 
 * 
 */
public class GameApplicationFrame extends JFrame {

	// constants
	/**
     *
     */
    	public static final int PIXELWIDTH=Artist_Swing.PIXELWIDTH;

    /**
     *
     */
    public static final int PIXELHEIGHT=Artist_Swing.PIXELHEIGHT;

    /**
     *
     */
    public static final String APP_NAME = "Group 30 Tower Defense";
	private GameControlPanel controlPanel;
	private MapPanel mapPanel;
                          		
    /**
     *
     */
    public static final int TIMEOUT = 30;                          		
	GameController gameController;
		
    /**
     *
     * @param tdMap
     */
    public  GameApplicationFrame(TDMap tdMap){
		gameController = new GameController(tdMap);
		init();
		gameController.setMainFrame(this);
	}
	
	/**
	 * Initialize the window
	 */
	private void init(){
		final NimbusLookAndFeel nimbus = new NimbusLookAndFeel();

		try {
			UIManager.setLookAndFeel(nimbus);
		}
		catch (UnsupportedLookAndFeelException e){
			System.out.println("Exception occurred");
		}
		
		//set the Frame properties
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		//get the control and map panels
		controlPanel = gameController.getControlPanel();
		mapPanel = gameController.getPlayPanel();
		//add them to the frame
		add(mapPanel);
		add(controlPanel);
		
		setSize(PIXELWIDTH,PIXELHEIGHT);	
		setTitle(APP_NAME);       												
		this.setResizable(false);
		//set the x button as the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setLocationRelativeTo(null);
		setVisible(true);
		
	}



}
