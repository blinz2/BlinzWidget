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
import org.blinz.util.Size;

/**
 *
 * @author gary
 */
public class Frame extends Window {

    private class TitleBar extends Container {

        Size frameSize;
        Label title = new Label();

        public TitleBar(Size frameSize) {
            this.frameSize = frameSize;
        }

        @Override
        protected void initComponent() {
            setPosition(0, frameSize.height);
            setHeight(8);
            title.setText("Frame");
            title.setSize(frameSize.width, getHeight());
        }

        @Override
        protected void draw(Graphics b, int x, int y) {
            b.setColor(127, 127, 127);
            b.fillRect(getX() + x, getY() + y, frameSize.width, 16);
            title.draw(b, x, y);
        }

        @Override
        protected void buttonClick(int buttonNumber, int clickCount, int cursorX, int cursorY) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        protected void buttonPress(int buttonNumber, int cursorX, int cursorY) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        protected void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public Frame(int width, int height) {
        super(width, height);
//        addComponent(new TitleBar(size));
    }
}

