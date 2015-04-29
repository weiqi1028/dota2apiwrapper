package com.weiqi.dota2.dota2apiwrapper;

import java.util.List;

public interface MatchHistory {
    public int getStatus();
    
    public int getNumResults();
    
    public int getTotalResults();
    
    public int getResultsRemaining();
    
    public List<MatchSummary> getMatches();
}
