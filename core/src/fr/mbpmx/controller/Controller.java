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
		this.throwsLeft = Constants.NUMBER_OF_THROWS;
	}

	public int getNumberTurnsLeft() {
		return numberTurnsLeft;
	}

	public void setNumberTurnsLeft(int numberTurnsLeft) {
		this.numberTurnsLeft = numberTurnsLeft;
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

	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}

	public void throwDices() {
		if (throwsLeft > 0) {
			for (int i = 0; i < 4; i++) {
				if (dices.get(i).isToThrow()) {
					DiceValue random = DiceValue.randomDiceValue();
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
}
