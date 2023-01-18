package es.iesjandula.statsbomb.events_stats.possession;

public class PartidoCompleto
{
    private double espana;
    private double italia;

    public double getEspana()
    {
        return espana;
    }

    public void setEspana(double espana)
    {
        this.espana = espana;
    }

    public double getItalia()
    {
        return italia;
    }

    public void setItalia(double italia)
    {
        this.italia = italia;
    }


    @Override
    public String toString()
    {
        return "PartidoCompleto{" +
                "espana=" + espana +
                ", italia=" + italia +
                '}';
    }
}
