package com.weiqi.dota2.dota2apiwrapper;

public enum MatchSkill {
    ANY(0), NORMAL(1), HIGH(2), VERY_HIGH(3);
    
    private final int value;
    
    private MatchSkill(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
