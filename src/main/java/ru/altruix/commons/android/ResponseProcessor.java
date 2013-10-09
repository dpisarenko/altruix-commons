package ru.altruix.commons.android;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class ResponseProcessor<T> {
	private ILogger logger;
	private IWebServiceTaskHelper helper;
	private IResponseParser<T> responseParser;
	private Class<T> responseClass;
	
	public ResponseProcessor(final ILogger aLogger, final IWebServiceTaskHelper aHelper,
			final IResponseParser<T> aParser, final Class<T> aClass)
	{
		logger = aLogger;
		helper = aHelper;
		responseParser = aParser;
		responseClass = aClass;
	}
	
	public T processResponse(final String... aArgs) {
		final String url = aArgs[0];
		logger.debug("aArgs.length: " + aArgs.length);
		logger.debug("url: " + url);
		
		helper.setTaskType(IWebServiceTaskHelper.POST_TASK);

		final HttpResponse httpResponse = helper.doResponse(url);

		if (httpResponse == null) {
			return null;
		} else {

			try {
				final String responseAsString = helper
						.inputStreamToString(httpResponse.getEntity().getContent());

				logger.debug("responseAsString: " + responseAsString);
				return responseParser.parseResponse(responseAsString, responseClass);
			} catch (final IllegalStateException exception) {
				logger.error(exception);
			} catch (final IOException exception) {
				logger.error(exception);
			}
		}

		return null;
	}
}
