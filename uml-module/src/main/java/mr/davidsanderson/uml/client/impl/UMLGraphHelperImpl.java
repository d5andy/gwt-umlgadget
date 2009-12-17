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
package mr.davidsanderson.uml.client.impl;

import gwt.g2d.client.graphics.Surface;

import java.util.Map;

import mr.davidsanderson.uml.client.GraphEvent;
import mr.davidsanderson.uml.client.GraphEventBus;
import mr.davidsanderson.uml.client.UMLGraphHelper;
import mr.davidsanderson.uml.client.GraphEvent.GraphEventType;
import mr.davidsanderson.uml.core.agt.render.EdgeLabelRenderVisitor;
import mr.davidsanderson.uml.core.agt.render.GraphRenderVisitor;
import mr.davidsanderson.uml.core.agt.render.NodeLabelRenderVisitor;
import mr.davidsanderson.uml.core.agt.render.NodeRenderVisitor;
import mr.davidsanderson.uml.core.lang.uml.render.ClassAggregateArrowEdgeRenderVisitor;
import mr.davidsanderson.uml.core.lang.uml.render.ClassExtendsArrowEdgeRenderVisitor;
import mr.davidsanderson.uml.core.lang.uml.render.ClassImplementsArrowEdgeRenderVisitor;
import mr.davidsanderson.uml.core.lang.uml.render.ClassNodeRenderVisitor;
import mr.davidsanderson.uml.core.lang.uml.render.CollabArrowEdgeRenderVisitor;
import mr.davidsanderson.uml.core.render.StyleLoader;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.modsl.antlr.uml.UMLLexer;
import org.modsl.antlr.uml.UMLParser;
import org.modsl.core.agt.layout.SelfRefBenderVisitor;
import org.modsl.core.agt.layout.fr.FRLayoutVisitor;
import org.modsl.core.agt.layout.sugiyama.SugiyamaLayoutVisitor;
import org.modsl.core.agt.model.Graph;
import org.modsl.core.agt.model.ReqLayout;
import org.modsl.core.lang.uml.UMLMetaType;
import org.modsl.core.lang.uml.layout.cls.ClassEdgeLabelLayoutVisitor;
import org.modsl.core.lang.uml.layout.cls.ClassNodeLayoutVisitor;
import org.modsl.core.lang.uml.layout.cls.ClassRevertGenEdgeLayoutVisitor;
import org.modsl.core.lang.uml.layout.collab.CollabEdgeLabelLayoutVisitor;
import org.modsl.core.lang.uml.layout.collab.CollabNodeLabelLayoutVisitor;
import org.modsl.core.lang.uml.layout.seq.SeqEdgeLabelLayoutVisitor;
import org.modsl.core.lang.uml.layout.seq.SeqLayoutVisitor;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;

/**
 * @author dsand
 * 
 */
public class UMLGraphHelperImpl implements UMLGraphHelper {
	private static final String origin = UMLGraphHelper.class.getName();
	GraphEventBus graphEventBus;

	/**
	 * @param graphEventBus
	 */
	@Inject
	public UMLGraphHelperImpl(GraphEventBus graphEventBus) {
		this.graphEventBus = graphEventBus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mr.davidsanderson.uml.client.UMLGraphHelper#drawDiagram(java.lang.String,
	 * java.util.Map, gwt.g2d.client.graphics.Surface)
	 */
	public void drawDiagram(String xmlContent, Map<String, String> styles,
			Surface surface) {
		Log.debug("UMLGraphHelper.drawDiagram load styles");
		new StyleLoader().load(UMLMetaType.class, styles);
		Log.debug("UMLGraphHelper.drawDiagram stream and parse uml content");
		ANTLRStringStream input = new ANTLRStringStream(xmlContent);
		UMLLexer lexer = new UMLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		UMLParser parser = new UMLParser(tokens);

		try {
			Log.debug("UMLGraphHelper.drawDiagram parser.diagram");
			parser.diagram();
		} catch (RecognitionException e) {
			Log.error("UMLGraphHelper.drawDiagram parser.diagram failed", e);
			graphEventBus.fireEvent(new GraphEvent(origin, "PARSE ERROR: "
					+ e.getMessage(), GraphEventType.MSG_ADD));
		}

		Log.debug("UMLGraphHelper.drawDiagram layout");
		layout(parser.graph);
		Log.debug("UMLGraphHelper.drawDiagram set surface size");
		int w = (int) parser.graph.getSize().x;
		int h = (int) parser.graph.getSize().y;
		surface.setSize(w, h);

		Log.debug("UMLGraphHelper.drawDiagram render");
		render(parser.graph, surface, w, h);

	}

