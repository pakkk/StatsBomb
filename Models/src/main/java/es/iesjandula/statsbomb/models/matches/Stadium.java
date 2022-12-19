package es.iesjandula.statsbomb.models.matches;

public class Stadium
{
    private int id;
    private String name;

    public Stadium()
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
    public String toString()
    {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
