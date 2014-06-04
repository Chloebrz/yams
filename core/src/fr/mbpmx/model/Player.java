package fr.mbpmx.model;

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
}
