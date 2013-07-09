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
	void startActivity(final IActivity aActivity);
}
