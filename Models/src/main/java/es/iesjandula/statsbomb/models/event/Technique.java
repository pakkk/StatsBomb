package es.iesjandula.statsbomb.models.event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class almacenates the technique
 */
public class Technique
{
    /**
     * Attributes -
     * Id/ Name for the attribute
     * option specifying the
     * goalkeeper technique used.
     */
    private int id; // id
    private String name; // name of the Technique

    /**
     * Empty constructor
     */
    public Technique()
    {

    }

    /**
     * @return the information about the id
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @param id with the information about the id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the information about the name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name with the information about the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return a instamce of Technique as String
     */
    @Override
    public String toString()
    {
        return "Technique{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
