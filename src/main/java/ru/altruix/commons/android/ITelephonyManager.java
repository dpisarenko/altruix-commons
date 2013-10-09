/**
 * 
 */
package ru.altruix.commons.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.telephony.TelephonyManager;

/**
 * @author DP118M
 *
 */
public interface ITelephonyManager {

	String getDeviceId();

	TelephonyManager getWrappedObject();

	public abstract Class<?> getTelephonyClass() throws ClassNotFoundException;

	Object invokeMethod(final Method aMethod, final Object[] aParameters) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;
}
