/**
 * 
 */
package ru.altruix.commons.android;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author DP118M
 *
 */
public class ConnectivityManagerWrapper implements IConnectivityManager {
	private ConnectivityManager connectivityManager;
	
	public ConnectivityManagerWrapper(final ConnectivityManager aConnectivityManager)
	{
		connectivityManager = aConnectivityManager;
	}

	@Override
	public NetworkInfo getActiveNetworkInfo() {
		return connectivityManager.getActiveNetworkInfo();
	}
}
