package es.iesjandula.statsbomb.common;

import es.iesjandula.statsbomb.common.load_json.JsonLoaderImpl;

public class LauncherTemporal
{
    public static void main(String[] args)
    {
        JsonLoaderImpl jsonLoader = new JsonLoaderImpl();

        System.out.println(jsonLoader.loadCompetitions());

    }
}
