package es.iesjandula.statsbomb.models.matches;

public class Team
{
    private int id;
    private String name;

    public Team()
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
        return "AwayTeam{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
