package fr.mbpmx.model;

import java.util.ArrayList;

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
		
		Combination[] combinations = Combination.class.getEnumConstants();
		for(int i = 0; i < 6; i++) {
		    if(scores.get(combinations[i]) >= 0) {
		        sum += scores.get(combinations[i]);
		    }
		}

		if (sum >= 63) {
			sum += 63;
		}
		
		for(int i = 6; i < 12; i++) {
		    if(scores.get(combinations[i]) >= 0) {
                sum += scores.get(combinations[i]);
            }
		}

		sum += (scores.get(Combination.PLUS) - scores.get(Combination.MINUS))
				* scores.get(Combination.ONE);
		
		sum += scores.get(Combination.CHANCE);

		return sum;
	}
}
