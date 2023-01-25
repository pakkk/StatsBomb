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

		for (int i = 0; i < matchs.size(); i++)
		{
			MatchesResults matchesResults = new MatchesResults();

			matchesResults.setMatchId(matchs.get(i).getMatch_id());
			matchesResults.setHomeTeam(matchs.get(i).getHome_team().getHome_team_name());
			matchesResults.setAwayTeam(matchs.get(i).getAway_team().getAway_team_name());
			matchesResults.setHomeScore(matchs.get(i).getHome_score());
			matchesResults.setAwayScore(matchs.get(i).getAway_score());
			matchesResults.setMatchStatus360(matchs.get(i).getMatch_status_360());
			matchesResults.setCompetitionStage(matchs.get(i).getCompetition_stage().getName());

			matchesResultsList.add(matchesResults);
		}

		JsonUtils jsonUtils = new JsonUtils();

		String resultMatches = jsonUtils.writeObjectToJsonAsStringPretty(matchesResultsList);

		return resultMatches;
	}
}
