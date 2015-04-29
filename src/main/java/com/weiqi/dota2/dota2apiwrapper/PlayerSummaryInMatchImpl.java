package com.weiqi.dota2.dota2apiwrapper;

import java.util.Map;

public class PlayerSummaryInMatchImpl implements PlayerSummaryInMatch {

    private Map<String, Object> map;
    
    public PlayerSummaryInMatchImpl(Map<String, Object> map) {
        this.map = map;
    }
    
    public long getAccountId() {
        return new Long(map.get("account_id").toString());
    }

    public int getPlayerSlot() {
        return (Integer) map.get("player_slot");
    }

    public int getHeroId() {
        return (Integer) map.get("hero_id");
    }
    
    public String toString() {
        String res = "";
        res += "account id: " + this.getAccountId() + "\n";
        res += "player slot: " + this.getPlayerSlot() + "\n";
        res += "hero id: " + this.getHeroId() + "\n";
        res += "\n";
        return res;
    }
}
