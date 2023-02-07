package es.iesjandula.statsbomb.matches_rest.rest;

import es.iesjandula.statsbomb.matches_rest.stats.id_filter.MatchesIdFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.matches_rest.stats.MatchesStats;
import es.iesjandula.statsbomb.matches_rest.stats.manager_filters.ManagerNationalityFilter;
import es.iesjandula.statsbomb.matches_rest.stats.manager_filters.ManagerScoreFilter;

/**
 * ------------------------------------------------
 *
 * @author API Rest Generator ------------------------------------------------
 */
@CrossOrigin(maxAge = 3600, origins = "http://localhost:8080")
@RequestMapping(value = "/matches", produces = { "application/json" }) // 8084
@RestController //
public class RestHandlerMatches
{

	/**
	 * Logger
	 */
	private final Logger LOGGER = LogManager.getLogger();

	// New Instance of MatchesStats
	@Autowired
	private MatchesStats matchesStats;
	// New Instance of ManagerNationalityFilter
	@Autowired
	private ManagerNationalityFilter managerNationalityFilter;
	// New Instance of ManagerScoreFilter
	@Autowired
	private ManagerScoreFilter managerScoreFilter;


	@RequestMapping(method = RequestMethod.GET, value = "/date")
	public ResponseEntity<?> getListOfMatchesByDate(
			@RequestParam(value = "competitionId", required = true) final Integer competitionId,
			@RequestParam(value = "seasonId", required = true) final Integer seasonId,
			@RequestParam(value = "dateStart", required = true) final String dateStart)
	{
		try
		{
			String resultJson = this.matchesStats.getListOfMatchesByDate(competitionId, seasonId, dateStart);
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

	@RequestMapping(method = RequestMethod.GET, value = "/score")
	public ResponseEntity<?> getManagerScoreFilter(
			@RequestParam(value = "competitionId", required = true) final Integer competitionId,
			@RequestParam(value = "seasonId", required = true) final Integer seasonId)
	{
		try
		{
			String resultJson = this.managerScoreFilter.getManagerScoreFilter(competitionId, seasonId);
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

	@RequestMapping(method = RequestMethod.GET, value = "/managerNationality")
	public ResponseEntity<?> getManagerWithSameNationality(
			@RequestParam(value = "competitionId", required = true) final Integer competitionId,
			@RequestParam(value = "seasonId", required = true) final Integer seasonId
	)
	{
		try
		{
			String resultJson = this.managerNationalityFilter.managersWithDifferentNationalityThatCountry(competitionId,
					seasonId);
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/matches")
	public ResponseEntity<?> getListMatches(
			@RequestParam(value = "competitionId", required = true) final Integer competitionId,
			@RequestParam(value = "seasonId", required = true) final Integer seasonId)
	{
		try
		{
			String resultJson = this.matchesStats.getResultsMatches(competitionId, seasonId);
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

	@RequestMapping(method = RequestMethod.GET, value = "/matchesId")
	public ResponseEntity<?> getMatchesId(
			@RequestParam(value = "competitionId", required = true) final Integer competitionId,
			@RequestParam(value = "seasonId", required = true) final Integer seasonId)
	{
		try
		{
			String resultJson = this.matchesStats.getMatchesId(competitionId, seasonId);
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

	@Bean
	private MatchesStats getMatchesStats()
	{
		return new MatchesStats();
	}

	@Bean
	private ManagerScoreFilter getManagerScoreFilter()
	{
		return new ManagerScoreFilter();
	}

	@Bean
	private ManagerNationalityFilter getManagerWithSameNationality()
	{
		return new ManagerNationalityFilter();
	}
}
