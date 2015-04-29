package com.weiqi.dota2.dota2apiwrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Dota2APIWrapper {

    private String APIKey;
    private static final String GET_MATCH_DETAILS = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?";
    private static final String GET_MATCH_HISTORY = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?";
    private static final String GET_HEROES = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?";
    private static final String GET_GAME_ITEMS = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/v0001/?";
    private static final String GET_PLAYER_SUMMARIES = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?";
    
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
    public MatchHistory getMatchHistory(MatchSearchOptions options) throws IOException {
        String query = GET_MATCH_HISTORY + "key=" + APIKey;
        query = options.appendToQuery(query);
        Map<String, Object> map = doGet(query);
        Map<String, Object> result = (Map<String, Object>) map.get("result");
        return new MatchHistoryImpl(result);
    }
    
    public MatchHistory getRecentMatches() throws IOException {
        MatchSearchOptions options = new MatchSearchOptions();
        options.setMatchsRequested(25);
        return getMatchHistory(options);
    }
    
    @SuppressWarnings("unchecked")
    public List<PlayerSteamSummary> getPlayerSummaries(List<Long> ids) throws IOException {
        if (ids.isEmpty())
            return null;
        String query = GET_PLAYER_SUMMARIES + "key=" + APIKey + "&steamids=" + ids.get(0);
        for (int i = 1; i < ids.size(); i++)
            query += "," + ids.get(i);
        Map<String, Object> map = doGet(query);
        Map<String, Object> response = (Map<String, Object>) map.get("response");
        List<Map<String, Object>> players = (List<Map<String, Object>>) response.get("players");
        
        List<PlayerSteamSummary> list = new ArrayList<PlayerSteamSummary>();
        for (Map<String, Object> player : players)
            list.add(new PlayerSteamSummaryImpl(player));
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public Map<Integer, Hero> getHeroes() throws IOException {
        String query = GET_HEROES + "key=" + APIKey + "&language=en_us";
        Map<String, Object> map = doGet(query);
        Map<String, Object> result = (Map<String, Object>) map.get("result");
        List<Map<String, Object>> heroes = (List<Map<String, Object>>) result.get("heroes");

        Map<Integer, Hero> res = new HashMap<Integer, Hero>();
        for (Map<String, Object> hero : heroes) {
            String name = (String) hero.get("name");
            int id = (Integer) hero.get("id");
            String localizedName = (String) hero.get("localized_name");
            res.put(id, new Hero(name, id, localizedName));
        }
        return res;
    }
    
    @SuppressWarnings("unchecked")
    public Map<Integer, Item> getGameItems() throws IOException {
        String query = GET_GAME_ITEMS + "key=" + APIKey;
        Map<String, Object> map = doGet(query);
        Map<String, Object> result = (Map<String, Object>) map.get("result");
        List<Map<String, Object>> items = (List<Map<String, Object>>) result.get("items");

        Map<Integer, Item> res = new HashMap<Integer, Item>();
        for (Map<String, Object> item : items) {
            int id = (Integer) item.get("id");
            String name = (String) item.get("name");
            int cost = (Integer) item.get("cost");
            boolean secretShop = (Integer) item.get("secret_shop") == 1;
            boolean sideShop = (Integer) item.get("side_shop") == 1;
            boolean recipe = (Integer) item.get("recipe") == 1;
            res.put(id, new Item(id, name, cost, secretShop, sideShop, recipe));
        }
        return res;
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
