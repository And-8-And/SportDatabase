package com.mycompany.sportdatabase_project;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Api 
{
    static class Sport
    {
        int id;
        String name;
        
        public Sport(int id, String name)
        {
            this.id = id;
            this.name = name; 
        }
    }
    
    // GET method for API
    public static String get(String url)
    {
        try
        {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                
                    .uri(URI.create(url))
                    .header("x-apisports-key", "6cbe3df52a59ea3628950b58190dd6d9")
                    .GET()
                    .build();
        
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
            return response.body();
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println("Error while connecting: " + e.getMessage());
            return "";
        }
    }
    
    // Static method for Types_Of_Sports.java
    public static List<Types_Of_Sports> getTypesOfSport()
    {
        List<Types_Of_Sports> sports = new ArrayList<>();
        
        sports.add(new Types_Of_Sports(1, "Soccer"));
        sports.add(new Types_Of_Sports(2, "Handball"));
        sports.add(new Types_Of_Sports(3, "Basketball"));
        sports.add(new Types_Of_Sports(4, "Formula One"));
        sports.add(new Types_Of_Sports(5, "MMA"));
        
        return sports;
    }
    
    // (Soccer) Method for League.java
    public static List<League> getSoccerLeagues()
    {
        List<League> leagues = new ArrayList<>();
        
        String url = "https://v3.football.api-sports.io/leagues";
        String json = get(url);
        
        if (json.isEmpty())
        {
            System.out.println("No data received from Soccer API");
            
            return leagues;
        }
        
        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            
            JsonObject leagueObj = obj.getAsJsonObject("league");
            JsonArray seasonsArray = obj.getAsJsonArray("seasons");
            
            int sport_id = 1;
            int league_id = leagueObj.get("id").getAsInt();
            String leagueName = leagueObj.get("name").getAsString();
            
            for (int j = 0; j < seasonsArray.size(); j++)
            {
                JsonObject season = seasonsArray.get(j).getAsJsonObject();
                String seasonYear = season.get("year").getAsString();
                
                League league = new League(sport_id, league_id, leagueName, seasonYear);
                leagues.add(league);
            }
        }
        
        return leagues;
    }
    
    // (Soccer) Method for Location.java
    public static List<Location> getSoccerLocations(int league_id, String season)
    {
        List<Location> locations = new ArrayList<>();
        
        String url = "https://v3.football.api-sports.io/fixtures?league=" + league_id + "&season=" + season;
        String json = get(url);
        
        if (json.isEmpty())
        {
            System.out.println("No data received from Soccer API");
            
            return locations;
        }
        
        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonObject fixture
        }
    }
    
    
}