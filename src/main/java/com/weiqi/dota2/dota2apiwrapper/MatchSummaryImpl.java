package com.weiqi.dota2.dota2apiwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchSummaryImpl implements MatchSummary {

    private Map<String, Object> map;
    
    public MatchSummaryImpl(Map<String, Object> map) {
        this.map = map;
    }
    
    public long getMatchId() {
        return new Long(map.get("match_id").toString());
    }
    
    public long getMatchSeqNum() {
        return new Long(map.get("match_seq_num").toString());
    }
    
    public long getStartTime() {
        return new Long(map.get("start_time").toString());
    }
    
    public int getLobbyType() {
        return (Integer) map.get("lobby_type");
    }
    
    public int getRadiantTeamId() {
        return (Integer) map.get("radiant_team_id");
    }
    
    public int getDireTeamId() {
        return (Integer) map.get("dire_team_id");
    }
    
    @SuppressWarnings("unchecked")
    public List<PlayerSummaryInMatch> getPlayers() {
        List<PlayerSummaryInMatch> summaries = new ArrayList<PlayerSummaryInMatch>();
        List<Map<String, Object>> players = (List<Map<String, Object>>)map.get("players");
        for (Map<String, Object> player : players)
            summaries.add(new PlayerSummaryInMatchImpl(player));
        return summaries;
    }
    
    public String toString() {
        String res = "";
        res += "match id: " + this.getMatchId() + "\n";
        res += "match seq number: " + this.getMatchSeqNum() + "\n";
        res += "start time: " + this.getStartTime() + "\n";
        res += "lobby type: " + this.getLobbyType() + "\n";
        res += "radiant team id: " + this.getRadiantTeamId() + "\n";
        res += "dire team id: " + this.getDireTeamId() + "\n";
        res += "players: " + "\n" + this.getPlayers() + "\n";
        res += "\n";
        return res;
    }
}
