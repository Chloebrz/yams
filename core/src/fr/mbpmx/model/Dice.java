package fr.mbpmx.model;

public class Dice {
	private DiceValue value;
	private boolean toThrow;

	public Dice() {
		this.toThrow = true;
		this.value = DiceValue.ONE;
	}

	public DiceValue getValue() {
		return value;
	}

	public void setValue(DiceValue value) {
		this.value = value;
	}

	public boolean isToThrow() {
		return toThrow;
	}

	public void setToThrow(boolean toThrow) {
		this.toThrow = toThrow;
	}

	public String toString() {
		return this.getValue().toString();
	}
}
