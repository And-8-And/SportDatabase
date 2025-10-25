package com.mycompany.sportdatabase_project;

import java.util.ArrayList;
import java.util.List;

public class SportDatabase_Project 
{
    public static void main(String[] args)
    {
        // Types Of Sports
        List<Types_Of_Sports> sports = Api.getTypesOfSport();
        System.out.println("===== SPORT TYPES =====\n");
        for (int i = 0; i < sports.size(); i++)
        {
            System.out.println(sports.get(i).toString());
        }

        // Soccer League
        List<League> leagues = Api.getSoccerLeagues();
        System.out.println("\n===== SOCCER LEAGUES =====\n");
        for (int i = 0; i < leagues.size(); i++)
        {
            League league = leagues.get(i);
            System.out.println(league);
        }
        
        int league_id = 39;
        String season = "2023";
        
        // Soccer Location
        List<Location> locations = Api.getSoccerLocations(league_id, season);
        System.out.println("\n===== LOCATION =====\n");
        for (int i = 0; i < locations.size(); i++)
        {
            System.out.println(locations.get(i).toString());
        }
        
        // Soccer Teams
        List<Team> teams = Api.getSoccerTeams(league_id, season);
        System.out.println("\n===== TEAMS =====\n");
        for (int i = 0; i < teams.size(); i++)
        {
            System.out.println(teams.get(i).toString());
        }
        
        // Soccer Match
        List<Match> matches = Api.getSoccerMatch(league_id, season);
        System.out.println("\n===== MATCH =====\n");
        for (int i = 0; i < matches.size(); i++)
        {
            System.out.println(matches.get(i).toString());
        }
    }
}