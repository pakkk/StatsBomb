package es.iesjandula.statsbomb.models.event;

public class Miscontrol {

    /**
     * Attribute -
     *
     */
    private boolean aerial_won;

    /**
     * Default Constructor
     */
    public Miscontrol() {
    }

    /**
     * @return
     */
    public boolean isAerial_won() {
        return aerial_won;
    }

    /**
     * @param aerial_won
     */
    public void setAerial_won(boolean aerial_won) {
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
