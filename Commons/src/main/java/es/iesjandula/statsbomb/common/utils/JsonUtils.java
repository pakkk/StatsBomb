package es.iesjandula.statsbomb.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.iesjandula.statsbomb.common.exception.StatsBombException;
import es.iesjandula.statsbomb.common.load_json.Json;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 13/12/2022
 */
public class JsonUtils
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Parse an object to JSON in Pretty format
     *
     * @param objectToJson object to be parsed
     * @return String with JSON in Pretty format
     * @throws StatsBombException
     */
    public String writeObjectToJsonAsStringPretty(Object objectToJson) throws StatsBombException
    {
        String resultJsonAsString = "";
        try
        {
            // Write Result Pretty Format
            resultJsonAsString = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectToJson);
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            LOGGER.error(Constants.E_PARSING_OBJECT_TO_JSON, jsonProcessingException);
            throw new StatsBombException(Constants.E_PARSING_OBJECT_TO_JSON, jsonProcessingException);
        }

        return resultJsonAsString;
    }

}
