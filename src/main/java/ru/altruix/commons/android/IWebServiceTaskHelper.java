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
