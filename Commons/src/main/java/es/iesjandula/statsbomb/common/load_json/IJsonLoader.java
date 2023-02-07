package es.iesjandula.statsbomb.common.load_json;

import es.iesjandula.statsbomb.common.exception.StatsBombException;

/**
 * @author Neil Hdez
 *
 * Interface in which we declare the JSON loading methods
 */
public interface IJsonLoader
{

    /**
     * Reading JSON through a URL
     *
     * @param urlString URL
     * @return JSON - String
     * @throws StatsBombException
     */
    String loadJson(String urlString) throws StatsBombException;

    /**
     * Current competitions on StatsBomb
     *
     * @return current competitions in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    String loadCompetitions() throws StatsBombException;

    /**
     * Current Matches on StatsBomb
     *
     * @return current Matches in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    String loadMatches(int competitionId, int seasonId) throws StatsBombException;

    /**
     * Current Events on StatsBomb
     *
     * @return current Events in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    String loadEvents(int matchId) throws StatsBombException;

    /**
     * Current LineUps on StatsBomb
     *
     * @return current LineUps in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    String loadLineups(int matchId) throws StatsBombException;

    /**
     * Current three-sixty on StatsBomb
     *
     * @return current three-sixty in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    String loadThreeSixty(int matchId) throws StatsBombException;

    String loadCompetitionsByRest(String url) throws StatsBombException;

    String loadLineUpsByRest(String url) throws StatsBombException;

}
