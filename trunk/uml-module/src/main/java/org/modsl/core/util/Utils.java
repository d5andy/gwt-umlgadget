/**
 * Copyright 2008 Andrew Vishnyakov <avishn@gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.modsl.core.util;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * Miscellaneous utils.
 * @author avishnyakov
 */
public class Utils {

    /**
     * Find # of occurences of the given pattern in the given string
     * @param string
     * @param pattern
     * @return number of occurences
     */
//    public static int matchCount(String string, String pattern) {
//        Matcher m = Pattern.compile(pattern).matcher(string);
//        int count = 0;
//        while (m.find()) {
//            count++;
//        }
//        return count;
//    }


    /**
     * Strips surrounding double quotes from the string
     * @param v
     * @return
     */
    public static String stripDoubleQuotes(String v) {
        if (v.startsWith("\"") && v.endsWith("\"")) {
            return v.substring(1, v.length() - 1);
        } else {
            return v;
        }
    }
}
