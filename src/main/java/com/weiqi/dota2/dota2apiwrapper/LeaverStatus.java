package com.weiqi.dota2.dota2apiwrapper;

public enum LeaverStatus {
    NONE(0), DISCONNECTED(1), DISCONNECTED_TOO_LONG(2), ABANDONED(3), AFK(4), NEVER_CONNECTED(5);
    
    private final int status;
    
    LeaverStatus(int status) {
        this.status = status;
    }
}
