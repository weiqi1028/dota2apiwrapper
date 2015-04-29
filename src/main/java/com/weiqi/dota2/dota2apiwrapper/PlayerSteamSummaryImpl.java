package com.weiqi.dota2.dota2apiwrapper;

import java.util.Map;

public class PlayerSteamSummaryImpl implements PlayerSteamSummary {

    private Map<String, Object> map;
    
    public PlayerSteamSummaryImpl(Map<String, Object> map) {
        this.map = map;
    }
    
    public long getSteamId() {
        return new Long(map.get("steamid").toString());
    }

    public String getPersonaName() {
        return (String) map.get("personaname");
    }

    public String getProfileUrl() {
        return (String) map.get("profileurl");
    }

    public PersonaState getPersonaState() {
        return PersonaState.values()[(Integer) map.get("personastate")];
    }

    public long getLastLogoff() {
        return new Long(map.get("lastlogoff").toString());
    }

    public String toString() {
        String res = "";
        res += "steam id: " + this.getSteamId() + "\n";
        res += "persona name: " + this.getPersonaName() + "\n";
        res += "profile url: " + this.getProfileUrl() + "\n";
        res += "persona state: " + this.getPersonaState() + "\n";
        res += "last log off: " + this.getLastLogoff() + "\n";
        return res;
    }
}
