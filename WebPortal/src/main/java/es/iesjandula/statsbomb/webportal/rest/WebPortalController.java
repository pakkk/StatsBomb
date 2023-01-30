package es.iesjandula.statsbomb.webportal.rest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.webportal.Json;
import es.iesjandula.statsbomb.webportal.models.FilterJson;

/**
 * @author Joaquin Moreno
 * @author Jesus Garcia Puerto
 */
@RequestMapping(produces = { "application/json" })
@Controller
public class WebPortalController
{
	/**
	 * This endPoint return the index page of the web portal.
	 *
	 * @return index page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String showIndex()
	{

		return "index.html";

	}

	/**
	 * This endPoint return the Who We Are page of the web portal.
	 *
	 * @return who_we_are page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/who_we_are")
	public String showWhoWeAre()
	{

		return "who_we_are.html";

	}

	/**
	 * This endPoint return the What We Do page of the web portal.
	 *
	 * @return what_we_do page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/what_we_do")
	public String showWhatWeDo()
	{

		return "what_we_do.html";

	}

	/**
	 * This endPoint return the index page of the web portal.
	 *
	 * @return statistics page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/statistics")
	public String showStatistics()
	{

		return "statistics.html";

	}

	/**
	 * Method - This EndPoint return a JSON with all the filter created
	 * 
	 * @return a list of with the different EndPoint in format of JSON
	 * @throws StatsBombException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/lista_endpoint")
	public ResponseEntity<?> getFiltrosJson() throws StatsBombException
	{
		// instance of a List
		List<FilterJson> filterJsons = null;

		// fill the list with the object save in the JSON indicate
		try
		{
			ObjectMapper mapper = Json.mapper();

			filterJsons = mapper.readValue(Paths.get("endpoint.json").toFile(), new TypeReference<List<FilterJson>>()
			{
			});
		}
		catch (StreamReadException streamReadException)
		{
			streamReadException.printStackTrace();
		}
		catch (DatabindException databindException)
		{
			databindException.printStackTrace();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}

		// instance of JsonUtils
		JsonUtils jsonUtils = new JsonUtils();

		// convert the list in a String in format JSON
		String json = jsonUtils.writeObjectToJsonAsStringPretty(filterJsons);

		return ResponseEntity.ok().body(json);
	}
}
