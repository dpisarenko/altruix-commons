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

/**
 * 
 */
package ru.altruix.commons.android;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.params.HttpParams;

/**
 * @author DP118M
 *
 */
public interface IWebServiceTaskHelper {
    static final int POST_TASK = 1;
    static final int GET_TASK = 2;
    static final int CONN_TIMEOUT = 3000;
    static final int SOCKET_TIMEOUT = 5000;
    
	String inputStreamToString(InputStream is);
	HttpResponse doResponse(String url);
	HttpParams getHttpParams();
	void addNameValuePair(String name, String value);
	void setTaskType(int taskType);
}
