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

public class SimCardInfo {
    private String imei;
    private SimState state;
    private String country;
    private String networkOperatorId;
    private String networkOperatorName;

    public String getImei() {
        return imei;
    }

    public void setImei(final String aImei) {
        this.imei = aImei;
    }

    public SimState getState() {
        return state;
    }

    public void setState(final SimState aState) {
        this.state = aState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String aCountry) {
        this.country = aCountry;
    }

    public String getNetworkOperatorId() {
        return networkOperatorId;
    }

    public void setNetworkOperatorId(final String aNetworkOperatorId) {
        this.networkOperatorId = aNetworkOperatorId;
    }

    public String getNetworkOperatorName() {
        return networkOperatorName;
    }

    public void setNetworkOperatorName(final String aNetworkOperatorName) {
        this.networkOperatorName = aNetworkOperatorName;
    }
}
