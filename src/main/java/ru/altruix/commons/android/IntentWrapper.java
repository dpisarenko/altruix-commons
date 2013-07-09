/**
 * 
 */
package ru.altruix.commons.android;

import android.content.Intent;

/**
 * @author DP118M
 *
 */
public class IntentWrapper implements IIntent {
	private Intent intent; 
	public IntentWrapper(final Intent aIntent)
	{
		intent = aIntent;
	}
	
	@Override
	public Intent putExtra(final String aName, final long aValue)
	{
		return intent.putExtra(aName, aValue);
	}

	@Override
	public void startActivity(final IActivity aActivity) {
		aActivity.startActivity(intent);
	}
}
