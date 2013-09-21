/**
 * 
 */
package ru.altruix.commons.android;

import android.net.NetworkInfo;

/**
 * @author DP118M
 *
 */
public interface IConnectivityManager {
	NetworkInfo  getActiveNetworkInfo();
}
