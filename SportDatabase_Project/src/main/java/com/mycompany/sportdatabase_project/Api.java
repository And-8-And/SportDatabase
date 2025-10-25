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
                int seasonYear = season.get("year").getAsInt();
                
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
            JsonObject fixture = obj.getAsJsonObject("fixture");
            JsonObject venue = fixture.getAsJsonObject("venue");
            JsonObject league = obj.getAsJsonObject("league");
            
            int location_id = getSafeInt(venue, "id");
            String stadium_name = getSafeString(venue, "name");
            String city = getSafeString(venue, "city");
            String country = getSafeString(league, "country");
            
            Location location = new Location(location_id, stadium_name, city, country);
            locations.add(location);
        }
        
        return locations;
    }
    
    // (Soccer) Methof for Team.java
    public static List<Team> getSoccerTeams(int league_id, String season)
    {
        List<Team> teams = new ArrayList<>();
        
        String url = "https://v3.football.api-sports.io/teams?league=" + league_id + "&season=" + season;
        String json = get(url);
        
        if (json.isEmpty())
        {
            System.out.println("No data received from Soccer API");
            
            return teams;
        }
        
        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonObject teamObj = obj.getAsJsonObject("team");
            
            int team_id = getSafeInt(teamObj, "id");
            String name = getSafeString(teamObj, "name");
            String country = getSafeString(teamObj, "country");
            
            Team team = new Team(team_id, name, country);
            teams.add(team);
        }
        
        return teams;
    }
    
    // (Soccer) Method for Match.java
    public static List<Match> getSoccerMatch(int league_id, String season)
    {
        List<Match> matches = new ArrayList<>();
        
        String url = "https://v3.football.api-sports.io/fixtures?league=" + league_id + "&season=" + season;
        String json = get(url);
        
        if (json.isEmpty())
        {
            System.out.println("No data received from Soccer API");
            
            return matches;
        }
        
        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonObject fixture = obj.getAsJsonObject("fixture");
            JsonObject leagueObj = obj.getAsJsonObject("league");
            JsonObject venue = fixture.getAsJsonObject("venue");
            JsonObject teams = obj.getAsJsonObject("teams");
            JsonObject homeTeamObj = teams.getAsJsonObject("home");
            JsonObject awayTeamObj = teams.getAsJsonObject("away");
            JsonObject goals = obj.getAsJsonObject("goals");
            
            int match_id = getSafeInt(fixture, "id");
            
            League league = new League
            (
                1,
                getSafeInt(leagueObj, "id"),
                getSafeString(leagueObj, "name"),
                getSafeInt(leagueObj, "season")
            );
            
            Location location = new Location
            (
                getSafeInt(venue, "id"),
                getSafeString(venue, "name"),
                getSafeString(venue, "city"),
                getSafeString(leagueObj, "country")
            );
           
            Team homeTeam = new Team
            (
                getSafeInt(homeTeamObj, "id"),
                getSafeString(homeTeamObj, "name"),
                getSafeString(leagueObj, "country")
            );
            
            Team awayTeam = new Team
            (
                getSafeInt(awayTeamObj, "id"),
                getSafeString(awayTeamObj, "name"),
                getSafeString(leagueObj, "country")
            );
            
            int homeScore = getSafeInt(goals, "home");
            int awayScore = getSafeInt(goals, "away");
            
            Integer winner;
            
            if (homeScore > awayScore)
            {
                winner = homeTeam.getTeam_id();
            }
            else if (homeScore < awayScore)
            {
                winner = awayTeam.getTeam_id();
            }
            else
            {
                winner = null;
            }
            
            Match match = new Match(match_id, league, location, homeTeam, awayTeam, homeScore, awayScore, winner);
            matches.add(match);
        }
        
        return matches;
    }
    
    // Methods for NULL value
    private static String getSafeString(JsonObject obj, String key)
    {
        if (obj == null || !obj.has(key) || obj.get(key).isJsonNull())
        {
            return "Unknown";
        }
        
        return obj.get(key).getAsString();
    }
    
    private static int getSafeInt(JsonObject obj, String key)
    {
        if (obj == null || !obj.has(key) || obj.get(key).isJsonNull())
        {
            return 0;
        }
        
        return obj.get(key).getAsInt();
    }
}