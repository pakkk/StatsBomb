package es.iesjandula.statsbomb.competitions_rest.rest;

import es.iesjandula.statsbomb.competitions_stats.CompetitionsStats;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ------------------------------------------------
 * @author API Rest Generator
 * ------------------------------------------------
 */
@RequestMapping(value = "/", produces = {"application/json"})
@RestController //
public class RestHandlerCompetition
{

    // New Instance of CompetitionStats
    private final CompetitionsStats competitionsStats = this.getCompetitionsStats();

    /**
     * This endPoint return all the competitions in order ascending by competition_name
     * @return Json of competitions in order ascending
     */
    @RequestMapping(method = RequestMethod.GET, value = "/competitions/order"	)
    public ResponseEntity<?> getCompetitionsAlphabeticalOrder()
    {
        int status = 0;

        String resultJson = this.competitionsStats.getCompetitionsAlphabeticalOrder();
        status = 200;

        return ResponseEntity.status(status).body(resultJson);

    }

    /**
     * This endpoint returns competitions that are played by women.
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/competitions/female"	)
    public ResponseEntity<?> getCompetitionsFemale()
    {
        int status = 0;

        String resultJson = this.competitionsStats.getCompetitionsFemale();
        status = 200;

        return ResponseEntity.status(status).body(resultJson);

    }

    /**
     * This endpoint returns competitions that are played by women.
     * @return Json of competitions played by women
     */
    @RequestMapping(method = RequestMethod.GET, value = "/competitions/male"	)
    public ResponseEntity<?> getCompetitionsMale()
    {
        int status = 0;

        String resultJson = this.competitionsStats.getCompetitionsMale();
        status = 200;

        return ResponseEntity.status(status).body(resultJson);

    }

    /**
     * Method return Instance of CompetitionsStats
     * @return Instance of CompetitionsStats
     */
    @Bean
    public CompetitionsStats getCompetitionsStats()
    {
        return new CompetitionsStats() ;
    }
}
