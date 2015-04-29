package com.weiqi.dota2.dota2apiwrapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MatchSearchOptions {
    private Map<String, Object> options = new HashMap<String, Object>();
    
    public void setHeroId(int id) {
        options.put("hero_id", new Integer(id));
    }
    
    public void setGameMode(GameMode mode) {
        options.put("game_mode", mode.getValue());
    }
    
    public void setSkill(MatchSkill skill) {
        options.put("skill", skill.getValue());
    }
    
    public void setMinPlayers(int num) {
        options.put("min_players", new Integer(num));
    }
    
    public void setAccoundId(int id) {
        options.put("account_id", new Integer(id));
    }
    
    public void setLeagueId(int id) {
        options.put("league_id", new Integer(id));
    }
    
    public void setStartMatchId(int id) {
        options.put("start_at_match_id", new Integer(id));
    }
    
    public void setMatchsRequested(int num) {
        options.put("matches_requested", new Integer(num));
    }
    
    public void setTournamentGamesOnly(boolean tournament) {
        options.put("tournament_games_only", new Boolean(tournament));
    }
    
    protected String appendToQuery(String query) {
        if (options.isEmpty())
            return query;
        Iterator<Map.Entry<String, Object>> entries = options.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            query += "&";
            query += entry.getKey();
            query += "=";
            query += entry.getValue();
        }
        return query;
    }
}