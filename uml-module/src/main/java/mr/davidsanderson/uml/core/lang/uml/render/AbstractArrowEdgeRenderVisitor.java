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

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import gwt.g2d.client.graphics.shapes.Shape;
import gwt.g2d.client.graphics.shapes.ShapeBuilder;

import mr.davidsanderson.uml.core.agt.render.EdgeRenderVisitor;
import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.Edge;
import org.modsl.core.agt.model.Pt;


public abstract class AbstractArrowEdgeRenderVisitor extends EdgeRenderVisitor {

    @Override
    public void apply(Edge e) {
        super.apply(e);
//        g.setStroke(NORMAL_STROKE);
        drawSides(e);
    }
    
    protected void drawSides(Edge e) {
    	Style style = e.getType().getStyle();
        Pt offl = getOffsetPoint2(e, e.angle2() - getArrowAngle() / 2d, getArrowLength());
        Pt offr = getOffsetPoint2(e, e.angle2() + getArrowAngle() / 2d, getArrowLength());
        ShapeBuilder builder = new ShapeBuilder();
        Shape shape = builder.moveTo(offl.x, offl.y)
        .drawLineTo(e.getNode2Port().x,  e.getNode2Port().y)
        .moveTo(offr.x, offr.y)
        .drawLineTo(e.getNode2Port().x, e.getNode2Port().y)
        .build();
        g.setStrokeStyle(style.getGWTStrokeColor())
        .strokeShape(shape);
        
        
        
//        g.drawLine((int) offl.x, (int) offl.y, (int) e.getNode2Port().x, (int) e.getNode2Port().y);
//        g.drawLine((int) offr.x, (int) offr.y, (int) e.getNode2Port().x, (int) e.getNode2Port().y);
    }

    protected abstract double getArrowAngle();

    abstract protected double getArrowLength();

    protected Pt getOffsetPoint1(Edge e, double alpha, double len) {
        return new Pt(e.getNode1Port().x - len * cos(alpha), e.getNode1Port().y - len * sin(alpha));
    }
    
    protected Pt getOffsetPoint2(Edge e, double alpha, double len) {
        return new Pt(e.getNode2Port().x - len * cos(alpha), e.getNode2Port().y - len * sin(alpha));
    }

}
