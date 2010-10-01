/*
 * BlinzWidget - a library of GUI widgets for the BlinzFramework
 * Copyright (C) 2009-2010 BlinzProject <gtalent2@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.blinz.widget;

import java.util.ArrayList;
import org.blinz.graphics.Graphics;

/**
 * A Component that holds and displays other Components.
 * @author Blinz
 */
public abstract class Container extends Component {

    private final ArrayList<Component> components = new ArrayList<Component>();
    
    /**
     * Adds the given Component to this Container to be drawn and passed relevant input.
     * @param component the Component to add
     */
    public final void addComponent(final Component component) {
        components.add(component);
        component.viewerBounds = viewerBounds;
        component.initComponent();
    }

    /**
     * Remove the given Component from this Container so that it will no longer be drawn or passed input.
     * @param component the Component to remove
     */
    public final void removeComponent(final Component component) {
        components.remove(this);
    }

    @Override
    protected void draw(final Graphics g, final int x, final int y) {
        g.enterViewport(getX(), getY(), getWidth(), getHeight());
        for (final Component c : components) {
            if (viewerBounds.intersects(c.getX(), c.getY(), c.getWidth(), c.getHeight())) {
                //draw component
                g.enterViewport(c.getX(), c.getY(), c.getWidth(), c.getHeight());
                c.draw(g, x + getX() - viewerBounds.getX(), y + getY() - viewerBounds.getY());
                g.exitViewport();
            }
        }
        g.exitViewport();
    }
}
