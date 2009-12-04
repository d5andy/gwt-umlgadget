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

import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.EdgeLabel;

public class EdgeLabelRenderVisitor extends AbstractRenderVisitor {

    @Override
    public void apply(EdgeLabel label) {
        
        Style s = label.getType().getStyle();
        g.setStrokeStyle(s.getGWTStrokeColor())
        .setFont(s.getGWTFont())
        .strokeText(label.getName(), (float) label.getTextPos().x, (float) label.getTextPos().y)
        .setFont(s.getGWTFont())
        .setFillStyle(s.getGWTFontColor())
        .fillText(label.getName(), (float) label.getTextPos().x, (float) label.getTextPos().y);
        
    }

}
