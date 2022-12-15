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
 * @author Neil Hdez This class is in charge of performing the Json reads
 */
public class JsonLoaderImpl implements IJsonLoader
{
	/** Attribute - Logger */
	private final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Reading json through a URL
	 *
	 * @param urlString URL
	 * @return Json - String
	 * @throws StatsBombException 
	 */
	@Override
	public String loadJson(String urlString) throws StatsBombException
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
			String error = "Error in the URL";
			LOGGER.error(error + malformedURLException);
			throw new StatsBombException(error, malformedURLException);
		}
		catch (IOException ioException)
		{
			String error = "Error to read the file";
			LOGGER.error(error + ioException);
			throw new StatsBombException(error + ioException);
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
				String error = "Error to close the BufferedReader";
				LOGGER.error(error + ioException);
				throw new StatsBombException(error + ioException);
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
				String error = "Error to close the InputStreamReader";
				LOGGER.error(error + ioException);
				throw new StatsBombException(error + ioException);
			}
		}

		return contentJson;
	}

	/**
	 * Current competitions on StatsBomb
	 * 
	 * @return current competitions in Json format
	 * @throws StatsBombException 
	 */
	@Override
	public String loadCompetitions() throws StatsBombException
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
	public String loadThreeSixty(int matchId) throws StatsBombException
	{
		return loadJson(Constants.THREE_SIXTY_URL + matchId + ".json");
	}
}
