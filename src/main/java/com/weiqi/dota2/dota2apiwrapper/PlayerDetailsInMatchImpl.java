package com.weiqi.dota2.dota2apiwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerDetailsInMatchImpl implements PlayerDetailsInMatch {

    private Map<String, Object> map;
    
    protected PlayerDetailsInMatchImpl(Map<String, Object> map) {
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

    public List<Integer> getItems() {
        List<Integer> items = new ArrayList<Integer>();
        items.add((Integer) map.get("item_0"));
        items.add((Integer) map.get("item_1"));
        items.add((Integer) map.get("item_2"));
        items.add((Integer) map.get("item_3"));
        items.add((Integer) map.get("item_4"));
        items.add((Integer) map.get("item_5"));
        return items;
    }

    public int getKills() {
        return (Integer) map.get("kills");
    }

    public int getDeaths() {
        return (Integer) map.get("deaths");
    }

    public int getAssists() {
        return (Integer) map.get("assists");
    }

    public LeaverStatus getLeaverStatus() {
        return LeaverStatus.values()[(Integer) map.get("leaver_status")];
    }

    public int getGold() {
        return (Integer) map.get("gold");
    }

    public int getLastHits() {
        return (Integer) map.get("last_hits");
    }

    public int getDenies() {
        return (Integer) map.get("denies");
    }

    public int getGoldPerMin() {
        return (Integer) map.get("gold_per_min");
    }

    public int getExpPerMin() {
        return (Integer) map.get("xp_per_min");
    }

    public int getGoldSpent() {
        return (Integer) map.get("gold_spent");
    }

    public int getHeroDamage() {
        return (Integer) map.get("hero_damage");
    }

    public int getTowerDamage() {
        return (Integer) map.get("tower_damage");
    }

    public int getHeroHealing() {
        return (Integer) map.get("hero_healing");
    }

    public int getLevel() {
        return (Integer) map.get("level");
    }

    public int[] getAbility() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String toString() {
        String res = "";
        res += "accound id: " + this.getAccountId() + "\n";
        res += "player slot: " + this.getPlayerSlot() + "\n";
        res += "hero id: " + this.getHeroId() + "\n";
        res += "kills: " + this.getKills() + "\n";
        res += "deaths: " + this.getDeaths() + "\n";
        res += "assists: " + this.getAssists() + "\n";
        res += "leaver status: " + this.getLeaverStatus() + "\n";
        res += "gold: " + this.getGold() + "\n";
        res += "last hits: " + this.getLastHits() + "\n";
        res += "denies: " + this.getDenies() + "\n";
        res += "gold per min: " + this.getGoldPerMin() + "\n";
        res += "exp per min: " + this.getExpPerMin() + "\n";
        res += "gold spent: " + this.getGoldSpent() + "\n";
        res += "hero damage: " + this.getHeroDamage() + "\n";
        res += "tower damage: " + this.getTowerDamage() + "\n";
        res += "hero healing: " + this.getHeroHealing() + "\n";
        res += "level: " + this.getLevel() + "\n";
        res += "\n";
        
        return res;
    }

}
