package es.iesjandula.statsbomb.webportal.rest;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.webportal.Json;
import es.iesjandula.statsbomb.webportal.models.Type;
import es.iesjandula.statsbomb.webportal.models.modelsSecurity.User;
import es.iesjandula.statsbomb.webportal.security.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Joaquin Moreno
 * @author Jesus Garcia Puerto
 */
@CrossOrigin(maxAge = 3600)
@RequestMapping(produces = { "application/json" })
@Controller
public class WebPortalController
{

	@Autowired
	private UserService userService;

	/**
	 * This endPoint return the index page of the web portal.
	 *
	 * @return index page
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"/index", "/"})
	public ModelAndView showIndex()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}


	/**
	 * this method is used to show login.html page
	 *
	 * @return the login.html page
	 */
	@GetMapping(value =  "/login")
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/**
	 * This endPoint return the Who We Are page of the web portal.
	 *
	 * @return who_we_are page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/who_we_are")
	public ModelAndView showWhoWeAre()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("who_we_are");
		return modelAndView;
	}

	/**
	 * This endPoint return the What We Do page of the web portal.
	 *
	 * @return what_we_do page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/what_we_do")
	public ModelAndView showWhatWeDo()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("what_we_do");
		return modelAndView;
	}

	/**
	 * This endPoint return the index page of the web portal.
	 *
	 * @return statistics page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/statistics")
	public ModelAndView showStatistics()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("statistics");
		return modelAndView;
	}

	/**
	 * This endPoint return the index page of the web portal.
	 *
	 * @return statistics page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/about_us")
	public ModelAndView showAboutUs()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about_us");
		return modelAndView;
	}


	/**
	 * this method is used to show registration.html page
	 *
	 * @return the registration.html page
	 */
	@GetMapping(value = "/register")
	public ModelAndView registration()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}

	/**
	 * this method is used to create a new user
	 *
	 * @param user         the user to be created
	 * @param bindingResult the result of the binding
	 * @return the registration.html page
	 */
	@PostMapping(value = "/register")
	public ModelAndView createNewUser(@Validated User user, BindingResult bindingResult)
	{
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUserName(user.getUserName());
		if (userExists != null)
		{
			bindingResult
					.rejectValue("userName", "error.user",
							"There is already a user registered with the user name provided");
		}
		if (bindingResult.hasErrors())
		{
			modelAndView.setViewName("register");
		} else
		{
			user.setStasdistics_number(10);
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("register");
		}
		return modelAndView;
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
