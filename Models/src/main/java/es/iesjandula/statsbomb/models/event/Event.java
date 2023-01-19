package es.iesjandula.statsbomb.models.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.iesjandula.statsbomb.common.utils.DateUtils;
import es.iesjandula.statsbomb.models.event.foul_commited.Carry;
import es.iesjandula.statsbomb.models.event.foul_commited.FoulCommited;
import es.iesjandula.statsbomb.models.event.pass.Pass;
import es.iesjandula.statsbomb.models.event.shot.Shot;
import es.iesjandula.statsbomb.models.event.substitution.Substitution;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Neil Hdez
 * @author Joaquin Moreno
 * @author Alejandro Aljarilla
 * @author Manuel Canio Gil
 *
 */
@Entity
@Table(name = "event")
public class Event
{

    /** Attribute - The unique identifier for the competition. */
    @Id
    @Column(name = "id", length = 160)
    private String id;

    /**
     * Attribute
     * Sequence notation for the ordering of
     * events within each match
     */
    @Column(name = "index", length = 10)
    private int index;

    /** Attribute - The part of the match the timestamp relates to. */
    @Column(name = "period", length = 5)
    private int period;

    /**
     * Attribute
     * Time in the match the event takes
     * place, recorded to the millisecond.
     */
    @Column(name = "timestap", length = 13)
    private String timestamp;

    /**
     * Attribute
     * Time in the match the event takes
     * place, recorded to the millisecond.
     */
    private Date timestampDate;

    /**
     * Attribute
     * The minutes on the clock at the time
     * of this event. Resets to 45 at halftime, 90 at the start of extra time etc.
     */
    @Column(name = "minute", nullable = false)
    private int minute;

    /** Attribute - The second part of the timestamp */
    @Column(name = "second", nullable = false)
    private int second;

    /** Attribute - The type of event the corresponds to.  */
    private Type type;

    /**
     * Attribute
     * Indicates the current unique possession in the game. A single
     * possession denotes a period of play in which the ball is in play
     * and a single team is in control of the ball.
     */
    @Column(name = "possession", nullable = false)
    private int possession;

    /**
     * Attribute
     * The ID and name of the team that started this possession in control of
     * the ball. Note that this will appear even on opposition events like
     * tackles attempted during the possession.
     */
    private Team possession_team;

    /** Attribute - Id /name of the play pattern relevant to this event. */
    private PlayPattern play_pattern;

    /**
     * Attribute
     * Id / Name of the team this event relates to. Team object will only
     * display if the event is tied to a specific team.
     */
    private Team team;

    /**
     * Attribute
     * Id / Name of the player this event relates to (player object will only
     * display if the event is tied to a specific player).
     */
    private Player player;

    /** Atribute - Id / Name of the position the player was in at the time of this event. */
    private Position position;

    /**
     * Attribute
     * Array containing two integer values.
     * These are the x and y coordinates of
     * the event (this only displays if the
     * event has pitch coordinates).
     */
    private List<Integer> location;

    /** Attribute - If relevant, the length in seconds the event lasted. */
    @Column(name = "duration")
    private Double duration;

    /** Attribute - The action was performed while being pressured by an opponent. */
    @Column(name = "under_pressure")
    private Boolean under_pressure;

    /** Attribute - The event occurred while the camera was off. */
    @Column(name = "off_camera")
    private Boolean off_camera;

    /** Attribute - Added if the outcome of the event is the ball going out of bounds. */
    @Column(name = "out")
    private Boolean out;

    /**
     * Attribute
     * A comma separated list of the Ids of
     * related events. For example, a shot
     * might be related to the Goalkeeper
     * event, and a Block Event. The
     * corresponding events will have the Id
     * of the shot in their related_events
     * column.
     */
    private List<UUID> related_events;

    /**
     *  Attribute
     * For events of type (Starting
     * XI or Tactical Shift), the
     * “tactics” object is added.
     * The formation item
     * describes the formation
     * being used.
     */
    private Tactics tactics;

    /**
     * Attribute - The receipt or intended receipt of a pass */
    private BallReceipt ball_receipt;

    /** Attribute - An attempt to recover a loose ball  */
    private BallRecovery ball_recovery;

    /** Attribute - A player controls the ball at their feet while moving or standing still. */
    private Carry carry;

    /** Attribute - Action by a defending player to clear the danger without an intention to deliver it to a teammate */
    private Clearance clearance;

    /** Attribute - An attempt by a player to beat an opponent */
    private Dribble dribble;

    /** Attribute - A duel is an 50-50 contest between two players of opposing sides in the match. */
    private Duel duel;

    /** Attribute - Actions that can be done by the goalkeeper. */
    private Goalkeeper goalkeeper;

