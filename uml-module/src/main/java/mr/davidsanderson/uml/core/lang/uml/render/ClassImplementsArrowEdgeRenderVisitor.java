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

package mr.davidsanderson.uml.core.lang.uml.render;

import gwt.g2d.client.graphics.shapes.ShapeBuilder;

import org.modsl.core.agt.model.Edge;

import com.allen_sauer.gwt.log.client.Log;

public class ClassImplementsArrowEdgeRenderVisitor extends
		ClassExtendsArrowEdgeRenderVisitor {

	@Override
	public void apply(Edge e) {
		Log.debug("ClassImplementsArrowEdgeRenderVisitor.apply");
		// g.setStroke(DASHED_STROKE);
		draw(e, e.getNode1Port(), getMidPoint(e));
		// g.setStroke(NORMAL_STROKE);
		drawSides(e);
		// g.setStroke(NORMAL_STROKE);
		drawButt(e);
	}

	class DashState {
		boolean drawing = true;
		int patternIndex = 0;
		double offset = 5;
		boolean styleInited;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modsl.gwt.render.EdgeRenderVisitor#drawLineStyle(gwt.g2d.client.graphics
	 * .shapes.ShapeBuilder, double, double, double, double)
	 */
	@Override
	protected ShapeBuilder drawLineStyle(ShapeBuilder shapeBuilder,
			double x0, double y0, double endX, double endY) {
		Log.debug("ClassImplementsArrowEdgeRenderVisitor.drawLineStyle");
		// var blankStyle = "rgba(255,255,255,1)"; // fully transparent
		double startX = x0, startY = y0;
		DashState dashState = new DashState();
		double[] dashPattern = new double[] { 15, 5 };
		
		double dX = endX - x0;
		double dY = endY - y0;
		double len = Math.sqrt(dX * dX + dY * dY);
		dX /= len;
		dY /= len;
		double tMax = len;

		double t = -dashState.offset;
		boolean bDrawing = dashState.drawing;
		int patternIndex = dashState.patternIndex;
		boolean styleInited = dashState.styleInited;
		while (t < tMax) {
			t += dashPattern[patternIndex];
			if (t < 0) {
				double x = 5;
			}
			if (t >= tMax) {
				dashState.offset = dashPattern[patternIndex] - (t - tMax);
				dashState.patternIndex = patternIndex;
				dashState.drawing = bDrawing;
				dashState.styleInited = true;
				t = tMax;
			}

			if (bDrawing) {
				shapeBuilder = shapeBuilder.moveTo(startX, startY);
				startX = x0 + t*dX; 
				startY = y0 + t*dY;
				// ctx.lineTo(startX,startY);
				// ctx.stroke();
				shapeBuilder = shapeBuilder.drawLineTo(startX, startY);
			} else {
				startX = x0 + t*dX; 
				startY = y0 + t*dY;
			}

			bDrawing = !bDrawing;
			patternIndex = (patternIndex + 1) % dashPattern.length;
		}

		return shapeBuilder.drawLineTo(endX, endY).moveTo(endX, endY);
	}
}
