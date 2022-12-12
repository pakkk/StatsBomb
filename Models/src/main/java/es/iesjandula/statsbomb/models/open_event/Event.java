package es.iesjandula.statsbomb.models.open_event;

import es.iesjandula.statsbomb.common.date_utils.DateUtils;
import es.iesjandula.statsbomb.models.open_event.foul_commited.Carry;
import es.iesjandula.statsbomb.models.open_event.foul_commited.FoulCommited;
import es.iesjandula.statsbomb.models.open_event.pass.Pass;
import es.iesjandula.statsbomb.models.open_event.shot.Shot;
import es.iesjandula.statsbomb.models.open_event.substitution.Substitution;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Event
{

    private String id;
    private int index;
    private int period;
    private String timestamp;
    private Date timestampDate;
    private int minute;
    private int second;
    private Type type;
    private int possession;
    private Team possession_team;
    private PlayPattern play_pattern;
    private Team team;
    private Player player;
    private Position position;
    private List<Integer> location;
    private Double duration;
    private Boolean under_pressure;
    private Boolean off_camera;
    private Boolean out;
    private List<UUID> related_events;
    private Tactics tactics;
    private BallReceipt ball_receipt;
    private BallRecovery ball_recovery;
    private Carry carry;
    private Clearance clearance;
    private Dribble dribble;
    private Duel duel;
    private Goalkeeper goalkeeper;
    private InjuryStoppage injury_stoppage;
    private Interception interception;
    private Pass pass;
    private Shot shot;
    private Boolean counterpress;
    private FoulWon foul_won;
    private FoulCommited foul_committed;
    private Block block;
    private Substitution substitution;

    public Event()
    {

    }

    public Substitution getSubstitution()
    {
        return substitution;
    }

    public void setSubstitution(Substitution substitution)
    {
        this.substitution = substitution;
    }

    public Block getBlock()
    {
        return block;
    }

    public void setBlock(Block block)
    {
        this.block = block;
    }

    public FoulCommited getFoul_committed()
    {
        return foul_committed;
    }

    public void setFoul_committed(FoulCommited foul_committed)
    {
        this.foul_committed = foul_committed;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getIndex()
    {
        return this.index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getPeriod()
    {
        return this.period;
    }

    public void setPeriod(int period)
    {
        this.period = period;
    }

    public String getTimestamp()
    {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        DateUtils utils = new DateUtils();
        this.timestampDate = utils.convertStringToDate(timestamp);
        this.timestamp = timestamp;
    }

    public int getMinute()
    {
        return this.minute;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public int getSecond()
    {
        return this.second;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public Type getType()
    {
        return this.type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public int getPossession()
    {
        return this.possession;
    }

    public void setPossession(int possession)
    {
        this.possession = possession;
    }

    public Team getPossession_team()
    {
        return this.possession_team;
    }

    public void setPossession_team(Team possession_team)
    {
        this.possession_team = possession_team;
    }

    public PlayPattern getPlay_pattern()
    {
        return this.play_pattern;
    }

    public void setPlay_pattern(PlayPattern play_pattern)
    {
        this.play_pattern = play_pattern;
    }

    public Team getTeam()
    {
        return this.team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public List<Integer> getLocation()
    {
        return this.location;
    }

    public void setLocation(List<Integer> location)
    {
        this.location = location;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    public Boolean getUnder_pressure()
    {
        return this.under_pressure;
    }

    public void setUnder_pressure(Boolean under_pressure)
    {
        this.under_pressure = under_pressure;
    }

    public Boolean getOff_camera()
    {
        return this.off_camera;
    }

    public void setOff_camera(Boolean off_camera)
    {
        this.off_camera = off_camera;
    }

    public Boolean getOut()
    {
        return this.out;
    }

    public void setOut(Boolean out)
    {
        this.out = out;
    }

    public List<UUID> getRelated_events()
    {
        return this.related_events;
    }

    public void setRelated_events(List<UUID> related_events)
    {
        this.related_events = related_events;
    }

    public Tactics getTactics()
    {
        return this.tactics;
    }

    public void setTactics(Tactics tactics)
    {
        this.tactics = tactics;
    }

    public BallReceipt getBall_receipt()
    {
        return this.ball_receipt;
    }

    public void setBall_receipt(BallReceipt ball_receipt)
    {
        this.ball_receipt = ball_receipt;
    }

    public BallRecovery getBall_recovery()
    {
        return this.ball_recovery;
    }

    public void setBall_recovery(BallRecovery ball_recovery)
    {
        this.ball_recovery = ball_recovery;
    }

    public Carry getCarry()
    {
        return this.carry;
    }

    public void setCarry(Carry carry)
    {
        this.carry = carry;
    }

    public Clearance getClearance()
    {
        return this.clearance;
    }

    public void setClearance(Clearance clearance)
    {
        this.clearance = clearance;
    }

    public Dribble getDribble()
    {
        return this.dribble;
    }

    public void setDribble(Dribble dribble)
    {
        this.dribble = dribble;
    }

    public Duel getDuel()
    {
        return this.duel;
    }

    public void setDuel(Duel duel)
    {
        this.duel = duel;
    }

    public Goalkeeper getGoalkeeper()
    {
        return this.goalkeeper;
    }

    public void setGoalkeeper(Goalkeeper goalkeeper)
    {
        this.goalkeeper = goalkeeper;
    }

    public InjuryStoppage getInjury_stoppage()
    {
        return this.injury_stoppage;
    }

    public void setInjury_stoppage(InjuryStoppage injury_stoppage)
    {
        this.injury_stoppage = injury_stoppage;
    }

    public Interception getInterception()
    {
        return this.interception;
    }

    public void setInterception(Interception interception)
    {
        this.interception = interception;
    }

    public Pass getPass()
    {
        return this.pass;
    }

    public void setPass(Pass pass)
    {
        this.pass = pass;
    }

    public Shot getShot()
    {
        return this.shot;
    }

    public void setShot(Shot shot)
    {
        this.shot = shot;
    }

    public Date getTimestampDate()
    {
        return timestampDate;
    }

    public void setTimestampDate(Date timestampDate)
    {
        this.timestampDate = timestampDate;
    }

    public Boolean getCounterpress()
    {
        return counterpress;
    }

    public void setCounterpress(Boolean counterpress)
    {
        this.counterpress = counterpress;
    }

    public FoulWon getFoul_won()
    {
        return foul_won;
    }

    public void setFoul_won(FoulWon foul_won)
    {
        this.foul_won = foul_won;
    }

    @Override
    public String toString()
    {
        return "Event{" +
                "id='" + id + '\'' +
                ", index=" + index +
                ", period=" + period +
                ", timestamp=" + timestamp +
                ", minute=" + minute +
                ", second=" + second +
                ", type=" + type +
                ", possession=" + possession +
                ", possession_team=" + possession_team +
                ", play_pattern=" + play_pattern +
                ", team=" + team +
                ", player=" + player +
                ", position=" + position +
                ", location=" + location +
                ", duration=" + duration +
                ", under_pressure=" + under_pressure +
                ", off_camera=" + off_camera +
                ", out=" + out +
                ", related_events=" + related_events +
                ", tactics=" + tactics +
                ", ball_receipt=" + ball_receipt +
                ", ball_recovery=" + ball_recovery +
                ", carry=" + carry +
                ", clearance=" + clearance +
                ", dribble=" + dribble +
                ", duel=" + duel +
                ", goalkeeper=" + goalkeeper +
                ", injury_stoppage=" + injury_stoppage +
                ", interception=" + interception +
                ", pass=" + pass +
                ", shot=" + shot +
                '}';
    }

}
