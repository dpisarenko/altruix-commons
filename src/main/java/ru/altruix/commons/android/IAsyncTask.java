/**
 * 
 */
package ru.altruix.commons.android;

/**
 * @author DP118M
 *
 */
public interface IAsyncTask {
	void addNameValuePair(final String aName, final String aValue);
	void sendRequest(String[] strings);
}
