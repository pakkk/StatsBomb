package es.iesjandula.statsbomb.competitions_rest.rest;


import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.competitions_stats.CompetitionsStats;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ------------------------------------------------
 *
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/competitions", produces = {"application/json"})
@RestController //
public class RestHandlerCompetition
{

    // New Instance of CompetitionStats
    private final CompetitionsStats competitionsStats = this.getCompetitionsStats();

    /**
     * This endPoint return all the competitions in order ascending by competition_name
     *
     * @return Json of competitions in order ascending
     */
    @RequestMapping(method = RequestMethod.GET, value = "/order/ascent")
    public ResponseEntity<?> getCompetitionsAlphabeticalOrder()
    {

        try
        {
            String resultJson = this.competitionsStats.getCompetitionsAlphabeticalOrder();
            return ResponseEntity.ok().body(resultJson);
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

    /**
     * This endpoint returns competitions that are played by women.
     *
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/female")
    public ResponseEntity<?> getCompetitionsFemale()
    {
        try
        {
            String resultJson = this.competitionsStats.getCompetitionsFemale();

            return ResponseEntity.ok().body(resultJson);
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

    /**
     * This endpoint returns competitions that are played by women.
     *
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/male")
    public ResponseEntity<?> getCompetitionsMale()
    {

        try
        {
            String resultJson = this.competitionsStats.getCompetitionsMale();
            return ResponseEntity.ok().body(resultJson);
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

    /**
     * Method return Instance of CompetitionsStats
     *
     * @return Instance of CompetitionsStats
     */
    @Bean
    public CompetitionsStats getCompetitionsStats()
    {
        return new CompetitionsStats();
    }
}