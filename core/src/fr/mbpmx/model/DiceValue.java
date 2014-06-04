package fr.mbpmx.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum DiceValue {

	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

	private final int value;
	private static final List<DiceValue> VALUES = Collections
			.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = 6;
	private static final Random RANDOM = new Random();

	DiceValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static DiceValue generateDiceValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
