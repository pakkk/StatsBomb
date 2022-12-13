package es.iesjandula.statsbomb.competitions_rest.rest;

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

    private CompetitionStats competitionsStats = getCompetitionsStats(); // Resultado en Stats

    @RequestMapping(method = RequestMethod.GET, value = "/competitions/order"	)
    public ResponseEntity<?> getCompetitionsalphabeticalOrder()
    {
        return this.competitionsStats.getCompetitionsalphabeticalOrder();
    }

    @Bean
    public CompetitionsStats getCompetitionsStats()
    {
        return new CompetitionsStats() ;
    }
}
