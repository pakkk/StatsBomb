package es.iesjandula.statsbomb.events_stats.reference;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;

public class ReferenceFilter
{
	// METHOD FOR REFERENCIA
	public List <ResultReference> referencia(String jsonNombre) throws StatsBombException {
		// VARIABLES TO GET SAVE THE RESULTS
		ResultReference referencia;
		ResultReference referencia2;
				// Create the object mapper
				ObjectMapper mapper = Json.mapper();
				ObjectWriter writer = Json.mapper().writer(new DefaultPrettyPrinter());
				// IGNORA LOS ELEMENTOS DEL JSON QUE NO ESTEN DEFINIDOS COMO ATRIBUTOS EN MI CLASE
				// OBJECT MAPPER AND JSON CONFIGURATIONS
				mapper.configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
				mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				// LIST WHATH TAKES THE JSON FILE
						List<EventJson> eventoPases = new ArrayList<EventJson>();
						List<EventJson> outcomeList = null;
						try
						{
							outcomeList = mapper.readValue(Paths.get(jsonNombre).toFile(), mapper.getTypeFactory().constructCollectionType(List.class, EventJson.class));
						}
						catch (StreamReadException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (DatabindException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					// LOGIC PART	
					int x = 0;
					for(int i=0; i< outcomeList.size(); i++)
					{
						if(outcomeList.get(i).getType().getId()==42)
						{
							 System.out.println(outcomeList.get(i).toString() );
							 System.out.println(x);
							 eventoPases.add(outcomeList.get(i));
							 x++;
						}	
					}
					EventJson jugadorConMasPasesUno = new EventJson();
					EventJson jugadorConMasPasesDos = new EventJson();
					 int  maximoUno = 0; int maximoDos = 0;String nombre = "";
					//TAKE RESULTS FROM SPAIN
						for(int y = 0; y<eventoPases.size(); y++)
						{
							 int cantidadDos = 0; int cantidadUno = 0;
							for(int k = y; k<eventoPases.size(); k++)
							{
								if(eventoPases.get(y).getTeam().getName().equalsIgnoreCase("spain"))	
								{
									if(eventoPases.get(y).getPlayer().getName().equalsIgnoreCase(eventoPases.get(k).getPlayer().getName()))
									{
										cantidadDos++;
									}
									if(cantidadDos>maximoDos)
									{
										jugadorConMasPasesUno = eventoPases.get(y);
										 maximoDos = cantidadDos;
									}
								} //TAKE RESULTS FROM ITALY
								else 
								{
									if(eventoPases.get(y).getPlayer().getName().equalsIgnoreCase(eventoPases.get(k).getPlayer().getName()))
									{
										cantidadUno++;
									}
									if(cantidadUno>maximoUno)
									{
										jugadorConMasPasesDos = eventoPases.get(y);
										 maximoUno = cantidadUno;
									}
								}
							}
						}
						// RESULTS FOR SPAIN AND ITALY
						List<ResultReference> jugadores = new ArrayList<ResultReference>();
						System.out.println("EL jugador con mas pases de España es " + jugadorConMasPasesUno.getPlayer().getName() + " con un total de " + maximoDos + " pases y de Italia es " + jugadorConMasPasesDos.getPlayer().getName() + " con un total de " + maximoUno + " pases"); 
						referencia = new ResultReference(jugadorConMasPasesUno.getTeam().getName(), jugadorConMasPasesUno.getPlayer().getName(), maximoDos);
						referencia2 = new ResultReference(jugadorConMasPasesDos.getTeam().getName(), jugadorConMasPasesDos.getPlayer().getName(),maximoUno);
						jugadores.add(referencia);
						jugadores.add(referencia2);
						// RETURN ARRAYLIST
						return jugadores;
	}
}
