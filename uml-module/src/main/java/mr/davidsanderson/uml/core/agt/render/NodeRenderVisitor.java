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

package mr.davidsanderson.uml.core.agt.render;

import mr.davidsanderson.uml.core.render.Gradient;
import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.Node;

import com.allen_sauer.gwt.log.client.Log;


public class NodeRenderVisitor extends AbstractRenderVisitor {

    @Override
    public void apply(Node node) {
        Style s = (Style)node.getType().getStyle();
        Gradient gr = s.getGradient();
        if (gr != null) {
        	Log.debug("NodeRenderVisitor.apply gradient " + node.getType().toString());
        	g = g.setFillStyle(gr.getGradientPaint(node.getPos(), node.getSize()));
        } else {
        	Log.debug("NodeRenderVisitor.apply no gradient "+ node.getType().toString());
            g = g.setFillStyle(s.getGWTFillColor());
        }
        g.fillRectangle((double) node.getPos().x, (double) node.getPos().y, (double) node.getSize().x, (double) node.getSize().y)
        .setStrokeStyle(s.getGWTStrokeColor())
        .strokeRectangle((double) node.getPos().x, (double) node.getPos().y, (double) node.getSize().x, (double) node.getSize().y);
    }

}
