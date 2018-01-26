package views;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


/**
 *  This class sets the background frame for both the GameApplicationFrame and
 *  the MapEditorApplicationFrame.
 * 
 */
public class MapPanel extends JPanel {
    
    /**
     *
     */
    public MapPanel(){
        final NimbusLookAndFeel nimbus = new NimbusLookAndFeel();

        try {
            UIManager.setLookAndFeel(nimbus);
        }
        catch (UnsupportedLookAndFeelException e){
            System.out.println("Exception occurred");
        }
		
		//set panel properties
		setBackground(Color.BLACK);
        setPreferredSize(new Dimension(GameApplicationFrame.PIXELWIDTH , GameApplicationFrame.PIXELHEIGHT- GameControlPanel.getControlPanelHeight()));
        setDoubleBuffered(true);
        setVisible(true);
        setFocusable(true);
        requestFocus();
	}

}
