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

import org.blinz.util.Position;

/**
 *
 * @author gary
 */
public class Panel extends Container {

    private final Position loc = new Position();

    public void setLocationWithinFrame(int x, int y) {
        loc.setPosition(x, y);
    }

    @Override
    protected void initComponent() {
        setX(loc.x);
        setY(loc.y);
    }

    @Override
    protected void buttonClick(int buttonNumber, int clickCount, int cursorX, int cursorY) {
    }

    @Override
    protected void buttonPress(int buttonNumber, int cursorX, int cursorY) {
    }

    @Override
    protected void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
    }
}
