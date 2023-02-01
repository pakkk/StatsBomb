package es.iesjandula.statsbomb.events_rest.stats.possession;

public class ResultadoPorcentajesPossesion
{
    private Posesion posesion;


    public ResultadoPorcentajesPossesion()
    {
        this.posesion = new Posesion();
    }

    public Posesion getPosesion()
    {
        return posesion;
    }

    public void setPosesion(Posesion posesion)
    {
        this.posesion = posesion;
    }

    @Override
    public String toString() {
        return "ResultadoPorcentajesPossesion{" +
                "posesion=" + posesion +
                '}';
    }
}
