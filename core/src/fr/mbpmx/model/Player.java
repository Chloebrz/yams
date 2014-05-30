package fr.mbpmx.model;

public class Player {
	private String name;
	private ScoreTable<Combination, Integer> scores;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreTable<Combination, Integer> getScores() {
		return scores;
	}

	public void setScores(ScoreTable<Combination, Integer> scores) {
		this.scores = scores;
	}
}
