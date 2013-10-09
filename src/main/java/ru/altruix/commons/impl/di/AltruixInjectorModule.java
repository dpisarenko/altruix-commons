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

package ru.altruix.commons.impl.di;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.AbstractModule;

/**
 * @author DP118M
 * 
 */
public abstract class AltruixInjectorModule extends AbstractModule {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected final void configure() {
        final Map<Class, Object> interfacesByInstances =
                new HashMap<Class, Object>();

        bindClassesToInstances(interfacesByInstances);

        for (final Class clazz : interfacesByInstances.keySet()) {
            final Object instance = interfacesByInstances.get(clazz);

            bind(clazz).toInstance(instance);
        }
    }

    @SuppressWarnings("rawtypes")
    protected abstract void
            bindClassesToInstances(
                    final Map<Class, Object> aInterfacesByInstances);

}
