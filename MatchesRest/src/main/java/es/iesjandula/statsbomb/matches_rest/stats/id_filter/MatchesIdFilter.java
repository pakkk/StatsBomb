package es.iesjandula.statsbomb.matches_rest.stats.id_filter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.IJsonLoader;
import es.iesjandula.statsbomb.common.load_json.Json;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import es.iesjandula.statsbomb.common.utils.JsonUtils;
import es.iesjandula.statsbomb.matches_rest.stats.matches_result_filters.MatchesResults;
import es.iesjandula.statsbomb.models.matches.Match;

public class MatchesIdFilter
{

    public String getMatchesId(List<Match> matchs) throws StatsBombException
    {
        List<MatchesResults> matchesResultsList = new ArrayList<MatchesResults>();

        for (Match match : matchs) {
            MatchesResults matchesResults = new MatchesResults();

            matchesResults.setMatchId(match.getMatch_id());
            matchesResultsList.add(matchesResults);
        }
        JsonUtils jsonUtils = new JsonUtils();

        return jsonUtils.writeObjectToJsonAsStringPretty(matchesResultsList);
    }





}