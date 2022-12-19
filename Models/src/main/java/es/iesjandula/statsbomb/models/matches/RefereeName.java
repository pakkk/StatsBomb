package es.iesjandula.statsbomb.models.matches;

public class RefereeName
{
    private int id;
    private String name;

    public RefereeName()
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
        return "RefereeName{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
