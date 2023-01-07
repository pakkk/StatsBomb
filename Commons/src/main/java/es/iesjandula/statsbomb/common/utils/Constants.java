package es.iesjandula.statsbomb.common.utils;

public final class Constants
{
    /********************************************/
    /*************** EXCEPTIONS *****************/
    /********************************************/

    /* Error Constants - The URL si malformed */
    public static final String MALFORMED_URL            = "Error in the URL";

    /* Error Constants - Error while reading the JSON from the website, it is necessary to define the url */
    public static final String E_READ_JSON_WEB          = "Error to read the Json of Web -> ";

    /* Error Constants - Error closing data streams, it is necessary to define data stream causing error */
    public static final String E_CLOSING_DATA_STREAM    = "Error to closing data stream -> ";

    /* Error Constants - Error parsing object to JSON */
    public static final String E_PARSING_OBJECT_TO_JSON = "Error parsing Object to JSON";

    /* Error Constants - Error parsing JSON to Object */
    public static final String E_PARSING_JSON_TO_OBJECT = "Error parsing JSON to Object";


    /********************************************/
    /****************** URLS ********************/
    /********************************************/

    /* Constants - Base Url for Stats Bombs Data */
    private static final String BASE_URL                 = "https://raw.githubusercontent.com/statsbomb/open-data/master/data/";

    /* Constants - Base Url for Stats Bombs Data - Competitions */
    public static final String COMPETITIONS_URL         = BASE_URL + "competitions.json";

    /* Constants - Base Url for Stats Bombs Data - Three-sixty */
    public static final String THREE_SIXTY_URL          = BASE_URL + "three-sixty/";

    /* Constants - Base Url for Stats Bombs Data - Matches */
    public static final String MATCHES_URL 				= BASE_URL + "matches/";
    
    /* Constants - Base Url for Stats Bombs Data - EVENTS */
    public static final String EVENTS_URL 				= BASE_URL + "events/";
    
    /* Constants - Base Url for Stats Bombs Data - LINEUPS */
    public static final String LINEUPS_URL 				= BASE_URL + "lineups/";
    
}
