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

public class TextFeild extends Container {

    private String text = "";
    private String beforeCaret;
    private String afterCaret;
    private Caret caret = new Caret();

    public TextFeild() {
    }

    protected void updateHUDItem() {

        beforeCaret = text.substring(0, caret.getAddress());
        afterCaret = text.substring(caret.getAddress());

        caret.update();
    }

    @Override
    protected void initComponent() {
    }

    @Override
    protected void draw(Graphics g, int x, int y) {
        g.setColor(127, 127, 127);
        g.fillRect(getX() + x, getY() + y, getWidth(), getHeight());
        g.setColor(0, 0, 0);
        g.drawRect(x, y, x + getWidth(), y + getHeight());
//        g.setColor(Color.blue);
//        g.drawString(beforeCaret, location.x + 3, location.y + size.height - 3);
//        g.drawString(afterCaret, location.x + 3 + g.getFontMetrics().stringWidth(beforeCaret), location.y + size.height - 3);
//        caret.location.setLocation(location.x + 3 + g.getFontMetricys().stringWidth(beforeCaret), location.y + 2);
        g.setColor(0, 0, 0);
        caret.draw(g);
    }

    private void prepareDrawString() {
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
