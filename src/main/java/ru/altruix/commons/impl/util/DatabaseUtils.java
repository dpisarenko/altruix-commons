/**
 *
 * Copyright 2010, 2011, 2012 Altruix Software Development e. U.
 * All rights reserved
 *
 **/

package ru.altruix.commons.impl.util;

import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;

/**
 * @author DP118M
 * 
 */
public class DatabaseUtils {
    public static void closeStatement(final Statement aStatement,
            final Logger aLogger) {
        if (aStatement != null) {
            try {
                aStatement.close();
            } catch (final SQLException exception) {
                aLogger.error("", exception);
            }
        }
    }

}
