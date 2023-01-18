package es.iesjandula.statsbomb.matches_rest.rest;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.matches_stats.MatchesStats;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ------------------------------------------------
 *
 * @author API Rest Generator
 * ------------------------------------------------
 */
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/matches", produces = {"application/json"})
@RestController //

public class RestHandlerMatches
{

    /**
     * Logger
     */
    private final Logger LOGGER = LogManager.getLogger();

    // New Instance of MatchesStats
    private final MatchesStats matchesStats = this.getMatchesStats();

    @RequestMapping(method = RequestMethod.GET, value = "/list_matches_date/")
    public ResponseEntity<?> getListOfMatchesbyDate(@RequestParam(value="competitionId", required=true) final Integer competitionId,
                                                    @RequestParam(value="seasonId", required=true) final Integer seasonId,
                                                    @RequestParam(value="dateStart", required=true) final String dateStart)
    {
        try
        {
            String resultJson = this.matchesStats.getListOfMatchesByDate(competitionId,seasonId,dateStart);
            return ResponseEntity.ok().body(resultJson) ;
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

}
