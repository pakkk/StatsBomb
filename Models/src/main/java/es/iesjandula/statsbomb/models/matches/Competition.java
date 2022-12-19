package es.iesjandula.statsbomb.models.matches;

public class Competition
{
    private int id;
    private String name;

    public Competition()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
