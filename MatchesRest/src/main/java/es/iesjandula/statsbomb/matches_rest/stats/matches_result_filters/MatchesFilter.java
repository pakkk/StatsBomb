package es.iesjandula.statsbomb.matches_rest.stats.matches_result_filters;

import java.util.ArrayList;
import java.util.List;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.models.matches.Match;

public class MatchesFilter
{
    public String getResultsMatches(List<Match> matchs) throws StatsBombException
    {
        List<MatchesResults> matchesResultsList = new ArrayList<MatchesResults>();

        for (Match match : matchs)
        {
            MatchesResults matchesResults = new MatchesResults();

            matchesResults.setMatchId(match.getMatch_id());
            matchesResults.setHomeTeam(match.getHome_team().getHome_team_name());
            matchesResults.setAwayTeam(match.getAway_team().getAway_team_name());
            matchesResults.setHomeScore(match.getHome_score());
            matchesResults.setAwayScore(match.getAway_score());
            matchesResults.setMatchStatus360(match.getMatch_status_360());
            matchesResults.setCompetitionStage(match.getCompetition_stage().getName());

            matchesResultsList.add(matchesResults);
        }

        JsonUtils jsonUtils = new JsonUtils();

       return jsonUtils.writeObjectToJsonAsStringPretty(matchesResultsList);
    }
}
