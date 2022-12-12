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

    private UUID key_pass_id;
    private List<Integer> end_location;
    private Boolean aerial_won;
    private Boolean follows_dribble;
    private Boolean first_time;
    private Boolean one_on_one;
    private List<FreezeFrame> freeze_frame;
    private Double statsbomb_xg;
    private Technique technique;
    private OutCome outcome;
    private Type type;
    private BodyPart body_part;

    Shot()
    {

    }

    public Boolean getOne_on_one()
    {
        return one_on_one;
    }

    public void setOne_on_one(Boolean one_on_one)
    {
        this.one_on_one = one_on_one;
    }

    public BodyPart getBody_part()
    {
        return body_part;
    }

    public void setBody_part(BodyPart body_part)
    {
        this.body_part = body_part;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public OutCome getOutcome()
    {
        return outcome;
    }

    public void setOutcome(OutCome outcome)
    {
        this.outcome = outcome;
    }

    public Technique getTechnique()
    {
        return technique;
    }

    public void setTechnique(Technique technique)
    {
        this.technique = technique;
    }

    public UUID getKey_pass_id()
    {
        return key_pass_id;
    }

    public void setKey_pass_id(UUID key_pass_id)
    {
        this.key_pass_id = key_pass_id;
    }

    public List<Integer> getEnd_location()
    {
        return end_location;
    }

    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    public Boolean getAerial_won()
    {
        return aerial_won;
    }

    public void setAerial_won(Boolean aerial_won)
    {
        this.aerial_won = aerial_won;
    }

    public Boolean getFollows_dribble()
    {
        return follows_dribble;
    }

    public void setFollows_dribble(Boolean follows_dribble)
    {
        this.follows_dribble = follows_dribble;
    }

    public Boolean getFirst_time()
    {
        return first_time;
    }

    public void setFirst_time(Boolean first_time)
    {
        this.first_time = first_time;
    }

    public List<FreezeFrame> getFreeze_frame()
    {
        return freeze_frame;
    }

    public void setFreeze_frame(List<FreezeFrame> freeze_frame)
    {
        this.freeze_frame = freeze_frame;
    }

    public Double getStatsbomb_xg()
    {
        return statsbomb_xg;
    }

    public void setStatsbomb_xg(Double statsbomb_xg)
    {
        this.statsbomb_xg = statsbomb_xg;
    }
}