    /** Attribute - A stop in play due to an injury. */
    private InjuryStoppage injury_stoppage;

    /** Attribute
     * Preventing an opponent's pass from reaching their teammates by moving to the passing lane/reacting to
     * intercept it.
     */
    private Interception interception;

    /** Attribute - An intended kick from one player to his teammate */
    private Pass pass;

    /** Attribute - An attempt to score a goal, made with any (legal) part of the body */
    private Shot shot;

    /* Attribute - Pressing actions within 5 seconds  of an open play turnover */
    private Boolean counterpress;

    /* Attribute - Describe the scenario when a player wins a foul */
    private FoulWon foul_won;

    /** Attribute - describe who committed a foul resulting in a free kick or penalty kick. */
    private FoulCommited foul_committed;

    /** Attribute - events typically follow a pass or a shot */
    private Block block;

    /** Attribute - describe the player coming on the pitch, the player coming off the pitch and the reason why. */
    private Substitution substitution;

    /** Attribute - describe the bad behaviour **/
    private BadBehaviour bad_behaviour;

    /* Attribute - misscontrol of Event */
    private MisControl miscontrol;

    /* Attribute - 50_50 of Event */
    @JsonProperty("50_50")
    private FiftyFifty fifty_fifty;

    /**
     * empty constructor
     */
    public Event()
    {

    }


    /**
     * @return the bad behaviour about of an event
     */
    public BadBehaviour getBad_behaviour()
    {
        return bad_behaviour;
    }

    /**
     * @param bad_behaviour with the information about bad behaviour
     */
    public void setBad_behaviour(BadBehaviour bad_behaviour)
    {
        this.bad_behaviour = bad_behaviour;
    }

    /**
     * @return the substitution events
     */
    public Substitution getSubstitution()
    {
        return substitution;
    }

    /**
     * @param substitution with the information about the substitution
     */
    public void setSubstitution(Substitution substitution)
    {
        this.substitution = substitution;
    }

    /**
     * @return the instance of block
     */
    public Block getBlock()
    {
        return block;
    }

    /**
     * @param block with the information about block events typically follow a pass or a shot.
     */
    public void setBlock(Block block)
    {
        this.block = block;
    }

    /**
     * @return the instance of foul_committed
     */
    public FoulCommited getFoul_committed()
    {
        return foul_committed;
    }

    /**
     * @param foul_committed who committed a foul resulting in a free kick or penalty kick.
     */
    public void setFoul_committed(FoulCommited foul_committed)
    {
        this.foul_committed = foul_committed;
    }

    /**
     * @return the event id
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * @param id that is the unique identifier for each event
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return event index
     */
    public int getIndex()
    {
        return this.index;
    }

    /**
     * @param index that is the unique identifier for each event
     */
    public void setIndex(int index)
    {
        this.index = index;
    }

    /**
     * @return the period of the match
     */
    public int getPeriod()
    {
        return this.period;
    }

    /**
     * @param period with the information about the part of the match the timestamp relates to.
     */
    public void setPeriod(int period)
    {
        this.period = period;
    }

    /**
     * @return the information about the time in the match
     */
    public String getTimestamp()
    {
        return this.timestamp;
    }

    /**
     * Format timeStamp HHmmssSSS
     * @param timestamp Date in Format String
     */
    public void setTimestamp(String timestamp)
    {
        DateUtils utils = new DateUtils();
        this.timestampDate = utils.convertStringToDateFormatHHmmssSSS(timestamp);
        this.timestamp = timestamp;
    }

    /**
     * @return the minute of the event
     */
    public int getMinute()
    {
        return this.minute;
    }

    /**
     * @param minute with the information about the minutes on the clock at the time
     * of this event. Resets to 45 at halftime, 90 at the start of extra time etc.
     */
    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    /**
     * @return the second of the event
     */
    public int getSecond()
    {
        return this.second;
    }

    /**
     * @param second with the information about the second part of the timestamp
     */
    public void setSecond(int second)
    {
        this.second = second;
    }

    /**
     * @return the type of the event
     */
    public Type getType()
    {
        return this.type;
    }

    /**
     * @param type with the information about the type of event the corresponds to
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * @return the current possession
     */
    public int getPossession()
    {
        return this.possession;
    }

    /**
     * @param possession with the information indicates the current unique
     * possession in the game.
     */
    public void setPossession(int possession)
    {
        this.possession = possession;
    }

    /**
     * @return the possession team
     */
    public Team getPossession_team()
    {
        return this.possession_team;
    }

    /**
     * @param possession_team with the information about
     * the ID and name of the team that
     * started this possession in control of the ball.
     */
    public void setPossession_team(Team possession_team)
    {
        this.possession_team = possession_team;
    }

