package es.iesjandula.statsbomb.common.load_json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * This class has the configuration for parsing JSON files.
 */
public class Json
{
    private static ObjectMapper mapper;

    public static ObjectMapper mapper()
    {
        if (Json.mapper == null)
        {
            Json.mapper = Json.createJson();
        }
        return Json.mapper;
    }

    private static ObjectMapper createJson()
    {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

        return mapper;
    }

}
