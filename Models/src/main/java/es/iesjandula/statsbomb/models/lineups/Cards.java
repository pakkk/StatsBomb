package es.iesjandula.statsbomb.models.lineups;
/**
 *
 * @author Manuel Martin Murillo
 *
 */
public class Cards
{
    /**
     * Attribute
     * The time when the card was given to the player
     */
    private String time;
    /**
     * Attribute
     * The type of the card
     */
    private String card_type;
    /**
     * Attribute
     * The reason of the card
     */
    private String reason;
    /**
     * Attribute
     * The period of the match that the card was given
     */
    private Integer period;
    /**
     * Default contructor
     */
    public Cards()
    {
        super();
        this.time = time;
        this.card_type = card_type;
        this.reason = reason;
        this.period = period;
    }

    /**
     *
     * @return the time when the card was given to the player
     */
    public String getTime()
    {
        return time;
    }
    /**
     *
     * @param time, with the time when the card was given to the player
     */
    public void setTime(String time)
    {
        this.time = time;
    }
    /**
     *
     * @return the type of the card
     */
    public String getCard_type()
    {
        return card_type;
    }
    /**
     *
     * @param card_type, with the type of the card
     */
    public void setCard_type(String card_type)
    {
        this.card_type = card_type;
    }
    /**
     *
     * @return the reason of the card
     */
    public String getReason()
    {
        return reason;
    }
    /**
     *
     * @param reason, with the reason of the card
     */
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    /**
     *
     * @return the period of the match that the card was given
     */
    public Integer getPeriod()
    {
        return period;
    }
    /**
     *
     * @param period, with the period of the match that the card was given
     */
    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    @Override
    public String toString()
    {
        return "Cards [time=" + time + ", card_type=" + card_type + ", reason=" + reason + ", period=" + period + "]";
    }
}
