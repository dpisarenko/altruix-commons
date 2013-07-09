/**
 * 
 */
package ru.altruix.commons.android;

import co.altruix.ccp.android.api.IWebServiceTaskHelper;
import co.altruix.ccp.android.impl.activities.IConnectToServerAsyncTask;
import co.altruix.ccp.android.impl.activities.IGetSimulationStatusAsyncTask;

/**
 * @author DP118M
 *
 */
public interface IAsyncTaskFactory {
	IConnectToServerAsyncTask createConnectToServerAsyncTask(
			final IWebServiceTaskHelper aWebServiceHelper);

	IGetSimulationStatusAsyncTask createGetSimulationStatusAsyncTask(
			final IWebServiceTaskHelper aWebServiceHelper);
}
