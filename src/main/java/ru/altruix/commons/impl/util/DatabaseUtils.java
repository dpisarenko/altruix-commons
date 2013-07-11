/**
 *
 * Copyright 2010, 2011, 2012 Altruix Software Development e. U.
 * All rights reserved
 *
 **/

package ru.altruix.commons.impl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
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

    public static ResultSet executeQuery(final String aQuery,
            final Logger aLogger, final Statement aStatement) {
        aLogger.debug("executeQuery, 1");
        ResultSet resultSet = null;
        try {
            resultSet = aStatement
                    .executeQuery(aQuery);
            aLogger.debug("executeQuery, 2");
        } catch (final SQLException exception) {
            aLogger.debug("SQL: {}", aQuery);
            aLogger.error("", exception);
            throw new RuntimeException(exception);
        }
        aLogger.debug("executeQuery, 4");
        return resultSet;
    }
    public static int executeQueryWithSingleIntResult(final String aQuery,
            final Statement aStatement, final Logger aLogger) {
        ResultSet resultSet = null;
        try {
            resultSet =
                    DatabaseUtils.executeQuery(aQuery, aLogger, aStatement);
            resultSet.next();
            return resultSet.getInt(1);
        } catch (final SQLException exception) {
            aLogger.error("", exception);
            throw new RuntimeException(exception);
        } finally {
            closeResultSet(resultSet, aLogger);
        }
    }
    public static void closeResultSet(final ResultSet aResultSet, final Logger aLogger) {
        if (aResultSet != null) {
            try {
                aResultSet.close();
            } catch (final SQLException exception) {
                aLogger.error("", exception);
            }
        }
    }
    public static long executeQueryWithSingleLongResult(final String aQuery,
            final Statement aStatement, final Logger aLogger) {
        ResultSet resultSet = null;

        try {
            resultSet = DatabaseUtils.
                    executeQuery(aQuery, aLogger, aStatement);
            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                return -1;
            }
        } catch (final SQLException exception) {
            aLogger.error("", exception);
            throw new RuntimeException(exception);
        } finally {
            DatabaseUtils.closeResultSet(resultSet, aLogger);
        }
    }
    public static double executeQueryWithSingleDoubleResult(final String aQuery,
            final Statement aStatement, final Logger aLogger) {
        ResultSet resultSet = null;

        try {
            resultSet = DatabaseUtils.
                    executeQuery(aQuery, aLogger, aStatement);
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            } else {
                return Double.NaN;
            }
        } catch (final SQLException exception) {
            aLogger.error("", exception);
            throw new RuntimeException(exception);
        } finally {
            DatabaseUtils.closeResultSet(resultSet, aLogger);
        }
    }

    public static String substituteUserId(final long aUserId, final String aTemplate) {
        return aTemplate
                .replace("@{userId}", Long.toString(aUserId));
    }
    
    public static void executeSqlScript(final String aPath, final Logger aLogger,
            final Statement aStatement) {
        try {
            final InputStream inputStream =
                    Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream(
                                    aPath);

            aLogger.debug("inputStream: {}", inputStream);

            final String script = IOUtils.toString(inputStream);

            final StringTokenizer tokenizer = new StringTokenizer(script, ";");

            while (tokenizer.hasMoreTokens()) {
                final String command = tokenizer.nextToken();

                aLogger.debug("command: {}", command);
                try {
                    aStatement.execute(command);
                } catch (final SQLException exception) {
                    if (!command.contains("DROP TABLE")) {
                        aLogger.debug("", exception);
                        throw new RuntimeException(exception);
                    }
                }
            }
        } catch (final IOException exception) {
            aLogger.error("", exception);
        }
    }
	public static void closeConnectionQuietly(final Connection aConnection, 
			final Logger aLogger) {
		if (aConnection != null) {
			try {
				aConnection.close();
			} catch (final SQLException exception) {
				aLogger.error("", exception);
			}
		}
	}

}
