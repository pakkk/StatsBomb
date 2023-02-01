package es.iesjandula.statsbomb.webportal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json
{
	/** Attribute - mapper */
	private static ObjectMapper mapper;
	
	/**
	 * @return a new instance of ObjectMapper
	 */
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
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		
		return mapper;
	}
}
