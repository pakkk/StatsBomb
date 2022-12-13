package es.iesjandula.statsbomb.common.load_json;

public interface IJsonLoader
{

    String loadJson(String url);

    String loadCompetitions();

    String loadMatches(int competitionId, int seasonId);

    String loadEvents(int matchId);

    String loadLineups(int matchId);

    String loadThreeSixty(int matchId);

}
