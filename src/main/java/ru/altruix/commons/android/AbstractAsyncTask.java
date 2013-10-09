/*
 * This file is part of the Altruix Commons library
 * http://altruix.wordpress.com
 *
 * Copyright 2010-2013 Dmitri Pisarenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.altruix.commons.android;

import android.os.AsyncTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ExecutionException;

public class AbstractAsyncTask<Request, Response> extends
        AsyncTask<String, String, Response> implements
        IRequestSender<Request, Response> {

    private static final String REQUEST_AS_JSON_PARAMETER_NAME = "request";
    private IWebServiceTaskHelper helper;
    private Class<Response> responseClass;
    private ILogger logger = null;
    private IResponseParser<Response> responseParser = null;
    private IServerUrlStorage serverUrlStorage;
    private String serviceName;

    public AbstractAsyncTask(final IWebServiceTaskHelper aHelper,
                             final Class<Response> aResponseClass, final ILogger aLogger,
                             final IResponseParser<Response> aResponseParser,
                             final IServerUrlStorage aServerUrlStorage, final String aServiceName) {
        helper = aHelper;
        responseClass = aResponseClass;
        logger = aLogger;
        responseParser = aResponseParser;
        serverUrlStorage = aServerUrlStorage;
        serviceName = aServiceName;
    }

    private String convertToJson(final Object aRequest) {
        final ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(aRequest);
        } catch (final JsonProcessingException exception) {
            logger.error(exception);
        }
        return json;
    }

    @Override
    protected Response doInBackground(final String... aParams) {
        logger.debug("doInBackground: " + aParams);
        return new ResponseProcessor<Response>(logger, helper, responseParser,
                responseClass).processResponse(aParams);
    }

    @Override
    public Response sendRequest(final Request aRequest)
            throws InterruptedException, ExecutionException {
        final String json = convertToJson(aRequest);
        final String url = serverUrlStorage.getServerUrl() + serviceName;

        helper.addNameValuePair(REQUEST_AS_JSON_PARAMETER_NAME, json);

        execute(url);

        return get();
    }
}
