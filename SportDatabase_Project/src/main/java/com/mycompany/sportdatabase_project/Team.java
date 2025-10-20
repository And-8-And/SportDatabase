package com.mycompany.sportdatabase_project;

public class Team 
{
    int team_id;
    String name;
    String country;
    int founding_year;

    public Team(int team_id, String name, String country, int founding_year) 
    {
        this.team_id = team_id;
        this.name = name;
        this.country = country;
        this.founding_year = founding_year;
    }

    public int getTeam_id() 
    {
        return team_id;
    }

    public void setTeam_id(int team_id) 
    {
        this.team_id = team_id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getCountry() 
    {
        return country;
    }

    public void setCountry(String country) 
    {
        this.country = country;
    }

    public int getFounding_year() 
    {
        return founding_year;
    }

    public void setFounding_year(int founding_year) 
    {
        this.founding_year = founding_year;
    }
    
    @Override
    public String toString()
    {
        return "Team: " + name + "(City: " + country + ", Founding Year: " + founding_year + ")";
    }
}
