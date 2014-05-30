package fr.mbpmx.controller;

import fr.mbpmx.model.Player;
import fr.mbpmx.model.Dice;
import fr.mbpmx.model.Combination;

public class Controller {
	private int numberTurnsLeft;
	Player currentPlayer;
	Dice dice1, dice2, dice3, dice4, dice5, dice6;

	/*
	 * public boolean onTouchEvent(MotionEvent event) {
	 * 
	 * }
	 */// Equivalent avec LibGDX !

	public void addScore(Combination combination, boolean bonus) {

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

	public Dice getDice1() {
		return dice1;
	}

	public void setDice1(Dice dice1) {
		this.dice1 = dice1;
	}

	public Dice getDice2() {
		return dice2;
	}

	public void setDice2(Dice dice2) {
		this.dice2 = dice2;
	}

	public Dice getDice3() {
		return dice3;
	}

	public void setDice3(Dice dice3) {
		this.dice3 = dice3;
	}

	public Dice getDice4() {
		return dice4;
	}

	public void setDice4(Dice dice4) {
		this.dice4 = dice4;
	}

	public Dice getDice5() {
		return dice5;
	}

	public void setDice5(Dice dice5) {
		this.dice5 = dice5;
	}

	public Dice getDice6() {
		return dice6;
	}

	public void setDice6(Dice dice6) {
		this.dice6 = dice6;
	}
}
