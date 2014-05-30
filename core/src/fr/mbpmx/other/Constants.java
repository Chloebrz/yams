package fr.mbpmx.other;

import fr.mbpmx.model.Player;

public class Constants {
	private Player p1, p2;

	public Player changePlayer(Player currentPlayer) {
		if (currentPlayer == p1) {
			return p2;
		} else {
			return p1;
		}
	}
}
