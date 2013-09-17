/**
 * 
 */
package ru.altruix.commons.android;

import android.content.Intent;

/**
 * @author DP118M
 *
 */
public interface IIntent {
	Intent putExtra(final String aName, final long aValue);
	Intent putExtra(final String aName, final String aValue);
	void startActivity(final IActivity aActivity);
	String getStringExtra(final String aName);
	long getLongExtra(final String aName, long aDefaultValue);
}
