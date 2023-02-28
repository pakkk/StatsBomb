package es.iesjandula.statsbomb.webportal.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.webportal.repositorySecurity.IUserRepository;

/**
 * ------------------------------------------------
 *
 * @author API Rest Generator ------------------------------------------------
 */
@CrossOrigin(maxAge = 3600)
@RequestMapping(produces = { "application/json" })
@RestController //
public class WebPortalRest
{
	@Autowired
	IUserRepository userRepository;

	/**
	 * Logger
	 */
	private final Logger LOGGER = LogManager.getLogger();

	@RequestMapping(method = RequestMethod.GET, value = "/statistics_available")
	public ResponseEntity<?> getStatistics() throws StatsBombException
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails)
		{
			userDetails = (UserDetails) principal;
		}
		// GET THE USER NAME
		String userName = userDetails.getUsername();
		// GET THE STATISTICS NUMBER AVAIBLES
		Integer availableStatistics = userRepository.findByUserName(userName).getStasdistics_number();
		// RETURN STATEMENT
		return ResponseEntity.ok(availableStatistics);
	}
}