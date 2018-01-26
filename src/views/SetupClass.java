package views;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class SetupClass extends StateBasedGame{

	public SetupClass(String title) {
		super(title);
	}


	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		this.addState(new MainMenu());
		this.addState(new GameState());
	}


}