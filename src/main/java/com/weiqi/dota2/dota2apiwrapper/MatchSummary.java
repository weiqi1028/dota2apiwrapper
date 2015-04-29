package com.weiqi.dota2.dota2apiwrapper;

import java.util.List;

public interface MatchSummary {
    public long getMatchId();
    
    public long getMatchSeqNum();
    
    public long getStartTime();
    
    public int getLobbyType();
    
    public int getRadiantTeamId();
    
    public int getDireTeamId();
    
    public List<PlayerSummaryInMatch> getPlayers();
}
