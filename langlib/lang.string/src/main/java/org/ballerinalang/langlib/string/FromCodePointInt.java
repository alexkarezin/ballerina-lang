/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.langlib.string;

import org.ballerinalang.jvm.BallerinaErrors;
import org.ballerinalang.jvm.scheduling.Strand;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Extern function lang.string:startsWith(string, string).
 *
 * @since 1.0
 */
@BallerinaFunction(
        orgName = "ballerina", packageName = "lang.string", functionName = "fromCodePointInt",
        args = {@Argument(name = "codePoint", type = TypeKind.INT)},
        returnType = {@ReturnType(type = TypeKind.UNION)},
        isPublic = true
)
public class FromCodePointInt {

    public static Object fromCodePointInt(Strand strand, long codePoint) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.appendCodePoint(((Long) codePoint).intValue());
            return builder.toString();
        } catch (IllegalArgumentException e) {
            return BallerinaErrors.createError("Invalid codepoint: " + codePoint);
        }
    }
}
