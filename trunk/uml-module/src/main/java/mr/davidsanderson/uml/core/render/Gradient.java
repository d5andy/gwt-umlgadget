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
//import java.awt.GradientPaint;

import gwt.g2d.client.graphics.Color;
import gwt.g2d.client.graphics.LinearGradient;

import org.modsl.core.agt.model.Pt;

/**
 * Gradient fill
 * @author avishnyakov
 */
public class Gradient {

    Color startColor, endColor;
    Pt start, end;

    public Gradient(int[] parameters) {
        if (parameters.length == 10) { // no alpha
            start = new Pt(parameters[0], parameters[1]);
            startColor = new Color(parameters[2], parameters[3], parameters[4]);
            end = new Pt(parameters[5], parameters[6]);
            endColor = new Color(parameters[7], parameters[8], parameters[9]);
        } else { // both have alpha
            start = new Pt(parameters[0], parameters[1]);
            startColor = new Color(parameters[2], parameters[3], parameters[4], parameters[5]);
            end = new Pt(parameters[6], parameters[7]);
            endColor = new Color(parameters[8], parameters[9], parameters[10], parameters[11]);
        }
    }

    /**
     * Return gradient paint calculated from (start, end) percentages (0-100%) for the given box of (pos, size)
     * @param pos
     * @param size
     * @return
     */
    public LinearGradient getGradientPaint(Pt pos, Pt size) {
        double x1 = pos.x + start.x / 100d * size.x;
        double y1 = pos.y + start.y / 100d * size.y;
        double x2 = pos.x + end.x / 100d * size.x;
        double y2 = pos.y + end.y / 100d * size.y;
    	return this.getGradientPaint(x1, y1, x2, y2);
    }
    public LinearGradient getGradientPaint(double x1, double y1, double x2, double y2) {
        LinearGradient linearGradient = new LinearGradient(x1, y1, x2, y2);
        linearGradient.addColorStop(0, startColor);
        linearGradient.addColorStop(1, endColor);
        return linearGradient; 
    }

}
