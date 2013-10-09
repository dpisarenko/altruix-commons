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
