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
}