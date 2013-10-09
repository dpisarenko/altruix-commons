/**
 * 
 */
package ru.altruix.commons.android;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Utils {
	private Utils()
	{
		
	}
	
	public static ISimCardReader getSimCardReader(final Activity aActivity, final String aLogTag) {
		final TelephonyManager telephonyManager = (TelephonyManager) aActivity.getSystemService(
				Context.TELEPHONY_SERVICE);
		final ITelephonyManager telephonyManagerWrapper = 
				new TelephonyManagerWrapper(telephonyManager);
		final ISimCardReader simCardReader = new SimCardReader(
				telephonyManagerWrapper, new LoggerWrapper(aLogTag));
		return simCardReader;
	}
	public static String getText(final View aView)
	{
		if (aView instanceof TextView)
		{
			final TextView textView = (TextView) aView;
			return textView.getText().toString();			
		}
		else
		{
			return "";
		}
	}
	
	public static boolean isChecked(final View aView)
	{
		if (aView instanceof CheckBox)
		{
			final CheckBox checkBox = (CheckBox) aView;
			
			return checkBox.isChecked();
		}
		else
		{
			return false;
		}
	}
}
