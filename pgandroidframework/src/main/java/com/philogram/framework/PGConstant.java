package com.philogram.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bigmandoo on 16. 7. 9..
 */
public interface PGConstant
{
	PGObjectMapper objectMapper = new PGObjectMapper();
	PGApplication pgApplication = PGApplication.getInstance();
}
