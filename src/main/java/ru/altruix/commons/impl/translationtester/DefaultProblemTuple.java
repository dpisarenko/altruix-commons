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

import org.apache.commons.lang.builder.ToStringBuilder;

import ru.altruix.commons.api.translationtester.ProblemTuple;

/**
 * @author DP118M
 * 
 */
class DefaultProblemTuple implements ProblemTuple {
    private String culture;
    private List<String> problematicKeys;

    public DefaultProblemTuple() {
        this.problematicKeys = new LinkedList<String>();
    }

    @Override
    public String getCulture() {
        return culture;
    }

    public void setCulture(final String aCulture) {
        this.culture = aCulture;
    }

    @Override
    public List<String> getProblematicKeys() {
        return problematicKeys;
    }

    public void setProblematicKeys(final List<String> aProblematicKeys) {
        this.problematicKeys = aProblematicKeys;
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);

        return builder.append("culture", this.culture)
                .append("problematicKeys", this.problematicKeys).toString();
    }

}
