package es.iesjandula.statsbomb.events_rest.stats.possession;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;

import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.events_rest.stats.results.ResultListPosesionFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Neil Hdez
 */
public class PossessionFilter
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * This method obtains a list of the possessions made during the selected match in a list by possession.
     * @param eventListOfMatch List Of Events
     * @return A list of the possessions made during possession
     * @throws StatsBombException
     */
    public String getListPosesion(List<Event> eventListOfMatch) throws StatsBombException
    {
        /* Reult of Posesion */
        String jsonListPosesionOfMatch;

        Map<Integer, ResultListPosesionFilter> mapPossesion = new HashMap<>(); // Storage of possesión and Result


        for (Event event : eventListOfMatch)
        {
            if (!mapPossesion.containsKey(event.getPossession())) // If not exist int map, we storage the new data
            {
                mapPossesion.put(event.getPossession(), new ResultListPosesionFilter()); // We create the result
                mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName()); // we add the action
                mapPossesion.get(event.getPossession()).setTeam(event.getTeam().getName()); // We add the name of the team
                mapPossesion.get(event.getPossession()).setPosession(event.getPossession()); // We add the number possesion

            } else // Is exist only we add the new action
            {
                mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName());
            }
        }

        JsonUtils jsonUtils = new JsonUtils();

        jsonListPosesionOfMatch = jsonUtils.writeObjectToJsonAsStringPretty(mapPossesion);

        return jsonListPosesionOfMatch;
    }

    public String getPorcentageOfPossesion(List<Event> eventListOfMatch)  throws StatsBombException
    {
        double primerTiempoSpain = 0;
        double segundoTiempoSpain = 0;
        double primerTiempoItaly = 0;
        double segundoTiempoItaly = 0;
        double total = 0;
        String jsonListPosesionOfMatch = "";
        ResultadoPorcentajesPossesion resultado = new ResultadoPorcentajesPossesion();

        for (Event event: eventListOfMatch)
        {
            if (event.getDuration() != null)
            {

                total = total + event.getDuration();

                if (event.getPossession_team().getName().equals("Spain"))
                {
                    if (event.getPeriod() == 1)
                    {
                        primerTiempoSpain = primerTiempoSpain + event.getDuration();
                    } else if (event.getPeriod() == 2)
                    {
                        segundoTiempoSpain = segundoTiempoSpain + event.getDuration();
                    }
                }

                if (event.getPossession_team().getName().equals("Italy"))
                {
                    if (event.getPeriod() == 1)
                    {
                        primerTiempoItaly = primerTiempoItaly + event.getDuration();
                    } else if (event.getPeriod() == 2)
                    {
                        segundoTiempoItaly = segundoTiempoItaly + event.getDuration();
                    }
                }
            }
        }

        double porcentajeSpainPrimerTiempo = 100 / ((primerTiempoSpain + primerTiempoItaly) / primerTiempoSpain);
        double porcentajeItalyPrimerTiempo = 100 / ((primerTiempoSpain + primerTiempoItaly) / primerTiempoItaly);
        double porcentajeSpainSegundoTiempo = 100 / ((segundoTiempoSpain + segundoTiempoItaly) / segundoTiempoSpain);
        double porcentajeItalySegundoTiempo = 100 / ((segundoTiempoSpain + segundoTiempoItaly) / segundoTiempoItaly);
        double porcentajeSpainTotal = (porcentajeSpainPrimerTiempo + porcentajeSpainSegundoTiempo) / 2;
        double porcentajeItalyTotal = (porcentajeItalyPrimerTiempo + porcentajeItalySegundoTiempo) / 2;

        resultado.getPosesion().setPrimer_tiempo(new PrimerTiempo(porcentajeSpainPrimerTiempo,porcentajeItalyPrimerTiempo));
        resultado.getPosesion().setSegundo_tiempo(new SegundoTiempo(porcentajeSpainSegundoTiempo,porcentajeItalySegundoTiempo));
        resultado.getPosesion().setPartido_completo(new PartidoCompleto(porcentajeSpainTotal,porcentajeItalyTotal));


        JsonUtils jsonUtils = new JsonUtils();

        jsonListPosesionOfMatch = jsonUtils.writeObjectToJsonAsStringPretty(resultado);

        return jsonListPosesionOfMatch;
    }

}
