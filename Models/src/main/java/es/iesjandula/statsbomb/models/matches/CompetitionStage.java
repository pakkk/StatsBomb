package es.iesjandula.statsbomb.models.matches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Oscar Herruzo
 * @author Manuel Canio Gil
 * Added to reference the phase of the competition this particular match is in
 */
@Entity
@Table(name = "competition_stage")
public class CompetitionStage
{
	 /**
     * Attribute -
     * The unique identifier for the competition.
     */
    @Id
    @Column(length = 10)
    private int id;
    
	 /**
     * Attribute -
     * The name of the competition.
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
	 /**
     * Empty constructor
     */
    public CompetitionStage()
    {
    }
    
    /**
     * @return The unique identifier for the competition.
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * @param  id, id of the competition.
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * @return The name of the competition.
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param  name, name of the competition.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return a instance of competition stage as string
     */
    @Override
    public String toString()
    {
        return "CompetitionStage{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
