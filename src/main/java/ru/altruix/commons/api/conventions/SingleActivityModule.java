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

package ru.altruix.commons.api.conventions;

import ru.altruix.commons.api.di.PccException;

/**
 * @deprecated
 * Please use ru.altruix.commons.api.conventions.SingleActivityFunctionalBlock instead.
 */
@Deprecated
public interface SingleActivityModule {
    void run() throws PccException;
}
