package es.iesjandula.statsbomb.common;

import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;

public class LauncherTemporal
{
    public static void main(String[] args)
    {
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
