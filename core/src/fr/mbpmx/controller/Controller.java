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
        this.numberTurnsLeft = Constants.NUMBER_OF_TURNS;

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

                    // Remove the previous value of the dice
                    numberOfEachValue[dices.get(i).getValue().getValue() - 1]--;

                    dices.get(i).setValue(random);

                    // add the new one
                    numberOfEachValue[random.getValue() - 1]++;
                }
            }
            throwsLeft--;
        }
    }

    public int getThrowsLeft() {
        return throwsLeft;
    }

    public void setThrowsLeft(int throwsLeft) {
        this.throwsLeft = throwsLeft;
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

    public void changePlayer(Combination c) {
        addScore(c);
        setThrowsLeft(Constants.NUMBER_OF_THROWS);
        setCurrentPlayer(Constants.changePlayer(getCurrentPlayer()));
        for (Dice d : dices) {
            d.setToThrow(true);
        }
        numberTurnsLeft--;
    }
}
