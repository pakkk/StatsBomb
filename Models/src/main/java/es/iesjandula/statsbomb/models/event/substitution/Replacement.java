package es.iesjandula.statsbomb.models.event.substitution;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Alejandro Aljarilla
 * @author Oscar Herruzo
 * @version 1.0.0
 * @since 01/12/2022
 * 
 */
@Entity
@Table(name = "replacement")
public class Replacement
{
    /**
     * Attribute -
     * Id from Replacement
     */
    @Id
    @Column(length = 10)
    private int id; 
    /**
     * Attribute -
     * Name of replacement
     */
    @Column(length = 30)
    private String name;

    @OneToOne(mappedBy = "replacement")
    private Substitution substitution;
    /**
     * Empty Constructor
     */
    public Replacement()
    {

    }
    /**
     * @return the id about the replacement
     */
    public int getId()
    {
        return id;
    }

    /**
     *
     * @param id with the id about the replacement
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return the information, about the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name, about the replacement
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
