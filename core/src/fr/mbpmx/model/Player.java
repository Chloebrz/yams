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

	public int getTotalScore() {
		int sum = 0;

		sum += scores.get(Combination.ONE);
		sum += scores.get(Combination.TWO);
		sum += scores.get(Combination.THREE);
		sum += scores.get(Combination.FOUR);
		sum += scores.get(Combination.FIVE);
		sum += scores.get(Combination.SIX);
		sum += scores.get(Combination.TWOPAIRS);
		sum += scores.get(Combination.THREEOFAKIND);
		sum += scores.get(Combination.FULLHOUSE);
		sum += scores.get(Combination.FOUROFAKIND);
		sum += scores.get(Combination.STRAIGHT);
		sum += scores.get(Combination.YAMS);
		sum += scores.get(Combination.CHANCE);
		// TODO Reduce this method length.

		sum += (scores.get(Combination.PLUS) - scores.get(Combination.MINUS))
				* scores.get(Combination.ONE);

		return sum;
	}
}
