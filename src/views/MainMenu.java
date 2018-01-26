package views;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import models.TDMap;

public class MainMenu extends BasicGameState {

	Image mainMenu;
	Image playNow;
	Image exitGame;
	Image Normal;
	Image Cruel;
	TDMap mapToLoad;
	Music mainMusic;
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		mainMenu = new Image("data/mainMenu.png");
		playNow = new Image("data/playnow.png");
		exitGame = new Image("data/exitGame.png");
		mainMusic = new Music("data/mainBGM.wav");
	}

	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if(posX >= 400 && posX <= 600 && posY >= 347 && posY <= 400) {
			
			if(Mouse.isButtonDown(0)) {
				//mapToLoad = new TDMap("res/Try1.TDMap"); //set default map
				//new GameApplicationFrame(mapToLoad);
				
				state.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}
		
		if(posX >= 400 && posX <= 600 && posY >= 247 && posY <= 300) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
		if(!mainMusic.playing())
			mainMusic.loop();
		
	}
	
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		mainMenu.draw(0,0);
		g.drawString("Welcome to our Tower Defence Game! -- Presented by Team 30", 250, 100);
		playNow.draw(400, 300);
		exitGame.draw(400, 400);
		
	}

	public int getID() {
		return 0;
	}

}
