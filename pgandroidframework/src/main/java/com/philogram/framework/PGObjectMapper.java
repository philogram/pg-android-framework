package com.philogram.framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bigmandoo on 16. 7. 11..
 * Simple wrapper of jackson object mapper for ignoring exceptions
 */
public class PGObjectMapper
{
	private ObjectMapper objectMapper = new ObjectMapper();

	public String writeValueAsString(Object object)
	{
		try
		{
			return objectMapper.writeValueAsString(object);
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
