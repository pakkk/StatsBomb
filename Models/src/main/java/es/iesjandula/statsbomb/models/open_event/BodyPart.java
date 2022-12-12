package es.iesjandula.statsbomb.models.open_event;

public class BodyPart
{

    private int id; // id
    private String name; // name of the body part

    public BodyPart()
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
        return "BodyPart{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
