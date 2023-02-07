package es.iesjandula.statsbomb.webportal.models;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 07/02/2023
 */
public class Type
{

    private Competitions competitions;
    private Matches matches;
    private Lineups lineups;
    private Events events;
    private ThreeSixty three_sixty;

    public Type()
    {

    }

    public Type(Competitions competitions, Matches matches, Lineups lineups, Events events, ThreeSixty three_sixty)
    {
        this.competitions = competitions;
        this.matches = matches;
        this.lineups = lineups;
        this.events = events;
        this.three_sixty = three_sixty;
    }

    public Competitions getCompetitions()
    {
        return competitions;
    }

    public void setCompetitions(Competitions competitions)
    {
        this.competitions = competitions;
    }

    public Matches getMatches()
    {
        return matches;
    }

    public void setMatches(Matches matches)
    {
        this.matches = matches;
    }

    public Lineups getLineups()
    {
        return lineups;
    }

    public void setLineups(Lineups lineups)
    {
        this.lineups = lineups;
    }

    public Events getEvents()
    {
        return events;
    }

    public void setEvents(Events events)
    {
        this.events = events;
    }

    public ThreeSixty getThree_sixty()
    {
        return three_sixty;
    }

    public void setThree_sixty(ThreeSixty three_sixty)
    {
        this.three_sixty = three_sixty;
    }
}
