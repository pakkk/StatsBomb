package es.iesjandula.statsbomb.common.load_json;

import es.iesjandula.statsbomb.common.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Neil Hdez
 * This class is in charge of performing the Json reads
 */
public class JsonLoaderImpl implements IJsonLoader
{
    /**
     * Reading json through a URL
     *
     * @param urlString URL
     * @return Json - String
     */
    @Override
    public String loadJson(String urlString)
    {
        String contentJson = "";
        URL url = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

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
            malformedURLException.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }

            try
            {
                if (inputStreamReader != null)
                {
                    inputStreamReader.close();
                }
            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        }

        return contentJson;
    }

    /**
     * Current competitions on StatsBomb
     * @return current competitions in Json format
     */
    @Override
    public String loadCompetitions()
    {
        return loadJson(Constants.COMPETITIONS_URL);
    }

    @Override
    public String loadMatches(int competitionId, int seasonId)
    {
        return null;
    }

    @Override
    public String loadEvents(int matchId)
    {
        return null;
    }

    @Override
    public String loadLineups(int matchId)
    {
        return null;
    }

    @Override
    public String loadThreeSixty(int matchId)
    {
        return null;
    }
}