    /**
     * @return the play pattern of the event
     */
    public PlayPattern getPlay_pattern()
    {
        return this.play_pattern;
    }

    /**
     * @param play_pattern with the information about the Id /name of the play pattern relevant
     * to this event
     */
    public void setPlay_pattern(PlayPattern play_pattern)
    {
        this.play_pattern = play_pattern;
    }

    /**
     * @return the team
     */
    public Team getTeam()
    {
        return this.team;
    }

    /**
     * @param team with the information about the Id / Name of the team this event
     * relates to. Team object will only display if the event is tied to a
     * specific team
     */
    public void setTeam(Team team)
    {
        this.team = team;
    }

    /**
     * @return the player related to the event
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * @param player with the information about the Id / Name of the player this event
     * relates to (player object will only
     * display if the event is tied to a specific player).
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * @return the position of the player
     */
    public Position getPosition()
    {
        return this.position;
    }

    /**
     * @param position with the information about the Id / Name of the position the player
     * was in at the time of this event..
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * @return the location of the pith
     */
    public List<Integer> getLocation()
    {
        return this.location;
    }

    /**
     * @param location with the coordinates of the event
     */
    public void setLocation(List<Integer> location)
    {
        this.location = location;
    }

    /**
     * @return the duration of the event
     */
    public Double getDuration()
    {
        return this.duration;
    }

    /**
     * @param duration with if relevant, the length in seconds the event lasted.
     */
    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    /**
     * @return if a player is under pressure
     */
    public Boolean getUnder_pressure()
    {
        return this.under_pressure;
    }

    /**
     * @param under_pressure with the information about the action was performed while being pressured by an opponent.
     */
    public void setUnder_pressure(Boolean under_pressure)
    {
        this.under_pressure = under_pressure;
    }

    /**
     * @return if the camera was off or not
     */
    public Boolean getOff_camera()
    {
        return this.off_camera;
    }

    /**
     * @param off_camera with the information about the event occurred while the camera was off.
     */
    public void setOff_camera(Boolean off_camera)
    {
        this.off_camera = off_camera;
    }

    /**
     * @return if the ball is out or not
     */
    public Boolean getOut()
    {
        return this.out;
    }

    /**
     * @param out with the information added if the outcome of the event is the ball going out of bounds
     */
    public void setOut(Boolean out)
    {
        this.out = out;
    }

    /**
     * @return a list of events
     */
    public List<UUID> getRelated_events()
    {
        return this.related_events;
    }

    /**
     * @param related_events with the information about list of the Ids of related events
     */
    public void setRelated_events(List<UUID> related_events)
    {
        this.related_events = related_events;
    }

    /**
     * @return the tactics of the match
     */
    public Tactics getTactics()
    {
        return this.tactics;
    }

    /**
     * @param tactics with the information about Tactical Shift events describe any time
     * the team changes their tactics, whether it be a change in lineup or formation
     */
    public void setTactics(Tactics tactics)
    {
        this.tactics = tactics;
    }

    /**
     * @return the player that receipt the ball
     */
    public BallReceipt getBall_receipt()
    {
        return this.ball_receipt;
    }

    /**
     * @param ball_receipt with the information about the receipt or intended receipt of a pass.
     */
    public void setBall_receipt(BallReceipt ball_receipt)
    {
        this.ball_receipt = ball_receipt;
    }

    /**
     * @return the player that recovery the ball
     */
    public BallRecovery getBall_recovery()
    {
        return this.ball_recovery;
    }

    /**
     * @param ball_recovery with the information about an attempt to recover a loose ball
     */
    public void setBall_recovery(BallRecovery ball_recovery)
    {
        this.ball_recovery = ball_recovery;
    }

    /**
     * @return the player that control the ball
     */
    public Carry getCarry()
    {
        return this.carry;
    }

    /**
     * @param carry with the information about
     * a player controls the ball at their feet while moving or standing still.
     */
    public void setCarry(Carry carry)
    {
        this.carry = carry;
    }

    /**
     * @return clearance
     */
    public Clearance getClearance()
    {
        return this.clearance;
    }

    /**
     * @param clearance with the information about the Action by a defending player to clear
     * the danger without an intention to deliver it to a teammate.
     */
    public void setClearance(Clearance clearance)
    {
        this.clearance = clearance;
    }

    /**
     * @return a instance of Dribble
     */
    public Dribble getDribble()
    {
        return this.dribble;
    }

    /**
     * @param dribble with the information about an attempt by a player to beat an opponent
     */
    public void setDribble(Dribble dribble)
    {
        this.dribble = dribble;
    }

    /**
     * @return a instance of duel
     */
    public Duel getDuel()
    {
        return this.duel;
    }

