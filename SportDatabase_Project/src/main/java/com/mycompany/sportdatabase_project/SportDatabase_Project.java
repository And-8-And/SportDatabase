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

public class SportDatabase_Project 
{

    public static void main(String[] args) 
    {
        List<Types_Of_Sports> sports = Api.getTypesOfSport();
        
        for (int i = 0; i < sports.size(); i++)
        {
            Types_Of_Sports sport = sports.get(i);
            
            System.out.println(sport);
        }
    }
}
