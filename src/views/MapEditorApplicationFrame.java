package views;


import helpers.Artist_Swing;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controllers.MapEditorController;
import models.TDMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  This initializes the various parts of the Map Editor, in terms of the frame.
 * 
 */
public class MapEditorApplicationFrame extends JFrame{

	// constants

    /**
     *  The width of the window of the Map Editor.
     */
    	public static final int PIXELWIDTH=Artist_Swing.PIXELWIDTH;

    /**
     *  The height of the window of the Map Editor.
     */
    public static final int PIXELHEIGHT=Artist_Swing.PIXELHEIGHT;

    /**
     *
     */
    public static final String APP_NAME = "Map Editor";

    /**
     *
     */
    public static final int TIMEOUT = 30;
	private MapControlPanel controlPanel;
	private MapPanel mapPanel;
	
	MapEditorController mapController;
	private TDMap tdMap;
	
    /**
     *
     * @param tdMap
     */
    public MapEditorApplicationFrame(TDMap tdMap){
    	//get the TDMap passed in and create a controller based on it
		this.tdMap= tdMap;
		mapController = new MapEditorController(tdMap);
		//initialize the application frame
		init();
		//and make this the main JFRAMe for the map controller
		mapController.setMainFrame(this);
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
		mapPanel = mapController.getPlayPanel();
		controlPanel = mapController.getControlPanel();
		//add these to the JFrame
		add(mapPanel);
		add(controlPanel);
		//get the map
		this.tdMap= mapController.getTDMap();
		//set the size and title
		setSize(PIXELWIDTH,PIXELHEIGHT);	
		setTitle(APP_NAME);   												
		this.setResizable(false);
		//set the x button as the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	



}