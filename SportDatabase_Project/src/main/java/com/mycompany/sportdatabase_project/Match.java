package com.mycompany.sportdatabase_project;

public class Match 
{
    int match_id;
    League league;
    Location location;
    Team homeTeam;
    Team awayTeam;
    int homeScore;
    int awayScore;
    Integer winner;

    public Match(int match_id, League league, Location location, Team homeTeam, Team awayTeam, int homeScore, int awayScore, Integer winner) 
    {
        this.match_id = match_id;
        this.league = league;
        this.location = location;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.winner = winner;
    }

    public int getMatch_id() 
    {
        return match_id;
    }

    public void setMatch_id(int match_id) 
    {
        this.match_id = match_id;
    }

    public League getLeague() 
    {
        return league;
    }

    public void setLeague(League league) 
    {
        this.league = league;
    }

    public Location getLocation() 
    {
        return location;
    }

    public void setLocation(Location location) 
    {
        this.location = location;
    }

    public Team getHomeTeam() 
    {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) 
    {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() 
    {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) 
    {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() 
    {
        return homeScore;
    }

    public void setHomeScore(int homeScore) 
    {
        this.homeScore = homeScore;
    }

    public int getAwayScore() 
    {
        return awayScore;
    }

    public void setAwayScore(int awayScore) 
    {
        this.awayScore = awayScore;
    }

    public Integer getWinner() 
    {
        return winner;
    }

    public void setWinner(Integer winner) 
    {
        this.winner = winner;
    }
    
    @Override
    public String toString()
    {
        String result = homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam;
        
        if (winner == null)
        {
            result += "Draw";
        }
        return result;
    }
}
