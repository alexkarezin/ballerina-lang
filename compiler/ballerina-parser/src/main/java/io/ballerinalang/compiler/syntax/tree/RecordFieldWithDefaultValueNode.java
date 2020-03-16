/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerinalang.compiler.syntax.tree;

import io.ballerinalang.compiler.internal.parser.tree.STNode;

public class RecordFieldWithDefaultValueNode extends NonTerminalNode {

    private Node fieldType;
    private Token fieldName;
    private Token equalsToken;
    private Node defaultValue;
    private Token semicolon;

    public RecordFieldWithDefaultValueNode(STNode node, int position, NonTerminalNode parent) {
        super(node, position, parent);
    }

    public Node fieldType() {
        if (fieldType != null) {
            return fieldType;
        }

        fieldType = node.childInBucket(0).createFacade(getChildPosition(0), this);
        childBuckets[0] = fieldType;
        return fieldType;
    }

    public Token fieldName() {
        if (fieldName != null) {
            return fieldName;
        }

        fieldName = createToken(1);
        return fieldName;
    }

    public Token questionMark() {
        if (equalsToken != null) {
            return equalsToken;
        }

        equalsToken = createToken(2);
        return equalsToken;
    }

    public Node defaultValue() {
        if (defaultValue != null) {
            return defaultValue;
        }

        defaultValue = node.childInBucket(3).createFacade(getChildPosition(3), this);
        childBuckets[3] = defaultValue;
        return defaultValue;
    }

    public Token semicolon() {
        if (semicolon != null) {
            return semicolon;
        }

        semicolon = createToken(4);
        return semicolon;
    }

    public Node childInBucket(int bucket) {
        switch (bucket) {
            case 0:
                return fieldType();
            case 1:
                return fieldName();
            case 2:
                return questionMark();
            case 3:
                return defaultValue();
            case 4:
                return semicolon();
        }
        return null;
    }
}