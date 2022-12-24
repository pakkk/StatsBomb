package es.iesjandula.statsbomb.models.event;

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

    /* Attribute - boolean if the block has deflected the ball */
    private Boolean deflection;

    /**
     * Default Constructor
     */
    Block ()
    {

    }

    /**
     * @return if the block has deflected the ball
     */
    public Boolean getDeflection()
    {
        return deflection;
    }

    /**
     * @param deflection with the information about of block if the block has deflected the ball
     */
    public void setDeflection(Boolean deflection)
    {
        this.deflection = deflection;
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
