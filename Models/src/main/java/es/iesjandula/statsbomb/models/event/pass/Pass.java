package es.iesjandula.statsbomb.models.event.pass;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.iesjandula.statsbomb.models.event.*;
import es.iesjandula.statsbomb.models.event.BodyPart;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


import java.util.List;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Martín
 * @author Alejandro Aljarilla
 *
 * When using passes it is important to look at the pass
 * type and the pass outcome to see what occurred.
 */
@Entity
@Table(name = "pass")
public class Pass {
    /**
     * Attribute -
     * Recorded whenever the
     * recipient of the pass is clear.
     */
	
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private Recipient recipient;

    /**
     * Attribute -
     * The length in yards of the pass,
     * from its origin to its destination.
     */
    @Column(length = 4)
    private double length;

    /**
     * Attribute -
     * The angle of the pass in radians
     */
    @Column(length = 4)
    private double angle;

    /**
     * Attribute -
     * specifying the height of the pass.
     */
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private Heigth heigth;

    /**
     * Attribute -
     * Array containing two integer
     * values. These are the x and y
     * coordinates at which the pass
     * ended
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "end_location")
    private List<Integer> end_location;

    /**
     * Attribute -
     * Reference to the shot this
     * pass assisted.
     */
    @Id
    @Column(length = 15)
    private String assisted_shot_id;

    /**
     * Attribute -
     * Added if the pass was made
     * by using a backheel
     */
    @Column(length = 1)
    private Boolean backheel;

    /**
     * Attribute -
     * Added if the pass was deflected
     */
    @Column(length = 1)
    private Boolean deflected;

    /**
     * Attribute -
     * Added if the pass was a miscommunication.
     */
    @Column(length = 1)
    private Boolean miscommunication;

    /**
     * Attribute -
     * Added if the pass was a cross.
     */
    @Column(length = 1)
    private Boolean cross;

    /**
     * Attribute -
     * Added if the pass was a "cut
     * back" (ball passed low
     * backwards, within the
     * opposition's penalty box).
     */
    @Column(length = 1)
    private Boolean cut_back;

    @JsonProperty("switch")
    /**
     * Attribute -
     * Added if the pass was a switch
     * (ball transitioned at least 50%
     * of the pitch vertically).
     */
    @Column(length = 1)
    private Boolean switchParam;

    /**
     * Attribute -
     * Added if the pass was an
     * assist to a shot (that did not
     * score a goal).
     */
    @Column(length = 1)
    private Boolean shot_assist;

    /**
     * Attribute -
     * Added if the pass was an
     * assist to a goal.
     */
    @Column(length = 1)
    private Boolean goal_assist;

    /**
     * Attribute -
     * the body part used to make this pass
     */
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private BodyPart body_part;

    /**
     * Attribute -
     * specifying the type of pass.
     */
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private Type type;

    /**
     * Attribute -
     * the outcome of the pass.
     */
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private OutCome outcome;


    /**
     * Attribute -
     * the technique of the pass.
     */
    @OneToOne
    @JoinColumn(name = "assisted_shot_id", referencedColumnName = "id")
    private Technique technique;

    /**
     * Attribute -
     * Pass cuts last line of defence
     */
    @Column(length = 1)
    private Boolean through_ball;

    /**
     * Attribute -
     * For outswinging corner kicks.
     */
    @Column(length = 1)
    private Boolean outswinging;

    /**
     * Attribute -
     * Added if the shot resulted
     * from an aerial win
     */
    @Column(length = 1)
    private Boolean aerial_won;

    /**
     * Attribute -
     * A player deliberately let the pass
     * go past him instead of receiving it
     * to deliver it to a teammate behind him.
     */
    @Column(length = 1)
    private Boolean no_touch;

    /**
     * Attribute -
     * For inswinging corner kicks.
     */
    @Column(length = 1)
    private Boolean inswinging;

