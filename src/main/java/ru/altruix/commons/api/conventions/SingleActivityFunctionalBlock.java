/**
 *
 * Copyright 2010, 2011, 2012 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package ru.altruix.commons.api.conventions;

/**
 * Instances of this class represent functional blocks, which have exactly one specific
 * purpose and are used in the following way:
 * 
 * 1) First, input data are provided.
 * 2) Then, the central work process of this module is executed (by calling method run).
 * 3) Results are given to the calling routine.
 * 
 * @author Dmitri Pisarenko
 *
 */
public interface SingleActivityFunctionalBlock {
    void run() throws Exception;
}
