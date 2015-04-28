package com.weiqi.dota2.dota2apiwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchDetailImpl implements MatchDetail {

    private Map<String, Object> map;

    protected MatchDetailImpl(Map<String, Object> map) {
        this.map = map;
    }

    @SuppressWarnings("unchecked")
    public List<PlayerDetailsInMatch> getPlayerDetails() {
        List<PlayerDetailsInMatch> playerDetails = new ArrayList<PlayerDetailsInMatch>();
        List<Map<String, Object>> players = (List<Map<String, Object>>)map.get("players");
        for (Map<String, Object> player : players)
            playerDetails.add(new PlayerDetailsInMatchImpl(player));
        return playerDetails;
    }
     

    public boolean isRadiantWin() {
        return (Boolean) map.get("radiant_win");
    }

    public int getDuration() {
        return (Integer) map.get("duration");
    }

    public long getStartTime() {
        return new Long(map.get("start_time").toString());
    }

    public long getMatchId() {
        return new Long(map.get("match_id").toString());
    }

    public long getMatchSequenceNumber() {
        return new Long(map.get("match_seq_num").toString());
    }

    public int getRadiantTowerStatus() {
        return (Integer) map.get("tower_status_radiant");
    }

    public int getDireTowerStatus() {
        return (Integer) map.get("tower_status_dire");
    }

    public int getRadiantBarracksStatus() {
        return (Integer) map.get("barracks_status_radiant");
    }

    public int getDireBarracksStatus() {
        return (Integer) map.get("barracks_status_dire");
    }

    public int getCluster() {
        return (Integer) map.get("cluster");
    }

    public int getFirstBloodTime() {
        return (Integer) map.get("first_blood_time");
    }

    public int getLobbyType() {
        return (Integer) map.get("lobby_type");
    }

    public int getHumanPlayers() {
        return (Integer) map.get("human_players");
    }

    public int getLeagueId() {
        return (Integer) map.get("leagueid");
    }

    public int getPositiveVotes() {
        return (Integer) map.get("positive_votes");
    }

    public int getNegativeVotes() {
        return (Integer) map.get("negative_votes");
    }

    public GameMode getGameModes() {
        return GameMode.values()[(Integer) map.get("game_mode")];
    }

    @Override
    public String toString() {
        String res = "";
        res += "match id: " + this.getMatchId() + "\n";
        res += "players: " + "\n" + this.getPlayerDetails() + "\n";
        res += "is radiant win: " + this.isRadiantWin() + "\n";
        res += "duration: " + this.getDuration() + "\n";
        res += "start time: " + this.getStartTime() + "\n";
        res += "game mode: " + this.getGameModes() + "\n";
        res += "match seq num: " + this.getMatchSequenceNumber() + "\n";
        res += "tower status radiant: " + this.getRadiantTowerStatus() + "\n";
        res += "tower status dire: " + this.getDireTowerStatus() + "\n";
        res += "barracks status radiant: " + this.getRadiantBarracksStatus() + "\n";
        res += "barracks status dire: " + this.getDireBarracksStatus() + "\n";
        res += "cluster: " + this.getCluster() + "\n";
        res += "first blood time: " + this.getFirstBloodTime() + "\n";
        res += "lobby type: " + this.getLobbyType() + "\n";
        res += "human players: " + this.getHumanPlayers() + "\n";
        res += "league id: " + this.getLeagueId() + "\n";
        res += "positive votes: " + this.getPositiveVotes() + "\n";
        res += "negative votes: " + this.getNegativeVotes() + "\n";
        return res;
    }
}
