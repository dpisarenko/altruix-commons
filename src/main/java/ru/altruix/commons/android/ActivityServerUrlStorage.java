/**
 * 
 */
package ru.altruix.commons.android;

import android.app.Activity;

/**
 * @author DP118M
 *
 */
public class ActivityServerUrlStorage implements IServerUrlStorage {
	private Activity activity;
    private int serverAddressResourceId;

    public ActivityServerUrlStorage(final Activity aActivity, final int aServerAddressResourceId)
	{
		activity = aActivity;
        serverAddressResourceId = aServerAddressResourceId;
    }
	
	@Override
	public String getServerUrl() {
		return activity.getResources().getString(serverAddressResourceId);
	}

}
