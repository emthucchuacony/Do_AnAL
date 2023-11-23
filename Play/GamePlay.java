package Play;

import java.awt.EventQueue;

import Controller.GameController;
import Model.GameModel;
import View.GameMenu;

public class GamePlay {
	public static void main(String[] args) {
       
         
                
                    GameModel model = new GameModel();
                    GameController controller = new GameController(model);
                    GameMenu menu = new GameMenu(model, controller);
                    controller.setMenu(menu); 

                    menu.setVisible(true);
              
    }
}
