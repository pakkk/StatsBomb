package es.iesjandula.statsbomb.models.event;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @author Jesus Guerrero
 * @author Manuel Canio Gil
 *
 * Block describe if ball was blocked
 */
@Entity
@Table(name = "block")
public class Block
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Attribute -
     * boolean if the ball was blocked
     */
    @Column(name = "block")
    private Boolean block;

    /**
     * Attribute -
     * boolean if the ball was defended
     */
    @Column(name = "offensive")
    private Boolean offensive;

    /* Attribute - boolean if the block has deflected the ball */
    @Column(name = "deflection")
    private Boolean deflection;

    /* Attribute - if the block is Save_block */
    @Column(name = "save_block")
    private Boolean save_block;
    @OneToOne(mappedBy = "block")
    private Event event;

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

    public Boolean getSave_block()
    {
        return this.save_block;
    }

    public void setSave_block(Boolean save_block)
    {
        this.save_block = save_block;
    }
}
