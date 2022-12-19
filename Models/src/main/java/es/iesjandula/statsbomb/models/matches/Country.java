package es.iesjandula.statsbomb.models.matches;

public class Country
{
    private int id;
    private String name;

    public Country()
    {
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
