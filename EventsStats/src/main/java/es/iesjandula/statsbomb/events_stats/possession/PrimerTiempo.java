package es.iesjandula.statsbomb.matches_stats.possession;

public class PrimerTiempo
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
        return "PrimerTiempo{" +
                "espana=" + espana +
                ", italia=" + italia +
                '}';
    }
}
