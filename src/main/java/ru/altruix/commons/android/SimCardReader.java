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

package ru.altruix.commons.android;

import android.telephony.TelephonyManager;
import android.util.SparseArray;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class SimCardReader implements ISimCardReader {
    private final static int MAXIMUM_NUMBER_OF_SIMS = 2;
    private final ITelephonyManager telephonyManager;
    private final ILogger logger;
    private final SparseArray<SimState> simStatesByIntegerRepresentations;

    public SimCardReader(final ITelephonyManager aTelephonyManager, final ILogger aLogger) {
        telephonyManager = aTelephonyManager;
        logger = aLogger;

        simStatesByIntegerRepresentations = new SparseArray<SimState>();

        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_ABSENT, SimState.ABSENT);
        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_NETWORK_LOCKED,
                SimState.NETWORK_LOCKED);
        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_PIN_REQUIRED,
                SimState.PIN_REQUIRED);
        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_PUK_REQUIRED,
                SimState.PUK_REQUIRED);
        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_READY, SimState.READY);
        simStatesByIntegerRepresentations.put(TelephonyManager.SIM_STATE_UNKNOWN,
                SimState.UNKNOWN);
    }

    @Override
    public List<SimCardInfo> getAvailableSimCards() {
        final List<SimCardInfo> returnValue = new LinkedList<SimCardInfo>();

        try
        {
            final Class<?> telephonyClass = telephonyManager.getTelephonyClass();

            for (int i = 0; i < MAXIMUM_NUMBER_OF_SIMS; i++) {
                final String imei = getDeviceIdBySlot(i, telephonyClass, "getDeviceIdGemini");
                final String country = getDeviceIdBySlot(i, telephonyClass,
                        "getNetworkCountryIsoGemini");
                final String networkOperatorId = getDeviceIdBySlot(i, telephonyClass,
                        "getNetworkOperatorGemini");
                final String networkOperatorName = getDeviceIdBySlot(i, telephonyClass,
                        "getNetworkOperatorNameGemini");
                final SimState simState = getSIMStateBySlot(i);

                final SimCardInfo simCardInfo = new SimCardInfo();
                simCardInfo.setImei(imei);
                simCardInfo.setState(simState);
                simCardInfo.setCountry(country);
                simCardInfo.setNetworkOperatorId(networkOperatorId);
                simCardInfo.setNetworkOperatorName(networkOperatorName);

                returnValue.add(simCardInfo);
            }
        }
        catch (final ClassNotFoundException exception)
        {
            logger.error(exception);
        }

        return returnValue;
    }

    private SimState getSIMStateBySlot(final int aSlotId) {
        SimState returnValue = SimState.UNKNOWN;
        try
        {
            final Class<?> telephonyClass = telephonyManager.getTelephonyClass();

            Class<?>[] parameter = new Class[1];
            parameter[0] = int.class;
            Method getSimStateGemini = telephonyClass.getMethod("getSimStateGemini", parameter);

            Object[] obParameter = new Object[1];
            obParameter[0] = aSlotId;
            Object ob_phone = telephonyManager.invokeMethod(getSimStateGemini, obParameter);

            if (ob_phone != null)
            {
                final int simStateAsInt = Integer.parseInt(ob_phone.toString());

                returnValue = simStatesByIntegerRepresentations.get(simStateAsInt);
            }
        }
        catch (final Exception exception)
        {
            logger.error(exception);
        }
        return returnValue;
    }

    private String getDeviceIdBySlot(final int aSlotId, final Class<?> aTelephonyClass,
                                     final String aMethodName) {
        String returnValueAsString = null;

        try {
            final Class<?>[] parameter = new Class[1];
            parameter[0] = int.class;

            final Method method = aTelephonyClass.getMethod(aMethodName, parameter);

            final Object[] parameterArray = new Object[1];
            parameterArray[0] = aSlotId;

            final Object returnValue = telephonyManager.invokeMethod(method, parameterArray);

            if (returnValue != null) {
                returnValueAsString = returnValue.toString();
            }
        } catch (final Exception exception) {
            logger.error(exception);
            return "";
        }

        return returnValueAsString;
    }
}
