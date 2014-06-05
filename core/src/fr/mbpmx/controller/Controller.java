package fr.mbpmx.controller;

import java.util.ArrayList;
import java.util.List;

import fr.mbpmx.model.Combination;
import fr.mbpmx.model.Dice;
import fr.mbpmx.model.DiceValue;
import fr.mbpmx.model.Player;
import fr.mbpmx.other.Constants;

public class Controller {
	private int numberTurnsLeft;
	private Player currentPlayer;
	private List<Dice> dices;

	// Table containing the number of each dice value (from 1 to 6)
	private int[] numberOfEachValue;

	private int throwsLeft;

	public Controller() {
		this.currentPlayer = Constants.p1;
		this.throwsLeft = Constants.NUMBER_OF_THROWS;

		this.dices = new ArrayList<Dice>();
		for (int i = 0; i < 5; i++) {
			dices.add(new Dice());
		}

		this.numberOfEachValue = new int[] { 5, 0, 0, 0, 0, 0 };
	}

	public int getNumberTurnsLeft() {
		return numberTurnsLeft;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public List<Dice> getDices() {
		return dices;
	}

	public void throwDices() {
		if (throwsLeft > 0) {
			for (int i = 0; i < 5; i++) {
				if (dices.get(i).isToThrow()) {
					DiceValue random = DiceValue.generateDiceValue();
					dices.get(i).setValue(random);

					// Remove the previous value of the dice and add the new one
					numberOfEachValue[dices.get(i).getValue().getValue() - 1]--;
					numberOfEachValue[random.getValue() - 1]++;
				}
			}
			throwsLeft--;
		}
	}

	public List<Combination> findCombinations() {
		// TODO Find possible combinations to highlight them in the score table
		List<Combination> combinations = new ArrayList<Combination>();
		return combinations;
	}

	public void addScore(Combination combination) {
			currentPlayer.setScore(combination,
					combination.countPoints(numberOfEachValue));
			numberTurnsLeft--;
	}
	
	public int getCurrentScore(Combination combination) {
	    return combination.countPoints(numberOfEachValue);
	}
	public static void main (String[] arg) {
        Player maxime = new Player("Maxime");
	    Controller controller = new Controller();
        controller.setCurrentPlayer(maxime);

        controller.throwDices();
        System.out.println(controller.getDices());
        System.out.println("1 :" + controller.numberOfEachValue[0] + "\n2 :" + controller.numberOfEachValue[1] + "\n3 :" + controller.numberOfEachValue[2] + "\n4 :" + controller.numberOfEachValue[3] + "\n5 :" + controller.numberOfEachValue[4] + "\n6 :" + controller.numberOfEachValue[5]);
        
        controller.getDices().get(2).setToThrow(false);
        controller.getDices().get(4).setToThrow(false);
        controller.throwDices();
        System.out.println(controller.getDices());
        System.out.println("1 :" + controller.numberOfEachValue[0] + "\n2 :" + controller.numberOfEachValue[1] + "\n3 :" + controller.numberOfEachValue[2] + "\n4 :" + controller.numberOfEachValue[3] + "\n5 :" + controller.numberOfEachValue[4] + "\n6 :" + controller.numberOfEachValue[5]);
	}
}
