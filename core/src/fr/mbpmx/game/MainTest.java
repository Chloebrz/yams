package fr.mbpmx.game;

import fr.mbpmx.controller.Controller;
import fr.mbpmx.model.Player;

public class MainTest {

	public static void main(String[] args) {
		Player chloe = new Player("Chloe");
		Player maxime = new Player("Maxime");

		Controller controller = new Controller();
		controller.setCurrentPlayer(maxime);

		controller.throwDices();
		System.out.println(controller.getDices());
		
		controller.getDices().get(2).setToThrow(false);
		controller.getDices().get(4).setToThrow(false);
		controller.throwDices();
		System.out.println(controller.getDices());
		
		
	}
}
