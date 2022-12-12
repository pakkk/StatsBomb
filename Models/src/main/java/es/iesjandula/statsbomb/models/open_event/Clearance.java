package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Clearance
{
    private Boolean aerial_won;
    private BodyPart body_part;
    private BodyPart clearance;
    private Boolean right_foot;
    private Boolean left_foot;
    private Boolean head;

    public Clearance()
    {

    }

    public Boolean getLeft_foot()
    {
        return left_foot;
    }

    public void setLeft_foot(Boolean left_foot)
    {
        this.left_foot = left_foot;
    }

    public Boolean getHead()
    {
        return head;
    }

    public void setHead(Boolean head)
    {
        this.head = head;
    }

    public Boolean getAerial_won()
    {
        return this.aerial_won;
    }

    public void setAerial_won(Boolean aerial_won)
    {
        this.aerial_won = aerial_won;
    }

    public BodyPart getBody_part()
    {
        return this.body_part;
    }

    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    public BodyPart getClearance()
    {
        return clearance;
    }

    public void setClearance(BodyPart clearance)
    {
        this.clearance = clearance;
    }

    public Boolean getRight_foot()
    {
        return right_foot;
    }

    public void setRight_foot(Boolean right_foot)
    {
        this.right_foot = right_foot;
    }

    @Override
    public String toString()
    {
        return "Clearance{" + "aerial_won=" + aerial_won + ", body_part=" + body_part + '}';
    }
}
