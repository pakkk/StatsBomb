package es.iesjandula.statsbomb.models.open_event;


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
     * Position -> Will be the information about the position
     * Technique -> Will be the information about the Technique
     * Body_Part ->Will be the information about the BodyPart
     * Type -> Will be the information about the Type
     * Outcome -> Will be the information about the outcome
     * End_Location -> Will be the information about the end_location
     */
    private Position position;
    private Technique technique;
    private BodyPart body_part;
    private Type type;
    private OutCome outcome;
    private List<Integer> end_location;

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
