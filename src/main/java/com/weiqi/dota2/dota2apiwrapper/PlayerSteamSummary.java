package com.weiqi.dota2.dota2apiwrapper;

public interface PlayerSteamSummary {
    public long getSteamId();
    
    public String getPersonaName();
    
    public String getProfileUrl();
    
    public PersonaState getPersonaState();
    
    public long getLastLogoff();
}
