package es.iesjandula.statsbomb.models.open_event;

public class Technique
{

    private int id; // id
    private String name; // name of the Technique

    public Technique()
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
        return "Technique{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
