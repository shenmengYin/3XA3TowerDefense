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

import controllers.GameController;
import models.TDMap;

public class GameState extends BasicGameState{

	TDMap mapToLoad;
	int time;
	int time0;
	Image main;
	Image back;
	Music gameBGM;
	public static int stage;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		main = new Image("data/main.png");
		back = new Image("data/back.png");
		gameBGM = new Music("data/gameBGM.wav");
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawString("Loading......", 100, 100);
		//main.draw(0, 670);
		back.draw(900, 675);
	}

	public void update(GameContainer arg0, StateBasedGame state, int delta) throws SlickException {
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		time += delta;
		
		if (time > 2000 && time < 2020) {
			mapToLoad = new TDMap(""); //set default map
			new GameApplicationFrame(mapToLoad);

		}
		
		if (stage == 1) {
			GameController.mainFrame.dispose();
			stage += 1;
		}
			
		if (stage == 2) {
			time0 += delta;
		}
		
		if (time0 > 2000 && time0 < 2020) {
			mapToLoad = new TDMap("/res/Try1.TDMap");
			new GameApplicationFrame(mapToLoad);
		}
		
		if(posX >= 900 && posX <= 1000 && posY >= 0 && posY <= 30) {
			if(Mouse.isButtonDown(1)) {
				GameController.mainFrame.dispose();
				state.enterState(0, new FadeOutTransition(), new FadeInTransition());
				time = 0;
			}
		}
		
		if(!gameBGM.playing()) {
			gameBGM.loop();
		}
			
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
