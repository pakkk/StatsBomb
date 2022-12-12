package es.iesjandula.statsbomb.models.open_event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 29/11/2022
 * Clase que almacena el tipo de Evento que se a realizado
 */
public class Type
{
    private int id; // id
    private String name; // name of the event type

    public Type()
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
        return "Type{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
