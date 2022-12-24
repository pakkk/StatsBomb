package es.iesjandula.statsbomb.matches_rest.rest;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.matches_stats.MatchesStats;
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

    // New Instance of MatchesStats
    private final MatchesStats matchesStats = this.getMatchesStats();


    @RequestMapping(method = RequestMethod.GET, value = "/list_possession/")
    public ResponseEntity<?> getListOfPosesionOfMatch(@RequestParam(value="matchId", required=true) final Integer matchId)
    {
        try
        {
            String resultJson = this.matchesStats.getListOfPossessionOfMatch(matchId);
            return ResponseEntity.ok().body(resultJson) ;
        }
        catch (StatsBombException statsBombException)
        {
            return ResponseEntity.status(500).body(statsBombException.getBodyExceptionMessage());
        }
        catch (Exception exception)
        {
            StatsBombException statsBombException = new StatsBombException(exception);
            return ResponseEntity.status(590).body(statsBombException.getBodyExceptionMessage());
        }

    }

    @Bean
    private MatchesStats getMatchesStats()
    {
        return new MatchesStats();
    }

}
