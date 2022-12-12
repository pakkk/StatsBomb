package es.iesjandula.statsbomb.models.open_event;


import java.util.List;

public class Goalkeeper
{

    private Position position;
    private Technique technique;
    private BodyPart body_part;
    private Type type;
    private OutCome outcome;
    private List<Integer> end_location;

    public Goalkeeper()
    {

    }

    public List<Integer> getEnd_location()
    {
        return end_location;
    }

    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Technique getTechnique()
    {
        return this.technique;
    }

    public void setTechnique(Technique technique)
    {
        this.technique = technique;
    }

    public BodyPart getBody_part()
    {
        return this.body_part;
    }

    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    public Type getType()
    {
        return this.type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public OutCome getOutcome()
    {
        return this.outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

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
