/**
 * 
 */
package ru.altruix.commons.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import android.telephony.TelephonyManager;
import ru.altruix.commons.android.ITelephonyManager;

/**
 * @author DP118M
 *
 */
public class TelephonyManagerWrapper implements ITelephonyManager {
	final TelephonyManager telephonyManager;
	
	public TelephonyManagerWrapper(final TelephonyManager aTelephonyManager)
	{
		telephonyManager = aTelephonyManager;
		
//		telephonyManager.getSubscriberId()
	}
	
	public int getSimState()
	{
		return telephonyManager.getSimState();
	}

	@Override
	public Class<?> getTelephonyClass() throws ClassNotFoundException
	{
		return Class.forName(telephonyManager.getClass().getName());
	}
	
	@Override
	public String getDeviceId() {
		return telephonyManager.getDeviceId();
	}

	@Override
	public TelephonyManager getWrappedObject() {
		return telephonyManager;
	}

	@Override
	public Object invokeMethod(final Method aMethod, final Object[] aParameters) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return aMethod.invoke(telephonyManager, aParameters);
	}
	
	
}
