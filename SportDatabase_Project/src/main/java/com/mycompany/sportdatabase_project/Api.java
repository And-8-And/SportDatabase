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
    
    // Static Method for Types_Of_Sports.java
    public static List<Types_Of_Sports> getTypesOfSports()
    {
        List<Types_Of_Sports> sports = new ArrayList<>();
        
        sports.add(new Types_Of_Sports(1, "Soccer"));
        sports.add(new Types_Of_Sports(2, "Handball"));
        
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
            int league_id = getSafeInt(leagueObj, "id");
            String leagueName = getSafeString(leagueObj, "name");
            
            for (int j = 0; j < seasonsArray.size(); j++)
            {
                JsonObject season = seasonsArray.get(j).getAsJsonObject();
                int seasonYear = getSafeInt(season, "year");
                
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
    public static List<Match> getSoccerMatches(int league_id, String season)
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
                Integer.parseInt(season)
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
    
    // (Handball) Method for League.java
    public static List<League> getHandballLeagues()
    {
        List<League> leagues = new ArrayList<>();
        
        String url = "https://v1.handball.api-sports.io/leagues";
        String json = get(url);
        
        if (json.isEmpty())
        {
            System.out.println("No data received from Handball API");
            
            return leagues;
        }

        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonArray seasons = obj.getAsJsonArray("seasons");
            
            int sport_id = 2;
            int league_id = getSafeInt(obj, "id");
            String name = getSafeString(obj, "name");
            
            for (int j = 0; j < seasons.size(); j++)
            {
                JsonObject seasonObj = seasons.get(j).getAsJsonObject();
                
                int seasonYear = getSafeInt(seasonObj, "season");
                
                League league = new League(sport_id, league_id, name, seasonYear);
                leagues.add(league);    
            }  
        }
        
        return leagues;
    }
    
    // (Handball) Method for Location.java
    public static List<Location> getHandballLocations(int league_id, int season)
    {
        List<Location> locations = new ArrayList<>();
        
        String url = "https://v1.handball.api-sports.io/games?league=" + league_id + "&season=" + season;
        String json = get(url);

        if (json.isEmpty())
        {
            System.out.println("No data received from Handball API");
            
            return locations;
        }

        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
    
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonObject countryObj = obj.getAsJsonObject("country");

            String country = getSafeString(countryObj, "name");

            Location location = new Location(i + 1, "Unknown", "Unknown", country);
            locations.add(location);
        }
        
        return locations;
    }
    
    // (Handball) Method for Team.java
    public static List<Team> getHandballTeams(int league_id, int season)
    {
        List<Team> teams = new ArrayList<>();
        
        String url = "https://v1.handball.api-sports.io/games?league=" + league_id + "&season=" + season;
        String json = get(url);

        if (json.isEmpty())
        {
            System.out.println("No data received from Handball API");
            
            return teams;
        }

        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
        
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();
            JsonObject teamObj = obj.getAsJsonObject("teams");
            JsonObject countryObj = obj.getAsJsonObject("country");
            JsonObject home = teamObj.getAsJsonObject("home");
            JsonObject away = teamObj.getAsJsonObject("away");
            
            int homeId = getSafeInt(home, "id");
            String homeName = getSafeString(home, "name");
            int awayId = getSafeInt(away, "id");
            String awayName = getSafeString(away, "name");
            String country = getSafeString(countryObj, "name");

            Team homeTeam = new Team(homeId, homeName, country);
            Team awayTeam = new Team(awayId, awayName, country);
            teams.add(homeTeam);
            teams.add(awayTeam);
        }
        
        return teams;
    }
    
    // (Handball) Method for Match.java
    public static List<Match> getHandballMatches(int league_id, int season)
    {
        List<Match> matches = new ArrayList<>();

        String url = "https://v1.handball.api-sports.io/games?league=" + league_id + "&season=" + season;
        String json = get(url);
        System.out.println("JSON:\n" + json);
        if (json.isEmpty())
        {
            System.out.println("No data received from Handball API");
            
            return matches;
        }

        Gson gson = new Gson();
        JsonObject jsonobj = gson.fromJson(json, JsonObject.class);
        JsonArray array = jsonobj.getAsJsonArray("response");
    
        for (int i = 0; i < array.size(); i++)
        {
            JsonObject obj = array.get(i).getAsJsonObject();

            JsonObject leagueObj = obj.getAsJsonObject("league");
            JsonObject venue = obj.getAsJsonObject("venue");
            JsonObject teams = obj.getAsJsonObject("teams");
            JsonObject homeTeamObj = teams.getAsJsonObject("home");
            JsonObject awayTeamObj = teams.getAsJsonObject("away");
            JsonObject scores = obj.getAsJsonObject("scores");

            int match_id = getSafeInt(obj, "id");

            League league = new League
            (
                2,
                getSafeInt(leagueObj, "id"),
                getSafeString(leagueObj, "name"),
                season
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

            int homeScore = getSafeInt(scores, "home");
            int awayScore = getSafeInt(scores, "away");

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