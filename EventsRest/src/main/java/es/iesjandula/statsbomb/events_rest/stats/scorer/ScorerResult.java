package es.iesjandula.statsbomb.events_rest.stats.scorer;

/**
 * @author David Armijo
 */
public class ScorerResult {

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
     * Minute in which the goal happened
     */
    private int minuto;

    /**
     * Attribute -
     * Second in which the goal happened
     */
    private int segundo;

    /**
     * Constructor
     */
    public ScorerResult(String equipo, String nombre, int minuto, int segundo) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * @return an instance of DuelResult
     */
    @Override
    public String toString() {
        return "{" +
                "equipo:'" + equipo + '\'' +
                ", nombre:'" + nombre + '\'' +
                ", minuto:" + minuto +
                ", segundo:" + segundo +
                '}';
    }
}
