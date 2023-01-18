package es.iesjandula.statsbomb.models.lineups;

import es.iesjandula.statsbomb.models.event.tactics.Lineup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;

/**
 *@author Manuel Martin Murillo
 * @author Alejandro Aljarilla
 * Lineup files in the data/lineups directory will be in JSON format. Filenames will be in the
format 1234.json where 1234 is a match ID. The contents are an array containing lineup
information for both teams:
 */
@Entity
@Table(name = "format")
public class Format
{
    /**
     * Attribute
     * The unique identifier for each team.
     */
    @Id
    @Column(length = 10)
    private Integer team_id;
    /**
     * Attribute
     * The name of the team
     */

    @Column(length = 20)
    private String team_name;
    /**
     * Attribute
     * An array of players on the team sheet for this team.
     */
    private Lineup[] lineup;
    /**
     * Default constructor
     */
    public Format()
    {
        this.team_id = team_id;
        this.team_name = team_name;
        this.lineup = lineup;
    }

    /**
     * @return the team id
     */
    public Integer getTeam_id()
    {
        return team_id;
    }
    /**
     * @param team_id, with the identification of the team
     */
    public void setTeam_id(Integer team_id)
    {
        this.team_id = team_id;
    }
    /**
     * @return the team name
     */

    public String getTeam_name()
    {
        return team_name;
    }

    /**
     * @param team_name, with the name of the team
     */

    public void setTeam_name(String team_name)
    {
        this.team_name = team_name;
    }

    /**
     *
     * @return the object Lineup
     */

    public Lineup[] getLineup()
    {
        return lineup;
    }
    /**
     *
     * @param lineup, with the object lineup
     */

    public void setLineup(Lineup[] lineup)
    {
        this.lineup = lineup;
    }

    @Override
    public String toString()
    {
        return "Format [team_id=" + team_id + ", team_name=" + team_name + ", lineup=" + Arrays.toString(lineup) + "]";
    }

}