    /**
     * @param duel with the information about a duel is an 50-50 contest between two players
     * of opposing sides in the match
     */
    public void setDuel(Duel duel)
    {
        this.duel = duel;
    }

    /**
     * @return a instance of Goalkeeper
     */
    public Goalkeeper getGoalkeeper()
    {
        return this.goalkeeper;
    }

    /**
     * @param goalkeeper with the information about a actions that can be done by the goalkeeper
     */
    public void setGoalkeeper(Goalkeeper goalkeeper)
    {
        this.goalkeeper = goalkeeper;
    }

    /**
     * @return a instance of InjuryStoppage
     */
    public InjuryStoppage getInjury_stoppage()
    {
        return this.injury_stoppage;
    }

    /**
     * @param injury_stoppage with the information about a stop in play due to an injury
     */
    public void setInjury_stoppage(InjuryStoppage injury_stoppage)
    {
        this.injury_stoppage = injury_stoppage;
    }

    /**
     * @return a instance of Interception
     */
    public Interception getInterception()
    {
        return this.interception;
    }

    /**
     * @param interception with the information about preventing an opponent's pass
     * from reaching their teammates by moving to the passing lane/reacting to intercept it.
     */
    public void setInterception(Interception interception)
    {
        this.interception = interception;
    }

    /**
     * @return the instance of Pass
     */
    public Pass getPass()
    {
        return this.pass;
    }

    /**
     * @param pass with the instance of Pass
     */
    public void setPass(Pass pass)
    {
        this.pass = pass;
    }

    /**
     * @return the instance of Shot
     */
    public Shot getShot()
    {
        return this.shot;
    }

    /**
     * @param shot with the instance of Shot
     */
    public void setShot(Shot shot)
    {
        this.shot = shot;
    }

    /**
     * @return the time in the match the event takes
     * place, recorded to the millisecond.
     */
    public Date getTimestampDate()
    {
        return timestampDate;
    }

    /**
     * @param timestampDate with the time in the match the event takes
     * place, recorded to the millisecond.
     */
    public void setTimestampDate(Date timestampDate)
    {
        this.timestampDate = timestampDate;
    }

    /**
     * @return if the pressing actions within 5 seconds
     * of an open play turnover
     */
    public Boolean getCounterpress()
    {
        return counterpress;
    }

    /**
     * @param counterpress with if the pressing actions within 5 seconds
     * of an open play turnover
     */
    public void setCounterpress(Boolean counterpress)
    {
        this.counterpress = counterpress;
    }

    /**
     * @return the instance of FoulWon
     */
    public FoulWon getFoul_won()
    {
        return foul_won;
    }

    /**
     * @param foul_won with a instance of FoulWon
     */
    public void setFoul_won(FoulWon foul_won)
    {
        this.foul_won = foul_won;
    }

    /**
     * @return the instance of MisControl
     */
    public MisControl getMiscontrol()
    {
        return this.miscontrol;
    }

    /**
     * @param miscontrol with the instance of MisControl
     */
    public void setMiscontrol(MisControl miscontrol)
    {
        this.miscontrol = miscontrol;
    }

    @JsonProperty("50_50")
    public FiftyFifty getFifty_fifty()
    {
        return this.fifty_fifty;
    }

    @JsonProperty("50_50")
    public void setFifty_fifty(FiftyFifty fifty_fifty)
    {
        this.fifty_fifty = fifty_fifty;
    }

    /**
     * @return a instance of Event with Sring format.
     */
    @Override
    public String toString()
    {
        return "Event{" +
                "id='" + this.id + '\'' +
                ", index=" + this.index +
                ", period=" + this.period +
                ", timestamp=" + this.timestamp +
                ", minute=" + this.minute +
                ", second=" + this.second +
                ", type=" + this.type +
                ", possession=" + this.possession +
                ", possession_team=" + this.possession_team +
                ", play_pattern=" + this.play_pattern +
                ", team=" + this.team +
                ", player=" + this.player +
                ", position=" + this.position +
                ", location=" + this.location +
                ", duration=" + this.duration +
                ", under_pressure=" + this.under_pressure +
                ", off_camera=" + this.off_camera +
                ", out=" + this.out +
                ", related_events=" + this.related_events +
                ", tactics=" + this.tactics +
                ", ball_receipt=" + this.ball_receipt +
                ", ball_recovery=" + this.ball_recovery +
                ", carry=" + this.carry +
                ", clearance=" + this.clearance +
                ", dribble=" + this.dribble +
                ", duel=" + this.duel +
                ", goalkeeper=" + this.goalkeeper +
                ", injury_stoppage=" + this.injury_stoppage +
                ", interception=" + this.interception +
                ", pass=" + this.pass +
                ", shot=" + this.shot +
                '}';
    }

}
