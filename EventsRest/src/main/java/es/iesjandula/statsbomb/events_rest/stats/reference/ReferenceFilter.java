package es.iesjandula.statsbomb.events_rest.stats.reference;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.event.Event;

public class ReferenceFilter
{
	/**
	 * method to take reference playters in each match
	 *
	 * @param eventList listEvents
	 * @return the players who are the more referent based to pass they do in match
	 */
	public String referencia(List<Event> eventList) throws StatsBombException
	{
		// VARIABLES TO GET SAVE THE RESULTS
		ResultReference referencia;
		ResultReference referencia2;
		// Create the object mapper
		ObjectMapper mapper = Json.mapper();

		// LIST WHATH TAKES THE JSON FILE
		List<EventJson> eventoPases = new ArrayList<EventJson>();

		// LOGIC PART
		int x = 0;
		for (Event event : eventList)
		{
			if (event.getType().getId() == 42)
			{
				EventJson eventJson = new EventJson();

				eventJson.setMinute(event.getMinute());
				eventJson.setSecond(event.getSecond());
				eventJson.setTeam(event.getTeam());
				eventJson.setPlayer(event.getPlayer());
				eventJson.setShot(event.getShot());
				eventJson.setType(event.getType());
				eventoPases.add(eventJson);
				x++;
			}
		}
		EventJson jugadorConMasPasesUno = new EventJson();
		EventJson jugadorConMasPasesDos = new EventJson();
		int maximoUno = 0;
		int maximoDos = 0;
		// TAKE RESULTS FIRST COUNTRY
		for (int y = 0; y < eventoPases.size(); y++)
		{
			int cantidadDos = 0;
			int cantidadUno = 0;
			for (int k = y; k < eventoPases.size(); k++)
			{
				if (eventoPases.get(y).getTeam().getName().equalsIgnoreCase(eventoPases.get(1).getTeam().getName()))
				{
					if (eventoPases.get(y).getPlayer().getName()
							.equalsIgnoreCase(eventoPases.get(k).getPlayer().getName()))
					{
						cantidadDos++;
					}
					if (cantidadDos > maximoDos)
					{
						jugadorConMasPasesUno = eventoPases.get(y);
						maximoDos = cantidadDos;
					}
				} // TAKE RESULTS FROM THE OTHER COUNTRY
				else
				{
					if (eventoPases.get(y).getPlayer().getName()
							.equalsIgnoreCase(eventoPases.get(k).getPlayer().getName()))
					{
						cantidadUno++;
					}
					if (cantidadUno > maximoUno)
					{
						jugadorConMasPasesDos = eventoPases.get(y);
						maximoUno = cantidadUno;
					}
				}
			}
		}
		// RESULTS FOR SPAIN AND ITALY
		List<ResultReference> jugadores = new ArrayList<ResultReference>();
		if (jugadorConMasPasesUno.getTeam() != null)
		{
			referencia = new ResultReference(jugadorConMasPasesUno.getTeam().getName(),
					jugadorConMasPasesUno.getPlayer().getName(), maximoDos);
			jugadores.add(referencia);
		}

		if (jugadorConMasPasesDos.getTeam() != null)
		{
			referencia2 = new ResultReference(jugadorConMasPasesDos.getTeam().getName(),
					jugadorConMasPasesDos.getPlayer().getName(), maximoUno);
			jugadores.add(referencia2);
		}

		// RETURN ARRAYLIST
		JsonUtils jsonUtils = new JsonUtils();

		String jsonReferencia = jsonUtils.writeObjectToJsonAsStringPretty(jugadores);

		return jsonReferencia;
	}
}
