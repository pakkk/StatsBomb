package es.iesjandula.statsbomb.models.event;

import es.iesjandula.statsbomb.models.event.foul_commited.FoulCommited;
import es.iesjandula.statsbomb.models.event.pass.Pass;
import es.iesjandula.statsbomb.models.event.shot.Shot;
import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Alejandro Aljarilla
 * This class almacenates the type of event
 */
@Entity
@Table(name = "type")
public class Type
{
    /**
     * Attributes -
     * Id / Name for the attribute
     * option specifying the type of
     * goalkeeper event. (Every shot
     * will have a related goalkeeper
     * event. If a goal is not
     * conceded or a save is not
     * made, the goalkeeper type will
     * be “Shot Faced”).
     */
    @Id
    @Column(length = 10)
    private int id; // id
    @Column(length = 25)
    private String name; // name of the event type

    @OneToOne
    private Shot shot;

    @OneToOne
    private Pass pass;

    @OneToOne
    private FoulCommited foulCommited;

    
    @OneToOne
    private Goalkeeper goalkeeper;

    @OneToOne
    private Duel duel;
    @OneToOne
    private Event event;

    /**
     * Empty constructor
     */
    public Type()
    {

    }

    /**
     * @return the information about the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id with the information about the id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the information about the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name with the information about the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return a instance of the type as String
     */
    @Override
    public String toString()
    {
        return "Type{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
