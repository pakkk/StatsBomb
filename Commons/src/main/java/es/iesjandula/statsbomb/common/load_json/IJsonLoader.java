package es.iesjandula.statsbomb.common.load_json;

import es.iesjandula.statsbomb.common.exception.StatsBombException;

public interface IJsonLoader
{

    String loadJson(String url) throws StatsBombException;

    String loadCompetitions() throws StatsBombException;

    String loadMatches(int competitionId, int seasonId);

    String loadEvents(int matchId);

    String loadLineups(int matchId);

    String loadThreeSixty(int matchId) throws StatsBombException;

}
