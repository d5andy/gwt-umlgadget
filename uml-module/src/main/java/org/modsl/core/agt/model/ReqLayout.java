/**
 * Copyright 2008 Andrew Vishnyakov <avishn@gmail.com>
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

package org.modsl.core.agt.model;

import org.modsl.core.util.Utils;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * "layout" processing attribute values
 * @author avishnyakov
 */
public enum ReqLayout implements IsSerializable {

    free, ordered;

    public static ReqLayout fromString(String name) {
        return Enum.valueOf(ReqLayout.class, Utils.stripDoubleQuotes(name));
    }

}
