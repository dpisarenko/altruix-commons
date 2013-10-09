/**
 * 
 */
package ru.altruix.commons.android;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestToJsonConverter implements IRequestToJsonConverter {
	private ILogger logger;
	
	public RequestToJsonConverter(final ILogger aLogger)
	{
		logger = aLogger;
	}
	
	@Override
	public String convertToJson(final Object aRequest) {
		final ObjectMapper mapper = new ObjectMapper();
		String json = null;

		try {
			json = mapper.writeValueAsString(aRequest);
		} catch (final JsonProcessingException exception) {
			logger.error(exception);
		}
		return json;
	}

}
