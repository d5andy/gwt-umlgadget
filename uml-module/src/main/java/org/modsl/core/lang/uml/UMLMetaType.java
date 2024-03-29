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

package org.modsl.core.lang.uml;

import mr.davidsanderson.uml.core.render.Style;

import org.modsl.core.agt.model.MetaType;

/**
 * UML meta-types
 * @author AVishnyakov
 */
public enum UMLMetaType implements MetaType {

    // Collaboration
    COLLAB_GRAPH,

    COLLAB_NODE,
    COLLAB_NODE_LABEL,

    COLLAB_EDGE,
    COLLAB_EDGE_LABEL,

    // Sequence
    SEQ_GRAPH,

    SEQ_NODE,
    SEQ_NODE_LABEL,

    SEQ_EDGE,
    SEQ_EDGE_LABEL,

    // Class
    CLASS_GRAPH,

    CLASS_CLASS_NODE,
    CLASS_CLASS_NODE_LABEL,
    CLASS_ABSTRACT_CLASS_NODE,
    CLASS_ABSTRACT_CLASS_NODE_LABEL,
    CLASS_INTERFACE_NODE,
    CLASS_INTERFACE_NODE_LABEL,
    CLASS_VAR_NODE_LABEL,
    CLASS_METHOD_NODE_LABEL,
    CLASS_ABSTRACT_METHOD_NODE_LABEL,
    CLASS_STATIC_VAR_NODE_LABEL,
    CLASS_STATIC_METHOD_NODE_LABEL,

    CLASS_EXTENDS_EDGE,
    CLASS_IMPLEMENTS_EDGE,

    CLASS_AGGREGATION_EDGE,
    CLASS_COMPOSITION_EDGE,
    CLASS_MULTIPLICITY_FROM_EDGE_LABEL,
    CLASS_MULTIPLICITY_TO_EDGE_LABEL;
    
    Style style;

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

}
