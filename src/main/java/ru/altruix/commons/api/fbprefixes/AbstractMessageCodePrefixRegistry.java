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

package ru.altruix.commons.api.fbprefixes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DP118M
 * 
 */
public abstract class AbstractMessageCodePrefixRegistry<C extends Enum<C>> {

    private static final String PREFIX_MESSAGE_NUMBER_SEPARATOR = ".";

    private Map<C, String> prefixesByModules;

    public static String getMessageNumberSeparator() {
        return PREFIX_MESSAGE_NUMBER_SEPARATOR;
    }

    public final String getPrefix(final C aModule) {
        return this.prefixesByModules.get(aModule)
                + PREFIX_MESSAGE_NUMBER_SEPARATOR;
    }

    protected AbstractMessageCodePrefixRegistry() {
        this.prefixesByModules = new HashMap<C, String>();
        fillPrefixesByModules(this.prefixesByModules);
    }

    protected abstract void fillPrefixesByModules(
            final Map<C, String> aPrefixesByFunctionalBlocks);
}
