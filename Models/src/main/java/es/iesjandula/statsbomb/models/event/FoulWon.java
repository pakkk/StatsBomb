package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Manuel Canio Gil
 */
@Entity
@Table(name = "foul_won")
public class FoulWon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attributes -
     * Defensive: Added if the foul was won
     * when out of possession.
     * Advantage: Added if play continued
     * (referee called advantage)
     */
    @Column(name = "defensive")
    private Boolean defensive;
    @Column(name = "advantage")
    private Boolean advantage;

    /* Attribute - If the Foul is Penalty */
    @Column(name = "penalty")
    private boolean penalty;

    /**
     * Empty Constructor
     */
    FoulWon()
    {

    }

    /**
     *
     * @return the information about the advantage
     */
    public Boolean getAdvantage()
    {
        return advantage;
    }

    /**
     * @param advantage with the information about the advantage
     */
    public void setAdvantage(Boolean advantage)
    {
        this.advantage = advantage;
    }

    /**
     * @return the information about the defensive
     */
    public Boolean getDefensive()
    {
        return defensive;
    }

    /**
     * @param defensive with the information the defensive
     */
    public void setDefensive(Boolean defensive)
    {
        this.defensive = defensive;
    }

    /* @return the information about the penalty */
    public Boolean isPenalty()
    {
        return this.penalty;
    }

    /* @param penalty with the information about the penalty */
    public void setPenalty(Boolean penalty)
    {
        this.penalty = penalty;
    }

    /**
     * @return an instance of the class FoulWon as String
     */
    @Override
    public String toString()
    {
        return "FoulWon{" +
                "defensive=" + defensive +
                '}';
    }
}
