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
import org.blinz.util.Bounds;
import org.blinz.util.Position;
import org.blinz.util.Size;

/**
 *
 * @author gary
 */
public class Window extends Component {

    private WindowManager manager;
    private final ArrayList<Component> components = new ArrayList<Component>();
    private String title = "Generic Frame";
    private final Position location = new Position();
    private final Size size = new Size();
    private final Bounds bounds = new Bounds();

    public Window(int width, int height) {
        size.setSize(width, height);
    }

    /**
     * Adds the given component to be displayed in this Window.
     * @param component
     */
    public void addComponent(Component component) {
        component.viewerBounds = bounds;
        component.initComponent();
        components.add(component);
    }

    @Override
    public void setFocus(boolean hasFocus) {
        if (this.hasFocus && hasFocus) {
            this.hasFocus = hasFocus;
        } else {
        }
    }

    protected void buttonClick(int buttonNumber, int numberOfClicks, int cursorX, int cursorY) {
    }

    protected void buttonPress(int buttonNumber, int cursorX, int cursorY) {
        bounds.setPosition(location);
        bounds.setSize(size);
        setFocus(bounds.contains(cursorX, cursorY));
    }

    protected void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
    }

    @Override
    protected void draw(Graphics g, int x, int y) {
        g.setColor(0, 64, 128);
        g.fillRect(location.x, location.y, size.width, size.height);
        g.setColor(0, 0, 0);
        g.drawRect(location.x, location.y, size.width, size.height);
        for (Component c : components) {
            g.enterViewport(c.getX(), c.getY(), c.getWidth(), c.getHeight());
            c.draw(g, location.x + c.getX(), location.y + c.getY());
            g.exitViewport();
        }
    }

    @Override
    protected void initComponent() {
    }
}
