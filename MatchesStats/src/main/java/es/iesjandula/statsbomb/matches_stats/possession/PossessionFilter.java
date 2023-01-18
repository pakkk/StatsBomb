package es.iesjandula.statsbomb.matches_stats.possession;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;

import es.iesjandula.statsbomb.models.event.Event;
import es.iesjandula.statsbomb.models.results.ResultListPosesionFilter;
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
        String jsonListPosesionOfMatch = "";

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
        String jsonListPosesionOfMatch = "";
        ResultadoPorcentajesPossesion resultado = new ResultadoPorcentajesPossesion();

        double primerTiempoSpain = 0.0;
        double segundoTiempoSpain = 0.0;
        double primerTiempoItaly = 0.0;
        double segundoTiempoItaly = 0.0;

        for(Event event:eventListOfMatch)
        {
            if(event.getTeam().getName().equals("Spain"))
            {
                if(event.getPeriod() == 1)
                {
                    primerTiempoSpain += event.getDuration();

                }
                else if(event.getPeriod() == 2)
                {
                    segundoTiempoSpain += event.getDuration();
                }
            }
            else
            {
                if(event.getPeriod() == 1)
                {
                    primerTiempoItaly += event.getDuration();

                }
                else if(event.getPeriod() == 2)
                {
                    segundoTiempoItaly += event.getDuration();
                }
            }
            PrimerTiempo primerTiempo = new PrimerTiempo();
            primerTiempo.setEspana(100 / ((primerTiempoSpain + primerTiempoItaly) / primerTiempoSpain));
            primerTiempo.setItalia(100 / ((primerTiempoSpain + primerTiempoItaly) / primerTiempoItaly));

            resultado.setPrimer_tiempo(primerTiempo);


            SegundoTiempo segundoTiempo = new SegundoTiempo();
            segundoTiempo.setEspana(100 / ((segundoTiempoSpain + segundoTiempoItaly) / segundoTiempoSpain));
            segundoTiempo.setItalia(100 / ((segundoTiempoSpain + segundoTiempoItaly) / segundoTiempoItaly));

            resultado.setSegundo_tiempo(segundoTiempo);

            PartidoCompleto partidoCompleto = new PartidoCompleto();
            partidoCompleto.setEspana((primerTiempo.getEspana()+segundoTiempo.getEspana())/2);
            partidoCompleto.setItalia((primerTiempo.getItalia()+segundoTiempo.getItalia())/2);

            resultado.setPartido_completo(partidoCompleto);


        }
        JsonUtils jsonUtils = new JsonUtils();

        jsonListPosesionOfMatch = jsonUtils.writeObjectToJsonAsStringPretty(resultado);

        return jsonListPosesionOfMatch;
    }

}
