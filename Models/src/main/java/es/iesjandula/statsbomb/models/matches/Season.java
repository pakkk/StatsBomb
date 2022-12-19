package es.iesjandula.statsbomb.models.matches;

public class Season
{
    private int id;
    private String name;

    public Season()
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
        return "Season{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
