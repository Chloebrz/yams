package fr.mbpmx.other;

import fr.mbpmx.model.Player;

public class Constants {
	public static int NUMBER_OF_THROWS = 3;
	
	public static int NUMBER_OF_TURNS = 30;
	
	public static boolean DISPLAY_SCORES;
	
	public static Player p1, p2;

	public static Player changePlayer(Player currentPlayer) {
		if (currentPlayer == p1) {
			return p2;
		} else {
			return p1;
		}
	}
}
