package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @author Nacho Belda
 * This class will almacenates the Outcome
 */
public class OutCome
{
    /**
     * Attributes -
     * id -> Will be the identifier of the outcome
     * name -> Will be the name of the Outcome
     */
    private int id; // id
    private String name; // name of the Outcome

    /**
     * Empty constructor
     */
    public OutCome()
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
     * @return an instance about the class Outcome as String
     */
    @Override
    public String toString()
    {
        return "OutCome{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
