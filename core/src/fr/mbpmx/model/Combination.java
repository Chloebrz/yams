package fr.mbpmx.model;

public enum Combination {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    TWOPAIRS(15, 25),
    THREEOFAKIND(20, 30),
    FULLHOUSE(25, 35),
    FOUROFAKIND(30, 40),
    STRAIGHT(40, 40),
    YAMS(50, 60),
    PLUS,
    MINUS,
    CHANCE;
    
    private int normalValue;
    private int bonusValue;
    
    Combination(){
        
    }
    
    Combination(int normal, int withBonus){
        this.normalValue = normal;
        this.bonusValue = withBonus;
    }
}
