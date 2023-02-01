package es.iesjandula.statsbomb.models.event.foul_commited;

import es.iesjandula.statsbomb.models.event.Event;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * 
 * Carry events are typically by the attacking team and
 * describe a player possessing the ball at their feet,
 * either moving with the ball or standing still.
 */
@Entity
@Table(name = "carry")
public class Carry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attribute -
     * Recorded for all carry events,
     * describes where the carry ends.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "end_location")
    private List<Integer> end_location;
    @OneToOne(mappedBy = "carry")
    private Event event;

    /**
     * Default constructor
     */
    public Carry()
    {

    }

    /**
     * @return the end location of the carry.
     */
    public List<Integer> getEnd_location()
    {
        return this.end_location;
    }

    /**
     * @param end_location of the carry.
     */
    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    /**
     * @return the instance of Carry
     */
    @Override
    public String toString()
    {
        return "Carry{" + "end_location=" + end_location + '}';
    }
}
