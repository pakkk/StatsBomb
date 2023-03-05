package es.iesjandula.statsbomb.events_rest.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.events_rest.stats.EventsStats;

/**
 * ------------------------------------------------
 *
 * @author API Rest Generator ------------------------------------------------
 */
@RequestMapping(value = "/events", produces = { "application/json" })
@RestController //
@EnableDiscoveryClient
public class RestHandlerEvents
{

	/**
	 * Logger
	 */
	private final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private EventsStats eventsStats;

	@RequestMapping(method = RequestMethod.GET, value = "/goalkeeper")
	public ResponseEntity<?> getGoalkeeperPlayer(
			@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getPlayerGoalkeeper(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}

	}

	/**
	 * Method return Instance of EventStats that returns duels
	 *
	 * @return Instance of EventStats that returns duels
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/duels")
	public ResponseEntity<?> getPlayerDuels(@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getPlayerDuels(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}

	}

	/**
	 * Method return Instance of EventStats that returns scorers
	 *
	 * @return Instance of EventStats that returns scorers
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scorers")
	public ResponseEntity<?> getScorers(@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getPlayerScorers(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			LOGGER.error(statsBombException.getBodyExceptionMessage());
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/possesion")
	public ResponseEntity<?> getListPosesionMatch(
			@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getListOfPossessionOfMatch(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}

	}

	/**
	 * Method return Instance of EventStats that returns reference players
	 * @return Instance of EventStats that returns reference players
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/reference_player")
	public ResponseEntity<?> getListReferencePlayer(
			@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getListOfReferencesPlayers(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/porcentage_possesions")
	public ResponseEntity<?> getPorcentagePossesions(
			@RequestParam(value = "matchId", required = true) final Integer matchId)
	{
		try
		{
			String resultJson = this.eventsStats.getPorcentageOfPossesions(matchId);
			return ResponseEntity.ok().body(resultJson);
		}
		catch (StatsBombException statsBombException)
		{
			return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
		}
		catch (Exception exception)
		{
			StatsBombException statsBombException = new StatsBombException(exception);
			LOGGER.error(statsBombException.getBodyExceptionMessage(), exception);
			return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
		}
	}
}
