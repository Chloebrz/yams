package fr.mbpmx.model;

import java.util.Collection;
import java.util.Iterator;

public class Player {
	private String name;
	private ScoreTable scores;

	public Player(String name) {
		this.name = name;
		this.scores = new ScoreTable();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreTable getScores() {
		return scores;
	}

	public void setScore(Combination combination, int value) {
		scores.put(combination, value);
	}

	public int getTotalScore() {
		int sum = 0;
		Collection<Integer> values = scores.values();
		Iterator<Integer> iterator = values.iterator();
		while (iterator.hasNext()) {
			Integer points = iterator.next();
			sum += points;
		}

		return sum;
	}
}
