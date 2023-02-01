package es.iesjandula.statsbomb.models.event;


import java.util.List;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * @author Manuel Canio Gil
 * This class will almacenate the information about the GoalKeepers
 */
@Entity
@Table(name = "goalkeeper")
public class Goalkeeper
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attributes -
     * Id / Name for the attribute
     * option of goalkeeper’s
     * positioning before a shot.
     */
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Position position;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Technique technique;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BodyPart body_part;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Type type;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private OutCome outcome;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 10)
    private List<Integer> end_location;

    /* Attribute - shot_saved_to_post of Goalkeeper */
    @Column(name = "shot_saved_to_post")
    private Boolean shot_saved_to_post;

    /* Attribute - shot_saved_to_post of Goalkeeper */
    @Column(name = "shot_saved_off_target")
    private Boolean shot_saved_off_target;
    @OneToOne
    private Event event;


    /**
     * Empty constructor
     */
    public Goalkeeper()
    {

    }

    /**
     * @return the information about the end location
     */
    public List<Integer> getEnd_location()
    {
        return end_location;
    }

    /**
     * @param end_location with the information about the end location
     */
    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    /**
     * @return position  with the information about the information
     */
    public Position getPosition()
    {
        return this.position;
    }

    /**
     * @param position with the information about the position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * @return the information about the Techniqye
     */
    public Technique getTechnique()
    {
        return this.technique;
    }

    /**
     * @param technique with the information about the Technique
     */
    public void setTechnique(Technique technique)
    {
        this.technique = technique;
    }

    /**
     * @return with the information about the body_part
     */
    public BodyPart getBody_part()
    {
        return this.body_part;
    }

    /**
     * @param body_part with the information about the body_part
     */
    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    /**
     * @return with the information about the type
     */
    public Type getType()
    {
        return this.type;
    }

    /**
     * @param type with the information about the type
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * @return the information about the outcome
     */
    public OutCome getOutcome()
    {
        return this.outcome;
    }

    /**
     * @param outcome with the information about the outcome
     */
    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    /**
     * @return the information about the shot_saved_to_post
     */
    public Boolean isShot_saved_to_post()
    {
        return this.shot_saved_to_post;
    }

    /**
     * @param shot_saved_to_post with the information about the shot_saved_to_post
     */
    public void setShot_saved_to_post(Boolean shot_saved_to_post)
    {
        this.shot_saved_to_post = shot_saved_to_post;
    }

    public Boolean getShot_saved_to_post()
    {
        return this.shot_saved_to_post;
    }

    public Boolean getShot_saved_off_target()
    {
        return this.shot_saved_off_target;
    }

    public void setShot_saved_off_target(Boolean shot_saved_off_target)
    {
        this.shot_saved_off_target = shot_saved_off_target;
    }

    /**
     * @return an instance of the class GoalKeeper as String
     */
    @Override
    public String toString()
    {
        return "Goalkeeper{" +
                "position=" + position +
                ", technique=" + technique +
                ", body_part=" + body_part +
                ", type=" + type +
                ", outcome=" + outcome +
                '}';
    }
}
