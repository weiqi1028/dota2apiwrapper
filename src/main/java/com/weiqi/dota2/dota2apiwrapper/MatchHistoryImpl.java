package com.weiqi.dota2.dota2apiwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchHistoryImpl implements MatchHistory {
    
    private Map<String, Object> map;
    
    public MatchHistoryImpl(Map<String, Object> map) {
        this.map = map;
    }

    public int getStatus() {
        return (Integer) map.get("status");
    }

    public int getNumResults() {
        return (Integer) map.get("num_results");
    }

    public int getTotalResults() {
        return (Integer) map.get("total_results");
    }

    public int getResultsRemaining() {
        return (Integer) map.get("results_remaining");
    }

    @SuppressWarnings("unchecked")
    public List<MatchSummary> getMatches() {
        List<MatchSummary> summaries = new ArrayList<MatchSummary>();
        List<Map<String, Object>> matches = (List<Map<String, Object>>) map.get("matches");
        for (Map<String, Object> match : matches)
            summaries.add(new MatchSummaryImpl(match));
        return summaries;
    }

    public String toString() {
        String res = "";
        res += "status: " + this.getStatus() + "\n";
        res += "num of results: " + this.getNumResults() + "\n";
        res += "total results: " + this.getTotalResults() + "\n";
        res += "results remaining: " + this.getResultsRemaining() + "\n";
        res += "matches: " + "\n" + this.getMatches() + "\n";
        return res;
    }
}
