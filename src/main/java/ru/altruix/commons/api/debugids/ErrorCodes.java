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

package ru.altruix.commons.api.debugids;

import ru.altruix.commons.api.commons.CommonsFunctionalBlock;
import ru.altruix.commons.api.commons.CommonsMessageCodePrefixRegistry;

/**
 * @author DP118M
 * 
 */
final class ErrorCodes {
    private static final String PREFIX = CommonsMessageCodePrefixRegistry
            .getInstance().getPrefix(CommonsFunctionalBlock.debugids);

    public static final String M_001_LOAD_DATA = PREFIX + "001";

    private ErrorCodes() {
    }
}
