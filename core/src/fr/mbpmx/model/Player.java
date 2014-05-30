package fr.mbpmx.model;

public class Player {
	private String name;
	private ScoreTable scores;

	public Player(String name) {
		this.name = name;
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

	public void setScores(ScoreTable scores) {
		this.scores = scores;
	}
}
