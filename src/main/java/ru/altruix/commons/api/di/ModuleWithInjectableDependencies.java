/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/
package ru.altruix.commons.api.di;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @deprecated
 * Please use ru.altruix.commons.api.di.FunctionalBlockWithInjectableDependencies instead.
 */
@Deprecated
public interface ModuleWithInjectableDependencies {
    @Inject
    void setInjector(final Injector aInjector);
}
