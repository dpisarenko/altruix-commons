/**
 *
 * Copyright 2010, 2011, 2012 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package ru.altruix.commons.api.di;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author DP118M
 *
 */
public interface FunctionalBlockWithInjectableDependencies {
    @Inject
    void setInjector(final Injector aInjector);

}
