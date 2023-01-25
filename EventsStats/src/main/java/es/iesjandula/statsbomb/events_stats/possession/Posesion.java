package es.iesjandula.statsbomb.events_stats.possession;

public class Posesion
{
    PrimerTiempo primer_tiempo;
    SegundoTiempo segundo_tiempo;
    PartidoCompleto partido_completo;

    public Posesion()
    {
        this.primer_tiempo = new PrimerTiempo();
        this.segundo_tiempo = new SegundoTiempo();
        this.partido_completo = new PartidoCompleto();
    }

    public PrimerTiempo getPrimer_tiempo()
    {
        return primer_tiempo;
    }

    public void setPrimer_tiempo(PrimerTiempo primer_tiempo)
    {
        this.primer_tiempo = primer_tiempo;
    }

    public SegundoTiempo getSegundo_tiempo()
    {
        return segundo_tiempo;
    }

    public void setSegundo_tiempo(SegundoTiempo segundo_tiempo)
    {
        this.segundo_tiempo = segundo_tiempo;
    }

    public PartidoCompleto getPartido_completo()
    {
        return partido_completo;
    }

    public void setPartido_completo(PartidoCompleto partido_completo)
    {
        this.partido_completo = partido_completo;
    }

    @Override
    public String toString() {
        return "Posesion{" +
                "primer_tiempo=" + primer_tiempo +
                ", segundo_tiempo=" + segundo_tiempo +
                ", partido_completo=" + partido_completo +
                '}';
    }
}
