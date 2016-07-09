package com.philogram.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bigmandoo on 16. 7. 9..
 */
public interface PGConstant
{
	ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	PGApplication PG_APPLICATION = PGApplication.getInstance();
}
