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
