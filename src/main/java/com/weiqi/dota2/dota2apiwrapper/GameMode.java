package com.weiqi.dota2.dota2apiwrapper;

public enum GameMode {
	NONE(0), ALL_PICK(1), CAPTAINS_MODE(2), RANDOM_DRAFT(3), SINGLE_DRAFT(4), ALL_RANDOM(5),
    INTOR(6), DIRETIDE(7), REVERSE_CAPTAINS_MODE(8), THE_GREEVILING(9), TUTORIAL(10),
    MID_ONLY(11), LEAST_PLAYED(12), NEW_PLAYER_POOL(13), COMPENDIUM_MATCHMAKING(14),
    CAPTAINS_DRAFT(15);
    
    private final int value;
    
    private GameMode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
}
