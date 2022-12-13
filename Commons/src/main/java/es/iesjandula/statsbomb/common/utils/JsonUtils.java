package es.iesjandula.statsbomb.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.iesjandula.statsbomb.common.load_json.Json;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 13/12/2022
 */
public class JsonUtils
{

    public String writeJsonAsStringPretty(Object objectToJson)
    {
        String resultJsonAsString = "";
        try
        {
            // Write Result Pretty Format
            resultJsonAsString = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectToJson);
        } catch (JsonProcessingException jsonProcessingException)
        {
            jsonProcessingException.printStackTrace();
        }

        return resultJsonAsString;
    }

}
