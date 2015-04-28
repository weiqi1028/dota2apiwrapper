package com.weiqi.dota2.dota2apiwrapper;

import java.util.List;

public interface PlayerDetailsInMatch {
    public long getAccountId();
    
    public int getPlayerSlot();
    
    public int getHeroId();
    
    public List<Integer> getItems();
    
    public int getKills();
    
    public int getDeaths();
    
    public int getAssists();
    
    public LeaverStatus getLeaverStatus();
    
    public int getGold();
    
    public int getLastHits();
    
    public int getDenies();
    
    public int getGoldPerMin();
    
    public int getExpPerMin();
    
    public int getGoldSpent();
    
    public int getHeroDamage();
    
    public int getTowerDamage();
    
    public int getHeroHealing();
    
    public int getLevel();
    
    public int[] getAbility();
}
