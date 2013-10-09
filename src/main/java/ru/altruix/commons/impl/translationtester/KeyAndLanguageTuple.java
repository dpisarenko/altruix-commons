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

import java.util.LinkedList;
import java.util.List;

/**
 * @author DP118M
 * 
 */
class KeyAndLanguageTuple {
    private String culture;
    private List<String> nonBlankKeys;

    public KeyAndLanguageTuple() {
        this.nonBlankKeys = new LinkedList<String>();
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(final String aCulture) {
        this.culture = aCulture;
    }

    public List<String> getNonBlankKeys() {
        return nonBlankKeys;
    }

    public void setNonBlankKeys(final List<String> aNonBlankKeys) {
        this.nonBlankKeys = aNonBlankKeys;
    }
}
