package es.iesjandula.statsbomb.models.open_event;


import es.iesjandula.statsbomb.models.open_event.tactics.Lineup;

import java.util.List;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * In this Class Storage the Position
 */
public class Tactics
{
    /**
     * Attributes -
     * For events of type (Starting
     * XI or Tactical Shift), the
     * “tactics” object is added.
     * The formation item
     * describes the formation
     * being used.
     */
    public String formation;
    private List<Lineup> lineup;

    /**
     * Empty constructor
     */
    public Tactics()
    {

    }

    /**
     * @return the information about the formation
     */
    public String getFormation()
    {
        return this.formation;
    }

    /**
     * @param formation with the information about the information
     */
    public void setFormation(String formation)
    {
        this.formation = formation;
    }

    /**
     * @return lineup with the information about the lineup
     */
    public List<Lineup> getLineup()
    {
        return this.lineup;
    }

    /**
     * @param lineup with the information aboput the lineup
     */
    public void setLineup(List<Lineup> lineup)
    {
        this.lineup = lineup;
    }

    /**
     * @return a instance of the class Tactics as String
     */
    @Override
    public String toString()
    {
        return "Tactics{" + "formation='" + formation + '\'' + ", lineup=" + lineup + '}';
    }
}
