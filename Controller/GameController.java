package Controller;

import Model.GameModel;
import View.GameMenu;

public class GameController {
	
	
	
	
	
	GameMenu menu ;
	GameModel model;
	public GameController(GameModel model) {
		this.model = model;
		
	}
	
	public void startGame() {
		menu.startGame();
	}
	public void setMenu(GameMenu menu) {
		this.menu = menu;
	}
	public void exitGame() {
		menu.exitGame();
	}
	public void helpGame() {
		menu.helpGame();
	}
	public void moreGame() {
		menu.moreGame();
	}

}
