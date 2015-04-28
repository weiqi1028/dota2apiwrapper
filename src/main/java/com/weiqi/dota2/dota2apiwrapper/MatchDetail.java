package com.weiqi.dota2.dota2apiwrapper;

import java.util.List;

public interface MatchDetail {
    public List<PlayerDetailsInMatch> getPlayerDetails();
    
    public boolean isRadiantWin();
    
    public int getDuration();
    
    public long getStartTime();
    
    public long getMatchId();
    
    public long getMatchSequenceNumber();
    
    public int getRadiantTowerStatus();
    
    public int getDireTowerStatus();
    
    public int getRadiantBarracksStatus();
    
    public int getDireBarracksStatus();
    
    public int getCluster();
    
    public int getFirstBloodTime();
    
    public int getLobbyType();
    
    public int getHumanPlayers();
    
    public int getLeagueId();
    
    public int getPositiveVotes();
    
    public int getNegativeVotes();
    
    public GameMode getGameModes();
}