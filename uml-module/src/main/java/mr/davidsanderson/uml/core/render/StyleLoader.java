/**
 * Copyright 2009 David Sanderson <mr.davidsanderson@gmail.com>
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
package mr.davidsanderson.uml.core.render;

//import java.awt.Color;
//import java.awt.Font;
import gwt.g2d.client.graphics.Color;

import java.util.Map;
import java.util.StringTokenizer;

import org.modsl.core.agt.model.MetaType;

/**
 * Loads element styles from given (colon-separated) path
 * 
 * @author avishnyakov
 */
public class StyleLoader {

    protected String getProp(Map<String, String> props, String key) {
        String v = props.get(key);
        if (v != null) {
            v.trim();
        }
        return v;
    }    

	public void load(Class<? extends MetaType> metaTypeClass,
			Map<String, String> props) {
		Style last = new Style();
        String p;

        for (MetaType mt : metaTypeClass.getEnumConstants()) {
            if ((p = getProp(props, mt.toString() + ".fontName")) != null) {
                last.fontName = p;
            }
            if ((p = getProp(props, mt.toString() + ".fontSize")) != null) {
                last.fontSize = Integer.parseInt(p);
            }
            if ((p = getProp(props, mt.toString() + ".fontStyle")) != null) {
//                last.fontStyle = 0;
                last.underline = false;
                last.fontStyle = p.toUpperCase();
//                if (p.indexOf("BOLD") > -1) {
//                    last.fontStyle |= Font.BOLD;
//                }
//                if (p.indexOf("ITALIC") > -1) {
//                    last.fontStyle |= Font.ITALIC;
//                }
//                if (p.indexOf("UNDERLINE") > -1) {
//                    last.underline = true;
//                }
            }
            if ((p = getProp(props, mt.toString() + ".fontColor")) != null) {
                last.fontColor = decodeColor(p);
            }
            if ((p = getProp(props, mt.toString() + ".strokeColor")) != null) {
                last.strokeColor = decodeColor(p);
            }
            if ((p = getProp(props, mt.toString() + ".strokeWidth")) != null) {
                last.strokeWidth = Float.parseFloat(p);
            }
            if ((p = getProp(props, mt.toString() + ".fillColor")) != null) {
                last.fillColor = decodeColor(p);
                last.gradient = decodeGradient(p);
            }
            mt.setStyle((Style) last.clone());
        }
	}

    /**
     * Decodes string r, g, b[, alpha] into a Color object
     * @param string
     * @return color object
     */
    Color decodeColor(String p) {
        StringTokenizer st = new StringTokenizer(p, ",");
        if (st.countTokens() > 4) {
            return null;
        }
        int[] d = new int[4];
        int tokens = 0;
        while (st.hasMoreTokens()) {
            d[tokens] = Integer.parseInt(st.nextToken().trim());
            tokens++;
        }
        if (tokens == 4) {
            return new Color(d[0], d[1], d[2], d[3]);
        } else {
            return new Color(d[0], d[1], d[2]);
        }
    }

    /**
     * Decodes string x1, y1, r, g, b[, alpha], x2, y2, r, g, b[, alpha] into a
     * Gradient object
     * @param string
     * @return color object
     */
    Gradient decodeGradient(String p) {
        StringTokenizer st = new StringTokenizer(p, ",");
        int cnt = st.countTokens();
        if (cnt < 10) {
            return null;
        }
        int[] d = new int[cnt];
        int tokens = 0;
        while (st.hasMoreTokens()) {
            d[tokens] = Integer.parseInt(st.nextToken().trim());
            tokens++;
        }
        return new Gradient(d);
    }

}
