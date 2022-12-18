package es.iesjandula.statsbomb.common;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LauncherTemporal
{

	/* Attribute - Logger */
	private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {

		LOGGER.info("prueba");

        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();

        try
		{
			System.out.println(jsonLoader.loadThreeSixty(3788741));
		}
		catch (StatsBombException e)
		{
			e.printStackTrace();
		}

    }
}
