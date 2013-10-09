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

package ru.altruix.commons.impl.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import ru.altruix.commons.api.di.PccException;
import ru.altruix.commons.api.version.PccVersionReader;

class DefaultPccVersionReader implements PccVersionReader {
    private static final String PROPERTY_FILE_PATH =
            "version/application.properties";
    private static final String VERSION_PROPERTY_NAME = "version";
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultPccVersionReader.class);
    private String version = "?";
    private String propertyFilePath = PROPERTY_FILE_PATH;

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public void run() throws PccException {
        final Properties properties = new Properties();

        final InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(propertyFilePath);
        try {
            properties.load(inputStream);
            final String versionFromFile = properties
                    .getProperty(VERSION_PROPERTY_NAME);

            if (StringUtils.isNotBlank(versionFromFile)) {
                this.version = versionFromFile;
            }

        } catch (final IOException exception) {
            LOGGER.error(ErrorCodes.M_001_RUN, exception);
        } catch (final RuntimeException exception) {
            LOGGER.error(ErrorCodes.M_002_RUN2, exception);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Override
    public void setPropertyFilePath(final String aPropertyFilePath) {
        this.propertyFilePath = aPropertyFilePath;
    }

}
