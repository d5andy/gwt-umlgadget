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

package org.modsl.core.agt.model;

import org.modsl.core.agt.visitor.AbstractVisitor;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Bend extends AbstractBox<Edge> implements IsSerializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7985452823650217762L;
	private static int counter = 0;

    public Bend() {
        super();
        this.name = "b" + counter;
        this.index = counter++;
    }

    public Bend(Pt pos) {
        this.pos = pos;
    }

    @Override
    public boolean isVirtual() {
        return true;
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.in(this);
        visitor.out(this);
    }

    @Override
    public boolean isConnectedTo(AbstractBox<?> box) {
        if (parent.getDistance(this, box) == 1) {
            return true;
        }
        return false;
    }

    public Pt getCtrlPt() {
        Pt p = getPos();
        /*
         * double c = parent.getNode1().cos(parent.getNode2()); double s =
         * parent.getNode1().sin(parent.getNode2()); p.x =
         * parent.getNode2().getPos().x; p.y = parent.getNode2().getPos().y;
         */
        return p;
    }

}
