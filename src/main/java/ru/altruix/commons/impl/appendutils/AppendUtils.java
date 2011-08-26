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

package ru.altruix.commons.impl.appendutils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * @author DP118M
 * 
 */
public class AppendUtils {
    public static void appendToFile(final InputStream aInputStream,
            final File aFile)
            throws IOException {
        OutputStream stream = null;
        try {
            stream = outStream(aFile);
            IOUtils.copy(aInputStream, stream);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    public static void
            appendToFile(final String aInputStream, final File aFile)
                    throws IOException {
        InputStream stream = null;
        try {
            stream = IOUtils.toInputStream(aInputStream);
            appendToFile(stream, aFile);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    private static OutputStream outStream(final File aFile) throws IOException {
        return new BufferedOutputStream(new FileOutputStream(aFile, true));
    }

    private AppendUtils() {
    }

}
