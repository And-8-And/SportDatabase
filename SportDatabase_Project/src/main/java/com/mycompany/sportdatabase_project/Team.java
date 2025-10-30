package com.mycompany.sportdatabase_project;

public class Team 
{
    int team_id;
    String name;
    String country;

    public Team(int team_id, String name, String country) 
    {
        this.team_id = team_id;
        this.name = name;
        this.country = country;
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
    
    @Override
    public String toString()
    {
        return name + " (Country: " + country + ")";
    }
    
    public String toStringShort()
    {
        return name;
    }   
}
