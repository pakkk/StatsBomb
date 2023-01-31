package es.iesjandula.statsbomb.models.event;

import es.iesjandula.statsbomb.models.event.foul_commited.FoulCommited;
import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * The card thatt was obtained by a player
 * during the match
 */
@Entity
@Table(name = "card")
public class Card
{
    /**
     * Attribute -
     * id of the Card
     */
    @Id
    @Column(length = 10)
    private int id; // id
    /**
     * Attribute -
     * name of the option specifying the card.
     * (yellow Card, second yellow, red Card)
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToOne
    private BadBehaviour badBehaviour;
    @OneToOne
    private FoulCommited foulCommited;
    /**
     * Default Constructor
     */
    Card()
    {

    }

    /**
     * @return the id of a Card
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id of a card
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name of the option specifying card
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name of the option specifying card
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
