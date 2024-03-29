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
package mr.davidsanderson.uml.core.lang.uml.render;

import static java.lang.Math.PI;
import gwt.g2d.client.graphics.shapes.ShapeBuilder;

import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.Edge;
import org.modsl.core.agt.model.Pt;
import org.modsl.core.lang.uml.UMLMetaType;

public class ClassAggregateArrowEdgeRenderVisitor extends AbstractArrowEdgeRenderVisitor {

    static final double DIAMOND_SCALE = 1.5d;

    @Override
    public void apply(Edge e) {
//        g.setStroke(NORMAL_STROKE);
        draw(e, getDiamondEnd(e), e.getNode2Port());
//        g.setStroke(NORMAL_STROKE);
        drawSides(e);
//        g.setStroke(NORMAL_STROKE);
        drawDiamond(e);
    }

    void drawDiamond(Edge e) {
    	Style s = e.getType().getStyle();
        Pt offe = getDiamondEnd(e);
        Pt offl = getOffsetPoint1(e, e.angle1() - getArrowAngle() / 2d, getArrowLength() * DIAMOND_SCALE / 2d);
        Pt offr = getOffsetPoint1(e, e.angle1() + getArrowAngle() / 2d, getArrowLength() * DIAMOND_SCALE / 2d);
//        g.drawLine((int) offl.x, (int) offl.y, (int) e.getNode1Port().x, (int) e.getNode1Port().y);
//        g.drawLine((int) offl.x, (int) offl.y, (int) offe.x, (int) offe.y);
        g.setStrokeStyle(s.getGWTStrokeColor())
        .strokeShape(
                new ShapeBuilder()
                .moveTo(offl.x,  offl.y)
                .drawLineTo( e.getNode1Port().x, e.getNode1Port().y)
                .moveTo( offl.x,  offl.y)
                .drawLineTo(offe.x, (int) offe.y)
                .moveTo( offr.x, offr.y)
                .drawLineTo( e.getNode1Port().x,  e.getNode1Port().y)
                .moveTo( offr.x,  offr.y)
                .drawLineTo( offe.x, offe.y)
                .build()
        );
        
//        g.drawLine((int) offr.x, (int) offr.y, (int) e.getNode1Port().x, (int) e.getNode1Port().y);
//        g.drawLine((int) offr.x, (int) offr.y, (int) offe.x, (int) offe.y);
    }

    Pt getDiamondEnd(Edge e) {
        return getOffsetPoint1(e, e.angle1(), getArrowLength() * DIAMOND_SCALE * Math.cos(getArrowAngle() / 2d));
    }

    @Override
    protected double getArrowAngle() {
        return PI / 5d;
    }

    @Override
    protected double getArrowLength() {
        return UMLMetaType.COLLAB_EDGE.getStyle().getArrowLength();
    }

}
