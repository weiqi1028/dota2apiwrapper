package com.weiqi.dota2.dota2apiwrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Dota2APIWrapper {

    private String APIKey;
    private static final String GET_MATCH_DETAILS = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?";
    
    public Dota2APIWrapper(String key) {
        this.APIKey = key;
    }
    
    @SuppressWarnings("unchecked")
    public MatchDetail getMatchDetails(String id) throws IOException {
        String query = GET_MATCH_DETAILS + "match_id=" + id + "&key=" + APIKey;
        Map<String, Object> map = doGet(query);
        Map<String, Object> result = (Map<String, Object>) map.get("result");
        return new MatchDetailImpl(result);
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, Object> doGet(String query) throws IOException {
        URL url = new URL(query);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
        String inputLine;
		StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(response.toString(), Map.class);
        return result;
    }
    
}
