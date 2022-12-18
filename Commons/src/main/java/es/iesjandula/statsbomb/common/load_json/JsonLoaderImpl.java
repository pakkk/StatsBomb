package es.iesjandula.statsbomb.common.load_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.utils.Constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Neil Hdez
 * @author Jesus Garcia Puerto
 * @author Oscar Herruzo Montoya
 * This class is in charge of performing the JSON reads
 */
public class JsonLoaderImpl implements IJsonLoader
{
    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Reading JSON through a URL
     *
     * @param urlString URL
     * @return JSON - String
     * @throws StatsBombException
     */
    @Override
    public String loadJson(String urlString) throws StatsBombException
    {
        String contentJson                  = "";
        URL url                             = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader       = null;

        try
        {
            url = new URL(urlString);

            inputStreamReader = new InputStreamReader(url.openStream());
            bufferedReader = new BufferedReader(inputStreamReader);

            String inputLine = bufferedReader.readLine();

            while (inputLine != null)
            {
                contentJson = contentJson.concat(inputLine + "\n");
                inputLine = bufferedReader.readLine();
            }

        }
        catch (MalformedURLException malformedURLException)
        {
            LOGGER.error(Constants.MALFORMED_URL, malformedURLException);
            throw new StatsBombException(Constants.MALFORMED_URL, malformedURLException);
        }
        catch (IOException ioException)
        {
            LOGGER.error(Constants.E_READ_JSON_WEB + urlString, ioException);
            throw new StatsBombException(Constants.E_READ_JSON_WEB + urlString, ioException);
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            }
            catch (IOException ioException)
            {
                LOGGER.error(Constants.E_CLOSING_DATA_STREAM + "BufferedReader", ioException);
                throw new StatsBombException(Constants.E_CLOSING_DATA_STREAM + "BufferedReader", ioException);
            }

            try
            {
                if (inputStreamReader != null)
                {
                    inputStreamReader.close();
                }
            }
            catch (IOException ioException)
            {
                LOGGER.error(Constants.E_CLOSING_DATA_STREAM + "InputStream", ioException);
                throw new StatsBombException(Constants.E_CLOSING_DATA_STREAM + "InputStream", ioException);
            }
        }

        return contentJson;
    }

    /**
     * Current competitions on StatsBomb
     *
     * @return current competitions in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    @Override
    public String loadCompetitions() throws StatsBombException
    {
        return loadJson(Constants.COMPETITIONS_URL);
    }

    /**
     * Current Matches on StatsBomb
     *
     * @return current Matches in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    @Override
    public String loadMatches(int competitionId, int seasonId) throws StatsBombException
    {
        return loadJson(Constants.MATCHES_URL + competitionId + "/" + seasonId + ".json");
    }

    /**
     * Current Events on StatsBomb
     *
     * @return current Events in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    @Override
    public String loadEvents(int matchId)
    {
        return null;
    }

    /**
     * Current LineUps on StatsBomb
     *
     * @return current LineUps in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    @Override
    public String loadLineups(int matchId)
    {
        return null;
    }

    /**
     * Current three-sixty on StatsBomb
     *
     * @return current three-sixty in JSON format
     * @throws StatsBombException This error comes from loadJson
     */
    @Override
    public String loadThreeSixty(int matchId) throws StatsBombException
    {
        return loadJson(Constants.THREE_SIXTY_URL + matchId + ".json");
    }
}
