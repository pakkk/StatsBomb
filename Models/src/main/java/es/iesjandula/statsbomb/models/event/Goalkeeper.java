package es.iesjandula.statsbomb.models.event;


import java.util.List;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class will almacenate the information about the GoalKeepers
 */
public class Goalkeeper
{
    /**
     * Attributes -
     * Id / Name for the attribute
     * option of goalkeeper’s
     * positioning before a shot.
     */
    private Position position;
    private Technique technique;
    private BodyPart body_part;
    private Type type;
    private OutCome outcome;
    private List<Integer> end_location;

    /* Attribute - shot_saved_to_post of Goalkeeper */
    private Boolean shot_saved_to_post;

    /* Attribute - shot_saved_to_post of Goalkeeper */
    private Boolean shot_saved_off_target;


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
