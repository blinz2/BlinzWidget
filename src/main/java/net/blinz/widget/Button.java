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

/**
 *
 * @author Blinz Project
 */
public class Button extends Component {

    private String text = "Button";

    /**
     * Creates a new Button.
     */
    public Button() {
        setSize(150, 50);
    }

    /**
     * Creates a new button setting the buttons text to that given.
     * @param text the text to be displayed in the Buttons label
     */
    public Button(final String text) {
        setSize(150, 50);
        this.text = text;
    }

    @Override
    protected void initComponent() {
    }

    @Override
    protected void draw(final Graphics g, int x, int y) {
    }

    @Override
    protected void buttonClick(final int buttonNumber, final int clickCount, final int cursorX, int cursorY) {
    }

    @Override
    protected void buttonPress(final int buttonNumber, final int cursorX, final int cursorY) {
    }

    @Override
    protected void buttonRelease(final int buttonNumber, final int cursorX, final int cursorY) {
    }
}
