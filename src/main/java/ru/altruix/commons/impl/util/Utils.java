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
package ru.altruix.commons.impl.util;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public final class Utils {
    private static final int MINUTES_IN_HOUR = 60;

    /**
     * We need this to fix checkstyle error: Utility classes should not have a
     * public or default constructor.
     */
    private Utils() {
    }

    public static Date addHours(final Date aDateTime, final double aHours) {
        final int hours = (int) aHours;
        final int minutes =
                (int) ((aHours - (double) hours) * MINUTES_IN_HOUR);

        final Date timeWithHoursAdded = DateUtils.addHours(aDateTime, hours);

        return DateUtils.addMinutes(timeWithHoursAdded, minutes);
    }
}
