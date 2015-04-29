package com.weiqi.dota2.dota2apiwrapper;

public enum PersonaState {
    OFFLINE(0), ONLINE(1), BUSY(2), AWAY(3), SNOOZE(4), LOOKING_TO_TRADE(5), LOOKING_TO_PLAY(6);
    
    private int value;
    
    private PersonaState(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
