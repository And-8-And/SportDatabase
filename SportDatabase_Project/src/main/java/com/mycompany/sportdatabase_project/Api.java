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
}