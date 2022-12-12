package es.iesjandula.statsbomb.models.open_event.pass;
/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 30/11/2022
 * In this Class Storage the Position
 */
public class Heigth
{
    private int id; // id
    private String name; // name of the Heigth

    public Heigth()
    {

    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Heigth{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