    /**
     * Attribute -
     *
     *
     */
    @Column(length = 1)
    private Boolean straight;

    @OneToOne(mappedBy = "pass")
    private Event event;

    /**
     * Default constructor
     */
    public Pass() {

    }

    /**
     * @return the inswinging corner kicks
     */
    public Boolean getInswinging() {
        return inswinging;
    }

    /**
     * @param inswinging, with the inswinging corner kicks
     */
    public void setInswinging(Boolean inswinging) {
        this.inswinging = inswinging;
    }

    /**
     * @return If the player attempted to do the dribble by passing the ball
     */
    public Boolean getNo_touch() {
        return no_touch;
    }
    /**
     * @param no_touch, If the player attempted to do the dribble by passing the ball
     */

    public void setNo_touch(Boolean no_touch) {
        this.no_touch = no_touch;
    }

    /**
     * @return  Recorded if the clearance was accomplished by winning an aerial
     */
    public Boolean getAerial_won() {
        return aerial_won;
    }

    /**
     * @param aerial_won, recorded if the clearance was accomplished by winning an aerial
     */
    public void setAerial_won(Boolean aerial_won) {
        this.aerial_won = aerial_won;
    }

    /**
     * @return For outswinging corner kicks.
     */
    public Boolean getOutswinging() {
        return outswinging;
    }

    /**
     * @param outswinging, with outswinging corner kicks.
     */
    public void setOutswinging(Boolean outswinging) {
        this.outswinging = outswinging;
    }

    /**
     * @return Name specifying the player id of the recipient of the pass
     */
    public Recipient getRecipient() {
        return this.recipient;
    }

    /**
     * @param recipient, with the name specifying the player id of the recipient of the pass
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    /**
     * return The length in yards of the pass
     */

    public double getLength() {
        return this.length;
    }

    /**
     * @param length, with the length in yards of the pass
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * return the angle of the pass in radians
     */

    public double getAngle() {
        return this.angle;
    }

    /**
     * @param angle, with the angle of the pass in radians
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * return Id / Name specifying the height of the pass.

     */

    public Heigth getHeigth() {
        return this.heigth;
    }

    /**
     * @param heigth, with the  Id / Name specifying the height of the pass
     */
    public void setHeight(Heigth heigth) {
        this.heigth = heigth;
    }

    /**
     * return these are the x and y coordinates at which the pass ended
     */

    public List<Integer> getEnd_location() {
        return this.end_location;
    }

    /**
     * @param end_location, with the x and y coordinates at which the pass ended
     */
    public void setEnd_location(List<Integer> end_location) {
        this.end_location = end_location;
    }

    /**
     * return Reference to the shot this pass assisted.

     */
    public String getAssisted_shot_id() {
        return this.assisted_shot_id;
    }

    /**
     * @param assisted_shot_id, with the reference to the shot this pass assisted
     */
    public void setAssisted_shot_id(String assisted_shot_id) {
        this.assisted_shot_id = assisted_shot_id;
    }

    /**
     * return Added if the pass was made by using a backheel
     */
    public Boolean getBackheel() {
        return this.backheel;
    }

    /**
     * @param backheel, with the added if the pass was made by using a backheel
     */
    public void setBackheel(Boolean backheel) {
        this.backheel = backheel;
    }

    /**
     * return added if the pass was deflected
     */
    public Boolean getDeflected() {
        return this.deflected;
    }

    /**
     * @param deflected, with the pass was deflected
     */
    public void setDeflected(Boolean deflected) {
        this.deflected = deflected;
    }

    /**
     * return if the pass was a miscommunication.
     */
    public Boolean getMiscommunication() {
        return this.miscommunication;
    }

    /**
     * @param miscommunication, if the pass was a miscommunication.
     */
    public void setMiscommunication(Boolean miscommunication) {
        this.miscommunication = miscommunication;
    }

    /**
     * return if the pass was a cross
     */

