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

package ru.altruix.commons.impl.uncaughtexceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DP118M
 * 
 */
public final class UncaughtExceptionHandler implements
        java.lang.Thread.UncaughtExceptionHandler {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(final Thread aThread,
            final Throwable aThrowable) {
        LOGGER.error("Uncaught exception", aThrowable);
    }

}
