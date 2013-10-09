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

package ru.altruix.commons.api.debugids;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author DP118M
 * 
 */
public abstract class AbstractDebugIdKey<C extends Enum<C>> {
    private static final int HASH_CODE_MULTIPLIER = 3;
    private C module;
    private String key;

    public final void setModule(final C aModule) {
        this.module = aModule;
    }

    public final C getModule() {
        return this.module;
    }

    public final void setKey(final String aKey) {
        this.key = aKey;
    }

    public final String getKey() {
        return this.key;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public final boolean equals(final Object aObject) {
        if (aObject == null) {
            return false;
        }
        if (aObject == this) {
            return true;
        }
        if (aObject.getClass() != getClass()) {
            return false;
        }

        final AbstractDebugIdKey rhs = (AbstractDebugIdKey) aObject;
        return new EqualsBuilder().append(module, rhs.module)
                .append(key, rhs.key).isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(1, HASH_CODE_MULTIPLIER).append(module)
                .append(key)
                .toHashCode();
    }
}
