package fr.mbpmx.model;

import java.util.Hashtable;

public class ScoreTable extends Hashtable<Combination, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    
    public ScoreTable() {
        this.put(Combination.ONE, -1);
        this.put(Combination.TWO, -1);
        this.put(Combination.THREE, -1);
        this.put(Combination.FOUR, -1);
        this.put(Combination.FIVE, -1);
        this.put(Combination.SIX, -1);
        this.put(Combination.TWOPAIRS, -1);
        this.put(Combination.THREEOFAKIND, -1);
        this.put(Combination.FULLHOUSE, -1);
        this.put(Combination.FOUROFAKIND, -1);
        this.put(Combination.STRAIGHT, -1);
        this.put(Combination.YAMS, -1);
        this.put(Combination.PLUS, -1);
        this.put(Combination.MINUS, -1);
        this.put(Combination.CHANCE, -1);
    }
    
    public static void main(String[] args) {
        ScoreTable scores = new ScoreTable();
        System.out.println(scores);
        scores.put(Combination.FULLHOUSE, 12);
        System.out.println(scores);
    }
}
