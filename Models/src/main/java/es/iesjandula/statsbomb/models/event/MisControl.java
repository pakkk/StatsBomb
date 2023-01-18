package es.iesjandula.statsbomb.models.event;

public class MisControl
{

    /**
     * Attribute -
     *
     */
    private Boolean aerial_won;

    /**
     * Default Constructor
     */
    public MisControl() {
    }

    /**
     * @return
     */
    public Boolean isAerial_won() {
        return aerial_won;
    }

    /**
     * @param aerial_won
     */
    public void setAerial_won(Boolean aerial_won) {
        this.aerial_won = aerial_won;
    }

    /**
     * @return the instance of Miscontrol as String
     */
    @Override
    public String toString() {
        return "Miscontrol{" +
                "aerial_won=" + aerial_won +
                '}';
    }
}
