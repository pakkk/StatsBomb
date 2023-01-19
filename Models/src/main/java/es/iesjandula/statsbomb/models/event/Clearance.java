package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * Action by a defending player to clear the danger
 * without an intention to deliver it to a teammate
 */
@Entity
@Table(name = "clearance")
public class Clearance
{
    /**
     * Attribute -
     * if the ball was won in the air
     */
    @Column(name = "aerial_won")
    private Boolean aerial_won;
    /**
     * Attribute -
     * instance of body part to define with what part
     * of the body was won the ball
     */
    private BodyPart body_part;
    /**
     * Attribute -
     * instance of bodyPart if the ball was clearance
     */
    private BodyPart clearance;
    /**
     * Attribute -
     * if the ball was touch with right foot
     */
    @Column(name = "right_foot")
    private Boolean right_foot;
    /**
     * Attribute -
     * if the ball was touch with left foot
     */
    @Column(name = "left_foot")
    private Boolean left_foot;
    /**
     * Attribute -
     * if the ball was touch with head
     */
    @Column(name = "head")
    private Boolean head;

    /**
     * Attribute -
     *
     */
    @Column(name = "other")
    private Boolean other;

    /**
     * Default Constructor
     */
    public Clearance()
    {

    }

    /**
     * @return if the ball was touch with left foot
     */
    public Boolean getLeft_foot()
    {
        return left_foot;
    }

    /**
     * @param left_foot if the ball was touched with that part
     */
    public void setLeft_foot(Boolean left_foot)
    {
        this.left_foot = left_foot;
    }

    /**
     * @return if the ball was touch with head
     */
    public Boolean getHead()
    {
        return head;
    }

    /**
     * @param head if the ball was touched with that part
     */
    public void setHead(Boolean head)
    {
        this.head = head;
    }

    /**
     * @return if the ball was won in the air
     */
    public Boolean getAerial_won()
    {
        return this.aerial_won;
    }

    /**
     * @param aerial_won if the ball was won in the air
     */
    public void setAerial_won(Boolean aerial_won)
    {
        this.aerial_won = aerial_won;
    }

    /**
     * @return instance of BodyPart
     */
    public BodyPart getBody_part()
    {
        return this.body_part;
    }

    /**
     * @param body_part set instance of bodyPart
     */
    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    /**
     * @return instance of BodyPart
     */
    public BodyPart getClearance()
    {
        return clearance;
    }

    /**
     *
     * @param clearance set instance of bodyPart
     */
    public void setClearance(BodyPart clearance)
    {
        this.clearance = clearance;
    }

    /**
     * @return if the ball was touch with right foot
     */
    public Boolean getRight_foot()
    {
        return right_foot;
    }

    /**
     *
     * @param right_foot if the ball was touched with that part
     */
    public void setRight_foot(Boolean right_foot)
    {
        this.right_foot = right_foot;
    }

    /**
     * @return
     */
    public Boolean getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(Boolean other) {
        this.other = other;
    }

    /**
     * @return the instance of Clearance as String
     */
    @Override
    public String toString() {
        return "Clearance{" +
                "aerial_won=" + aerial_won +
                ", body_part=" + body_part +
                ", clearance=" + clearance +
                ", right_foot=" + right_foot +
                ", left_foot=" + left_foot +
                ", head=" + head +
                ", other=" + other +
                '}';
    }
}
