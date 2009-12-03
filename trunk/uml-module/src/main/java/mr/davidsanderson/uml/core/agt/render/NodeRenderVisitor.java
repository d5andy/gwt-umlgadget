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

package mr.davidsanderson.uml.core.agt.render;

import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.Node;


public class NodeRenderVisitor extends AbstractRenderVisitor {

    @Override
    public void apply(Node node) {
        Style s = (Style)node.getType().getStyle();
//        Gradient gr = null;//s.getGradient();
//        if (gr != null) {
////            GradientPaint gpt = gr.getGradientPaint(node.getPos(), node.getSize());
////            g.setPaint(gpt);
//        } else {
//            g.setFillStyle(s.getGWTFillColor());
//        }
        g.setFillStyle(s.getGWTFillColor());
        g.fillRectangle((double) node.getPos().x, (double) node.getPos().y, (double) node.getSize().x, (double) node.getSize().y);//, 4, 4);
        g.setStrokeStyle(s.getGWTStrokeColor());
        g.strokeRectangle((double) node.getPos().x, (double) node.getPos().y, (double) node.getSize().x, (double) node.getSize().y);
       
//        g.drawRoundRect((int) node.getPos().x, (int) node.getPos().y, (int) node.getSize().x, (int) node.getSize().y, 4, 4);
    }

}
