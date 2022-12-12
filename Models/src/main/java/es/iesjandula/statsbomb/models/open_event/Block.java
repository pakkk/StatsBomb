package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class Block
{
    private Boolean block;
    private Boolean offensive;



    Block ()
    {

    }

    public Boolean getOffensive()
    {
        return offensive;
    }

    public void setOffensive(Boolean offensive)
    {
        this.offensive = offensive;
    }

    public Boolean getBlock()
    {
        return block;
    }

    public void setBlock(Boolean block)
    {
        this.block = block;
    }
}
