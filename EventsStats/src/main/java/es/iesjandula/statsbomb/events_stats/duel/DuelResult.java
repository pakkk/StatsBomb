package es.iesjandula.statsbomb.events_stats.duel;

public class DuelResult
{

    /**
     * Attribute -
     * Name of the team that play
     * the player
     */
    private String equipo;
    /**
     * Attribute -
     * Name of the player that
     * won more duels than others
     */
    private String nombre;
    /**
     * Attribute -
     * number of duels that won the player
     */
    private int duelos_ganados;

    /**
     * Constrcutor with parameters
     * @param equipo name of the team
     * @param nombre name of the player
     * @param duelos_ganados number of duels won
     */
    public DuelResult(String equipo, String nombre, int duelos_ganados)
    {
        this.equipo = equipo;
        this.nombre = nombre;
        this.duelos_ganados = duelos_ganados;
    }

    /**
     * Default constructor
     */
    public DuelResult()
    {
        this.equipo = "";
        this.nombre = "";
        this.duelos_ganados = 0;
    }

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

    public int getDuelos_ganados()
    {
        return duelos_ganados;
    }

    public void setDuelos_ganados(int duelos_ganados)
    {
        this.duelos_ganados = duelos_ganados;
    }

    /**
     * @return an instance of DuelResult
     */
    @Override
    public String toString()
    {
        return "{" +
                "equipo:'" + equipo + '\'' +
                ", nombre:'" + nombre + '\'' +
                ", duelos_ganados:" + duelos_ganados +
                '}';
    }
}
