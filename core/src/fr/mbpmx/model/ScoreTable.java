package fr.mbpmx.model;

import java.util.Hashtable;

public class ScoreTable extends Hashtable<Combination, Integer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Combination ONE;
    private Integer integer1 = 0;
    
    public ScoreTable(int range, int expandNumber) {
        super(range, expandNumber);
        this.put(this.ONE, this.integer1);
    }
    
    public static void main(String[] args) {
        ScoreTable scores = new ScoreTable(10, 10);
        System.out.println(scores);
    }
}
