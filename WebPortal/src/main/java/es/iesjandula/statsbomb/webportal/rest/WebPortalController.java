package es.iesjandula.statsbomb.webportal.rest;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.webportal.Json;
import es.iesjandula.statsbomb.webportal.models.FilterJson;

import es.iesjandula.statsbomb.webportal.models.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Joaquin Moreno
 * @author Jesus Garcia Puerto
 */
@CrossOrigin(maxAge = 3600)
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
	 * This endPoint return the index page of the web portal.
	 *
	 * @return statistics page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/about_us")
	public String showAboutUs()
	{

		return "about_us.html";

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
		Type type = null;

		// fill the list with the object save in the JSON indicate
		try
		{
			ObjectMapper mapper = Json.mapper();

			type = mapper.readValue(Paths.get("WebPortal" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "endpoint.json").toFile(), new TypeReference<Type>()
			{
			});

			if (type == null)
			{
				throw new StatsBombException("500","Error al leer el fichero JSON");
			}
		}
		catch (StreamReadException streamReadException)
		{
			streamReadException.printStackTrace();
		}
		catch (DatabindException databindException)
		{
			databindException.printStackTrace();
		}
		catch (StatsBombException statsBombException)
		{
			statsBombException.printStackTrace();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}


		// instance of JsonUtils
		JsonUtils jsonUtils = new JsonUtils();

		// convert the list in a String in format JSON
		String json = jsonUtils.writeObjectToJsonAsStringPretty(type);

		return ResponseEntity.ok().body(json);
	}
}