	protected Graph layout(Graph graph) {
		Log.debug("UMLGraphHelper.layout");

		if (UMLMetaType.CLASS_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.layout UMLMetaType.CLASS_GRAPH");

			graph.accept(new ClassNodeLayoutVisitor()
					.type(UMLMetaType.CLASS_CLASS_NODE));
			graph.accept(new ClassNodeLayoutVisitor()
					.type(UMLMetaType.CLASS_ABSTRACT_CLASS_NODE));
			graph.accept(new ClassNodeLayoutVisitor()
					.type(UMLMetaType.CLASS_INTERFACE_NODE));

			if (ReqLayout.free.equals(graph.getReqLayout())) {
				graph.accept(new FRLayoutVisitor()
						.type(UMLMetaType.CLASS_GRAPH));
			} else {
				graph.accept(new SelfRefBenderVisitor().xOffset(
						1.8d * UMLMetaType.CLASS_AGGREGATION_EDGE.getStyle()
								.getArrowLength()).type(null));
				graph.accept(new ClassRevertGenEdgeLayoutVisitor()
						.type(UMLMetaType.CLASS_IMPLEMENTS_EDGE));
				graph.accept(new ClassRevertGenEdgeLayoutVisitor()
						.type(UMLMetaType.CLASS_EXTENDS_EDGE));
				graph.accept(new SugiyamaLayoutVisitor()
						.type(UMLMetaType.CLASS_GRAPH));
				graph.accept(new ClassRevertGenEdgeLayoutVisitor()
						.type(UMLMetaType.CLASS_IMPLEMENTS_EDGE));
				graph.accept(new ClassRevertGenEdgeLayoutVisitor()
						.type(UMLMetaType.CLASS_EXTENDS_EDGE));
			}

			graph.accept(new ClassEdgeLabelLayoutVisitor()
					.type(UMLMetaType.CLASS_AGGREGATION_EDGE));

		} else if (UMLMetaType.COLLAB_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.layout UMLMetaType.COLLAB_GRAPH");

			graph.accept(new CollabNodeLabelLayoutVisitor()
					.type(UMLMetaType.COLLAB_NODE));
			if (ReqLayout.free.equals(graph.getReqLayout())) {
				graph.accept(new FRLayoutVisitor()
						.type(UMLMetaType.COLLAB_GRAPH));
			} else {
				graph.accept(new SugiyamaLayoutVisitor()
						.type(UMLMetaType.COLLAB_GRAPH));
			}
			graph.accept(new CollabEdgeLabelLayoutVisitor()
					.type(UMLMetaType.COLLAB_GRAPH));

		} else if (UMLMetaType.SEQ_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.layout UMLMetaType.SEQ_GRAPH");

			graph.accept(new CollabNodeLabelLayoutVisitor()
					.type(UMLMetaType.SEQ_NODE));
			graph.accept(new SeqLayoutVisitor().type(UMLMetaType.SEQ_GRAPH));
			graph.accept(new SeqEdgeLabelLayoutVisitor()
					.type(UMLMetaType.SEQ_GRAPH));

		}
		Log.debug("UMLGraphHelper.layout graph.rescale");

		graph.rescale();

		Log.debug("UMLGraphHelper.layout finished");
		return graph;

	}

	protected void render(Graph graph, Surface surface, int w, int h) {
		Log.debug("UMLGraphHelper.render clear surface");
		if (UMLMetaType.CLASS_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.render UMLMetaType.CLASS_GRAPH");

			graph.accept(new GraphRenderVisitor().graphics(surface, w, h).type(
					UMLMetaType.CLASS_GRAPH));

			graph.accept(new ClassExtendsArrowEdgeRenderVisitor().graphics(
					surface, w, h).type(UMLMetaType.CLASS_EXTENDS_EDGE));
			graph.accept(new ClassImplementsArrowEdgeRenderVisitor().graphics(
					surface, w, h).type(UMLMetaType.CLASS_IMPLEMENTS_EDGE));
			graph.accept(new ClassAggregateArrowEdgeRenderVisitor().graphics(
					surface, w, h).type(UMLMetaType.CLASS_AGGREGATION_EDGE));

			graph.accept(new ClassNodeRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_CLASS_NODE));
			graph.accept(new ClassNodeRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_ABSTRACT_CLASS_NODE));
			graph.accept(new ClassNodeRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_INTERFACE_NODE));

			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_CLASS_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_ABSTRACT_CLASS_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_INTERFACE_NODE_LABEL));

			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_VAR_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_STATIC_VAR_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_METHOD_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_ABSTRACT_METHOD_NODE_LABEL));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_STATIC_METHOD_NODE_LABEL));

			graph.accept(new EdgeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_MULTIPLICITY_FROM_EDGE_LABEL));
			graph.accept(new EdgeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.CLASS_MULTIPLICITY_TO_EDGE_LABEL));

		} else if (UMLMetaType.COLLAB_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.render UMLMetaType.COLLAB_GRAPH");
			graph.accept(new GraphRenderVisitor().graphics(surface, w, h).type(
					UMLMetaType.COLLAB_GRAPH));
			graph.accept(new CollabArrowEdgeRenderVisitor().graphics(surface,
					w, h).type(UMLMetaType.COLLAB_EDGE));
			graph.accept(new NodeRenderVisitor().graphics(surface, w, h).type(
					UMLMetaType.COLLAB_NODE));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.COLLAB_NODE_LABEL));
			graph.accept(new EdgeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.COLLAB_EDGE_LABEL));

		} else if (UMLMetaType.SEQ_GRAPH.equals(graph.getType())) {
			Log.debug("UMLGraphHelper.render UMLMetaType.SEQ_GRAPH");
			graph.accept(new GraphRenderVisitor().graphics(surface, w, h).type(
					UMLMetaType.SEQ_GRAPH));
			graph.accept(new NodeRenderVisitor().graphics(surface, w, h).type(
					UMLMetaType.SEQ_NODE));
			graph.accept(new NodeLabelRenderVisitor().graphics(surface, w, h)
					.type(UMLMetaType.SEQ_NODE_LABEL));

		}
		Log.debug("UMLGraphHelper.render Finished");

	}

}
