package es.iesjandula.statsbomb.events_stats.goalkeeper;

public class ResultGoalkeeper
{
    private String equipo;
    private String nombre;
    private int pases;

    public String getEquipo()
    {
        return equipo;
    }

    public void setEquipo(String equipo)
    {
        this.equipo = equipo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getPases()
    {
        return pases;
    }

    public void setPases(int pases)
    {
        this.pases = pases;
    }

    @Override
    public String toString()
    {
        return "PorteroJugador{" +
                "equipo='" + equipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pases=" + pases +
                '}';
    }
}
