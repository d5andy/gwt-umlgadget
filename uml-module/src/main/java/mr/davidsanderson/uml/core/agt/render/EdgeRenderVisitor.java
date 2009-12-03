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


import gwt.g2d.client.graphics.shapes.ShapeBuilder;

import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.Bend;
import org.modsl.core.agt.model.Edge;
import org.modsl.core.agt.model.Pt;

import com.allen_sauer.gwt.log.client.Log;

public class EdgeRenderVisitor extends AbstractRenderVisitor {

//    protected static BasicStroke NORMAL_STROKE = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
//
//    protected static BasicStroke DASHED_STROKE = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
//            new float[] { 10.0f, 5.0f }, 0.0f);

    @Override
    public void apply(Edge e) {
//        g.setStroke(NORMAL_STROKE);
        draw(e, e.getNode1Port(), e.getNode2Port());
    }

    protected void draw(Edge e, Pt startPoint, Pt endPoint) {
        Style s = e.getType().getStyle();
//        g.setColor(s.getStrokeColor());
        double cx = startPoint.x;
        double cy = startPoint.y;
        
        ShapeBuilder shapeBuilder = new ShapeBuilder().moveTo(cx,cy);
        
        for (Bend b : e.getBends()) {
            double nx = b.getPos().x;
            double ny = b.getPos().y;
//            g.drawLine(cx, cy, nx, ny);
            shapeBuilder =  drawLineStyle(shapeBuilder, cx, cy, nx, ny);
            cx = nx;
            cy = ny;
        }
        shapeBuilder = drawLineStyle(shapeBuilder, cx, cy, endPoint.x, endPoint.y);
        g.setStrokeStyle(s.getGWTStrokeColor())
        .strokeShape(shapeBuilder.build());
//        g.drawLine(cx, cy, (int) endPoint.x, (int) endPoint.y);
    }
    
    protected ShapeBuilder drawLineStyle(ShapeBuilder shapeBuilder, double startX, double startY, double endX, double endY) {
    	Log.debug("EdgeRenderVisitor.drawLineStyle");
    	return shapeBuilder.drawLineTo(endX, endY).moveTo(endX, endY);
    }

}
