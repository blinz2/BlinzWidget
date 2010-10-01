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

import org.blinz.graphics.Graphics;
import org.blinz.util.Bounds;
import org.blinz.util.Position;
import org.blinz.util.Size;

/**
 * Base type for all GUI elements.
 * @author Blinz Project
 */
public abstract class Component {

    Bounds viewerBounds = new Bounds();
    private final Position location = new Position();
    private final Size size = new Size();
    boolean hasFocus = false;

    public final void setX(final int x) {
        location.setX(x);
    }

    public final void setY(final int y) {
        location.setY(y);
    }

    public final void setPosition(final int x, final int y) {
        location.setPosition(x, y);
    }

    public final int getX() {
        return location.x;
    }

    public final int getY() {
        return location.y;
    }

    public final void setWidth(final int width) {
        size.setWidth(width);
    }

    public final void setHeight(final int height) {
        size.setHeight(height);
    }

    public final void setSize(final int width, final int height) {
        size.setSize(width, height);
    }

    public final int getWidth() {
        return size.width;
    }

    public final int getHeight() {
        return size.height;
    }

    void setFocus(final boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    protected abstract void initComponent();

    protected abstract void buttonClick(final int buttonNumber, final int clickCount, final int cursorX, final int cursorY);

    protected abstract void buttonPress(final int buttonNumber, final int cursorX, final int cursorY);

    protected abstract void buttonRelease(final int buttonNumber, final int cursorX, final int cursorY);

    protected abstract void draw(final Graphics g, final int x, final int y);
}
