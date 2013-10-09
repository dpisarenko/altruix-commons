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

package ru.altruix.commons.impl.translationtester;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;

import ru.altruix.commons.api.di.PccException;
import ru.altruix.commons.api.translationtester.ProblemTuple;
import ru.altruix.commons.api.translationtester.TranslationTester;

/**
 * @author DP118M
 * 
 */
class DefaultTranslationTester implements TranslationTester {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultTranslationTester.class);

    private List<File> translationDirectories;

    private List<ProblemTuple> translationProblems;

    @Override
    public void run() throws PccException {
        final List<KeyAndLanguageTuple> klt =
                 getKeyAndLanguageTuples(translationDirectories);
        translationProblems = getProblemTuples(klt);

        for (final ProblemTuple tuple : translationProblems) {
            LOGGER.debug(tuple.toString());
        }

    }

    @Override
    public List<ProblemTuple> getTranslationProblems() {
        return translationProblems;
    }

    private List<ProblemTuple> getProblemTuples(
            final List<KeyAndLanguageTuple> aKlt) {
        final List<String> allNonBlankKeys = getAllKeys(aKlt);
        final List<ProblemTuple> returnValue =
                new LinkedList<ProblemTuple>();

        /**
         * Делаем для каждого языка ProblemTuple
         */
        for (final KeyAndLanguageTuple curKlt : aKlt) {
            final DefaultProblemTuple problemTuple = new DefaultProblemTuple();
            problemTuple.setCulture(curKlt.getCulture());
            returnValue.add(problemTuple);
        }

        /**
         * Смотрим, в каких языках нет перевода
         */
        for (final String curKey : allNonBlankKeys) {
            /**
             * Проверяем каждый язык
             */
            for (int i = 0; i < aKlt.size(); i++) {
                final KeyAndLanguageTuple klt = aKlt.get(i);
                final ProblemTuple problemTuple = returnValue.get(i);

                if (!klt.getNonBlankKeys().contains(curKey)) {
                    problemTuple.getProblematicKeys().add(curKey);
                }
            }
        }

        return returnValue;
    }

    private List<String> getAllKeys(final List<KeyAndLanguageTuple> aKlt) {
        final List<String> returnValue = new LinkedList<String>();

        for (final KeyAndLanguageTuple curTuple : aKlt) {
            for (final String nonBlankKey : curTuple.getNonBlankKeys()) {
                if (!returnValue.contains(nonBlankKey)) {
                    returnValue.add(nonBlankKey);
                }
            }
        }

        return returnValue;
    }

    private List<KeyAndLanguageTuple> getKeyAndLanguageTuples(
            final List<File> aDirectories) {
        final List<KeyAndLanguageTuple> returnValue =
                new LinkedList<KeyAndLanguageTuple>();
        for (final File curDirectory : aDirectories) {
            final KeyAndLanguageTuple tuple = new KeyAndLanguageTuple();

            /**
             * Указываем идентификатор языка
             */
            tuple.setCulture(getCulture(curDirectory));

            /**
             * Берём перечень всех файлов в директории
             */
            final File[] files = curDirectory.listFiles();

            /**
             * Изучаем каждый файл
             */
            for (final File curFile : files) {
                /**
                 * Вычитать все значения
                 */
                final Properties properties = file2properties(curFile);

                /**
                 * Добавляем в список все не-пустые значения
                 */
                for (final Object curKeyAsObject : properties.keySet()) {
                    final String curKey = (String) curKeyAsObject;
                    final String translatedValue =
                            properties.getProperty(curKey);

                    if (!StringUtils.isBlank(StringUtils
                            .trimToEmpty(translatedValue))) {
                        tuple.getNonBlankKeys().add(curKey);
                    }
                }
            }

            returnValue.add(tuple);
        }
        return returnValue;
    }

    private String getCulture(final File aCurDirectory) {
        /**
         * webapp/VAADIN/themes/pcc/i18n/ru - в curDirectory содержится именно
         * такой текст.
         * 
         * => Нам из него нужно ru
         */

        return aCurDirectory.getName();
    }

    private Properties file2properties(final File aFile) {
        final Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(aFile);
            properties.load(fileInputStream);
        } catch (final IOException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
        return properties;
    }

    @Override
    public void setTranslationDirectories(final List<File> aDirectories) {
        this.translationDirectories = aDirectories;
    }
}
