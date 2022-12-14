package es.iesjandula.statsbomb.models.open_event.shot;

import es.iesjandula.statsbomb.models.open_event.BodyPart;
import es.iesjandula.statsbomb.models.open_event.OutCome;
import es.iesjandula.statsbomb.models.open_event.Technique;
import es.iesjandula.statsbomb.models.open_event.Type;

import java.util.List;
import java.util.UUID;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 */
public class Shot
{

    /* Attribute - Unique pass identifier */
    private UUID key_pass_id;

    /* Attribute - Where the shot ends */
    private List<Integer> end_location;

    /**
     * Attribute
     * Added if the shot was an
     * aerial won
     */
    private Boolean aerial_won;

    /**
     * Attribute
     * Added if the shot followed a
     * dribble
     */
    private Boolean follows_dribble;

    /**
     * Attribute
     * Added if the shot was first
     * touch.
     */
    private Boolean first_time;

    /**
     * Attribute
     * Added if the shot was
     * one-on-one
     */
    private Boolean one_on_one;

    /**
     * Attribute
     * Each shot includes an object
     * called freeze_frame which is
     * an array containing
     * information about relevant
     * players at the time of the shot.
     * Each freezeframe object is a
     * data frame with a row for each
     * player including their location,
     * team, id, name and position id
     * and name.
     */
    private List<FreezeFrame> freeze_frame;

    /**
     * Attribute
     * The StatsBomb expected
     * goals value calculated for the
     * shot.
     */
    private Double statsbomb_xg;

    /**
     * Attribute
     * Added if the shot was
     * deflected
     */
    private Boolean deflected;

    /**
     * Attribute
     * ID / Name of the technique
     * used for the shot.
     */
    private Technique technique;

    /**
     * Attribute
     * Id / Name for the attribute
     * option specifying the outcome
     * of the shot.
     */
    private OutCome outcome;

    /**
     * Attribute
     * Id / Name for the attribute
     * option specifying the type of
     * shot.
     */
    private Type type;

    /**
     * ID / Name of the body part
     * used to shoot.
     */
    private BodyPart body_part;

    /**
     * Default constructor
     */
    Shot()
    {

    }

    /**
     * @return the Deflected Information
     */
    public Boolean getDeflected()
    {
        return this.deflected;
    }

    /**
     * @param deflected With the information on whether the shot is deflected
     */
    public void setDeflected(Boolean deflected)
    {
        this.deflected = deflected;
    }

    /**
     * @return the one_on_one Information
     */
    public Boolean getOne_on_one()
    {
        return this.one_on_one;
    }

    /**
     * @param one_on_one With the information on whether the shot is one on one
     */
    public void setOne_on_one(Boolean one_on_one)
    {
        this.one_on_one = one_on_one;
    }

    /**
     * @return the Body Part information
     */
    public BodyPart getBody_part()
    {
        return this.body_part;
    }

    /**
     * @param body_part With the information of the body part used
     */
    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    /**
     * @return the Type Information
     */
    public Type getType()
    {
        return this.type;
    }

    /**
     * @param type With the information of the type of Shot
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * @return the Outcome Information
     */
    public OutCome getOutcome()
    {
        return this.outcome;
    }

    /**
     * @param outcome With the information of the Outcome of the shot
     */
    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    /**
     * @return the Technique Information
     */
    public Technique getTechnique()
    {
        return this.technique;
    }

    /**
     * @param technique With the information of the Technique used
     */
    public void setTechnique(Technique technique)
    {
        this.technique = technique;
    }

    /**
     * @return the Key Pass ID Information
     */
    public UUID getKey_pass_id()
    {
        return this.key_pass_id;
    }

    /**
     * @param key_pass_id With the information of the Identifier unique of the Shoot
     */
    public void setKey_pass_id(UUID key_pass_id)
    {
        this.key_pass_id = key_pass_id;
    }

    /**
     * @return the Coordinate where shot ends
     */
    public List<Integer> getEnd_location()
    {
        return this.end_location;
    }

    /**
     * @param end_location With the information of the Coordinate where shot ends
     */
    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    /**
     * @return the Aerial_won information
     */
    public Boolean getAerial_won()
    {
        return this.aerial_won;
    }

    /**
     * @param aerial_won With the information on whether the shot is aerial_won
     */
    public void setAerial_won(Boolean aerial_won)
    {
        this.aerial_won = aerial_won;
    }

    /**
     * @return the Follows Dribble Information on whether the shot is Follows_dribble
     */
    public Boolean getFollows_dribble()
    {
        return this.follows_dribble;
    }

    /**
     * @param follows_dribble With the information about Shot is Follows Dribble
     */
    public void setFollows_dribble(Boolean follows_dribble)
    {
        this.follows_dribble = follows_dribble;
    }

    /**
     * @return the First Time Information whether the shot is First_time
     */
    public Boolean getFirst_time()
    {
        return this.first_time;
    }

    /**
     * @param first_time With the information about Shot is first_time
     */
    public void setFirst_time(Boolean first_time)
    {
        this.first_time = first_time;
    }

    /**
     * @return the Freeze Frame Information the shot
     */
    public List<FreezeFrame> getFreeze_frame()
    {
        return this.freeze_frame;
    }

    /**
     * @param freeze_frame With the Freeze Frame Information
     */
    public void setFreeze_frame(List<FreezeFrame> freeze_frame)
    {
        this.freeze_frame = freeze_frame;
    }

    /**
     * @return the StatsBomb_xg Infomations
     */
    public Double getStatsbomb_xg()
    {
        return this.statsbomb_xg;
    }

    /**
     * @param statsbomb_xg  The StatsBomb expected
     *                      goals value calculated for the
     *                      shot.
     */
    public void setStatsbomb_xg(Double statsbomb_xg)
    {
        this.statsbomb_xg = statsbomb_xg;
    }

    /**
     * @return ToString
     */
    @Override
    public String toString()
    {
        return "Shot{" +
                "key_pass_id=" + this.key_pass_id +
                ", end_location=" + this.end_location +
                ", aerial_won=" + this.aerial_won +
                ", follows_dribble=" + this.follows_dribble +
                ", first_time=" + this.first_time +
                ", one_on_one=" + this.one_on_one +
                ", freeze_frame=" + this.freeze_frame +
                ", statsbomb_xg=" + this.statsbomb_xg +
                ", deflected=" + this.deflected +
                ", technique=" + this.technique +
                ", outcome=" + this.outcome +
                ", type=" + this.type +
                ", body_part=" + this.body_part +
                '}';
    }
}
