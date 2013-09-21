/**
 * 
 */
package ru.altruix.commons.android;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author DP118M
 *
 */
public class InternetAvailabilityChecker implements
		IInternetAvailabilityChecker {
	private IConnectivityManager connectivityManager;
	
	public InternetAvailabilityChecker(final IConnectivityManager aConnectivityManager)
	{
		connectivityManager = aConnectivityManager;
	}
	
	public static IInternetAvailabilityChecker create(final Activity aActivity) {
		final ConnectivityManager connectivityManager = (ConnectivityManager) 
				aActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
		final IConnectivityManager connectivityManagerWrapper = 
				new ConnectivityManagerWrapper(connectivityManager);
		
		final IInternetAvailabilityChecker internetAvailabilityChecker = 
				new InternetAvailabilityChecker(connectivityManagerWrapper);
		return internetAvailabilityChecker;
	}

	
	@Override
	public boolean isInternetAvailable() {
		final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		
		return (networkInfo != null) && networkInfo.isConnected();
	}
}
