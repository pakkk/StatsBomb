package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 *
 * Block describe if ball was blocked
 */
public class Block
{
    /**
     * Attribute -
     * boolean if the ball was blocked
     */
    private Boolean block;
    /**
     * Attribute -
     * boolean if the ball was defended
     */
    private Boolean offensive;

    /**
     * Default Constructor
     */
    Block ()
    {

    }

    /**
     * @return the boolean if the ball was defended
     */
    public Boolean getOffensive()
    {
        return offensive;
    }

    /**
     * @param offensive if the ball was defended
     */
    public void setOffensive(Boolean offensive)
    {
        this.offensive = offensive;
    }

    /**
     * @return the boolean if the ball was blocked
     */
    public Boolean getBlock()
    {
        return block;
    }

    /**
     * @param block if the ball was blocked
     */
    public void setBlock(Boolean block)
    {
        this.block = block;
    }
}
