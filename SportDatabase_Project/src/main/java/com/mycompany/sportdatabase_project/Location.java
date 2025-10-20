package com.mycompany.sportdatabase_project;

public class Location 
{
    int location_id;
    String stadium;
    String city;
    String country;

    public Location(int location_id, String stadium, String city, String country) 
    {
        this.location_id = location_id;
        this.stadium = stadium;
        this.city = city;
        this.country = country;
    }

    public int getLocation_id() 
    {
        return location_id;
    }

    public void setLocation_id(int location_id) 
    {
        this.location_id = location_id;
    }

    public String getStadium() 
    {
        return stadium;
    }

    public void setStadium(String stadium) 
    {
        this.stadium = stadium;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
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
        return "Location: " + city + ", " + country + " (Stadium: " + stadium + ")";
    }
}
