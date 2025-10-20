package com.mycompany.sportdatabase_project;

class League 
{
    int sport_id;
    int league_id;
    String name;
    String season;

    public League(int sport_id, int league_id, String name, String season) 
    {
        this.sport_id = sport_id;
        this.league_id = league_id;
        this.name = name;
        this.season = season;
    }

    public int getSport_id() 
    {
        return sport_id;
    }

    public void setSport_id(int sport_id) 
    {
        this.sport_id = sport_id;
    }

    public int getLeague_id() 
    {
        return league_id;
    }

    public void setLeague_id(int league_id) 
    {
        this.league_id = league_id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSeason() 
    {
        return season;
    }

    public void setSeason(String season) 
    {
        this.season = season;
    }
    
    @Override
    public String toString()
    {
        return "League(ID): " + league_id + ", Name: " + name + ", Season: " + season;
    }
}
