package com.mycompany.sportdatabase_project;

import java.util.ArrayList;
import java.util.List;

public class SportDatabase_Project 
{
    public static void main(String[] args)
    {
        /*
        // Types Of Sports
        List<Types_Of_Sports> sports = Api.getTypesOfSports();
        System.out.println("===== SPORT TYPES =====\n");
        for (int i = 0; i < sports.size(); i++)
        {
            System.out.println(sports.get(i).toString());
        }

        // Soccer Leagues
        List<League> leagues = Api.getSoccerLeagues();
        System.out.println("\n===== SOCCER LEAGUES =====\n");
        for (int i = 0; i < leagues.size(); i++)
        {
            League league = leagues.get(i);
            System.out.println(league);
        }
        
        int league_id = 39;
        String season = "2023";
        
        // Soccer Locations
        List<Location> locations = Api.getSoccerLocations(league_id, season);
        System.out.println("\n===== LOCATIONS =====\n");
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
        
        // Soccer Matches
        List<Match> matches = Api.getSoccerMatches(league_id, season);
        System.out.println("\n===== MATCHES =====\n");
        for (int i = 0; i < matches.size(); i++)
        {
            System.out.println(matches.get(i).toString());
        }*/
        
        
        // Types Of Sports
        List<Types_Of_Sports> sports = Api.getTypesOfSports();
        System.out.println("===== SPORT TYPES =====\n");
        for (int i = 0; i < sports.size(); i++)
        {
            System.out.println(sports.get(i).toString());
        }

        // Handball Leagues
        List<League> leagues = Api.getHandballLeagues();
        System.out.println("\n===== HANDBALL LEAGUES =====\n");
        for (int i = 0; i < leagues.size(); i++)
        {
            League league = leagues.get(i);
            System.out.println(league);
        }
        
        int league_id = 161;
        int season = 2022;
        
        // Handball Locations
        List<Location> locations = Api.getHandballLocations(league_id, season);
        System.out.println("\n===== LOCATIONS =====\n");
        for (int i = 0; i < locations.size(); i++)
        {
            System.out.println(locations.get(i).toString());
        }
        
        // Handball Teams
        List<Team> teams = Api.getHandballTeams(league_id, season);
        System.out.println("\n===== TEAMS =====\n");
        for (int i = 0; i < teams.size(); i++)
        {
            System.out.println(teams.get(i).toString());
        }
        
        // Handball Matches
        List<Match> matches = Api.getHandballMatches(league_id, season);
        System.out.println("\n===== MATCHES =====\n");
        for (int i = 0; i < matches.size(); i++)
        {
            System.out.println(matches.get(i).toString());
        }
        
        java.awt.EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }
}