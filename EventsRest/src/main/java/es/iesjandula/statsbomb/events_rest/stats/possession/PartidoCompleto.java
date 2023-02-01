package es.iesjandula.statsbomb.events_rest.stats.possession;

public class PartidoCompleto
{
    double spain;
    double italy;

    public PartidoCompleto(double spain, double italy)
    {
        this.spain = spain;
        this.italy = italy;
    }

    public PartidoCompleto()
    {
        this.spain = -1;
        this.italy = -1;
    }

    public double getSpain()
    {
        return spain;
    }

    public void setSpain(double spain)
    {
        this.spain = spain;
    }

    public double getItaly()
    {
        return italy;
    }

    public void setItaly(double italy)
    {
        this.italy = italy;
    }

    @Override
    public String toString()
    {
        return "PartidoCompleto{" +
                "spain=" + spain +
                ", italy=" + italy +
                '}';
    }
}
