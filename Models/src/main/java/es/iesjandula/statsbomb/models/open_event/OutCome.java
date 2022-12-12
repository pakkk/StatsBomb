package es.iesjandula.statsbomb.models.open_event;

public class OutCome
{

    private int id; // id
    private String name; // name of the Outcome

    public OutCome()
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
        return "OutCome{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
