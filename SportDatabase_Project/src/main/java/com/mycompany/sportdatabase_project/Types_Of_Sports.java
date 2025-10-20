package com.mycompany.sportdatabase_project;

public class Types_Of_Sports 
{
    int sport_id;
    String name;

    public Types_Of_Sports(int sport_id, String name) 
    {
        this.sport_id = sport_id;
        this.name = name;
    }

    public int getSport_id() 
    {
        return sport_id;
    }

    public void setSport_id(int sport_id) 
    {
        this.sport_id = sport_id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return "Sport(ID): " + sport_id + ", Name: " + name;
    }
}