    public Boolean getCross() {
        return this.cross;
    }

    /**
     * @param cross, if the pass was a cross
     */
    public void setCross(Boolean cross) {
        this.cross = cross;
    }

    /**
     * return if the pass was a cut back
     */

    public Boolean getCut_back() {
        return this.cut_back;
    }

    /**
     * @param cut_back, Added if the pass was a "cut back"
     */
    public void setCut_back(Boolean cut_back) {
        this.cut_back = cut_back;
    }

    @JsonProperty("switch")
    /**
     * return if the pass was a switch
     */
    public Boolean getSwitchParam() {
        return this.switchParam;
    }

    @JsonProperty("switch")
    /**
     * @param switchParam, if the pass was a switch
     */
    public void setSwitchParam(Boolean switchParam) {
        this.switchParam = switchParam;
    }

    /**
     * return if the pass was an assist to a shot
     */
    public Boolean getShot_assist() {
        return this.shot_assist;
    }

    /**
     * @param shot_assist, if the pass was an assist to a shot
     */
    public void setShot_assist(Boolean shot_assist) {
        this.shot_assist = shot_assist;
    }

    /**
     * return if the pass is a goal assist
     */
    public Boolean getGoal_assist() {
        return this.goal_assist;
    }

    /**
     * @param goal_assist, if the pass is a goal assist
     */
    public void setGoal_assist(Boolean goal_assist) {
        this.goal_assist = goal_assist;
    }

    /**
     * return Name of the body part used to make this pass.
     */
    public BodyPart getBody_part() {
        return this.body_part;
    }

    /**
     * @param body_part, with name of the body part used to make this pass.
     */
    public void setBody_part(BodyPart body_part) {
        this.body_part = body_part;
    }

    /**
     * return Id / Name for the attribute option specifying the type of pass.
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @param type, with the Id / Name for the attribute option specifying the type of pass.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * return  ID / Name of the outcome of the pass.
     */
    public OutCome getOutcome() {
        return this.outcome;
    }

    /**
     * @param outcome, with ID / Name of the outcome of the pass.
     */
    public void setOutcome(OutCome outcome) {
        this.outcome = outcome;
    }

    /**
     * return Name of the technique of the pass.
     */
    public Technique getTechnique() {
        return this.technique;
    }

    /**
     * @param technique, with the name of the technique of the pass.
     */
    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    /**
     * return if pass cuts last line of defence
     */
    public Boolean getThrough_ball() {
        return through_ball;
    }

    /**
     * @param through_ball, with the pass cuts last line of defence
     */
    public void setThrough_ball(Boolean through_ball) {
        this.through_ball = through_ball;
    }

    /**
     * @return
     */
    public Boolean getStraight() {
        return straight;
    }

    /**
     * @param straight
     */
    public void setStraight(Boolean straight) {
        this.straight = straight;
    }

    /**
     * @return the instance of Pass as String
     */
    @Override
    public String toString() {
        return "Pass{" +
                "recipient=" + recipient +
                ", length=" + length +
                ", angle=" + angle +
                ", heigth=" + heigth +
                ", end_location=" + end_location +
                ", assisted_shot_id=" + assisted_shot_id +
                ", backheel=" + backheel +
                ", deflected=" + deflected +
                ", miscommunication=" + miscommunication +
                ", cross=" + cross +
                ", cut_back=" + cut_back +
                ", switchParam=" + switchParam +
                ", shot_assist=" + shot_assist +
                ", goal_assist=" + goal_assist +
                ", body_part=" + body_part +
                ", type=" + type +
                ", outcome=" + outcome +
                ", technique=" + technique +
                ", through_ball=" + through_ball +
                ", outswinging=" + outswinging +
                ", aerial_won=" + aerial_won +
                ", no_touch=" + no_touch +
                ", inswinging=" + inswinging +
                ", straight=" + straight +
                '}';
    }
}