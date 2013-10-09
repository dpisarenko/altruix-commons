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

import ru.altruix.commons.api.commons.CommonsFunctionalBlock;
import ru.altruix.commons.api.commons.CommonsMessageCodePrefixRegistry;

final class ErrorCodes {
    private static final String PREFIX = CommonsMessageCodePrefixRegistry
            .getInstance().getPrefix(CommonsFunctionalBlock.version);

    public static final String M_001_RUN = PREFIX + "001";
    public static final String M_002_RUN2 = PREFIX + "002";

    private ErrorCodes() {

    }
}
