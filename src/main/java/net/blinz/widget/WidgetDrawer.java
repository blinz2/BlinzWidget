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

import org.blinz.graphics.Color;
import org.blinz.graphics.Font;
import org.blinz.graphics.Graphics;
import org.blinz.util.Bounds;
import org.blinz.util.Position;
import org.blinz.util.Size;

/**
 *
 * @author gary
 */
class WidgetDrawer {

    Graphics b;
    Bounds bounds = new Bounds();
    private Font font;

    final void setGraphicsContext(Graphics b) {
        this.b = b;
    }

    final void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    final void setBounds(int x, int y, int width, int height) {
        bounds.setBounds(x, y, width, height);
    }

    final void setColor(int red, int green, int blue) {
        b.setColor(red, green, blue);
    }

    final void setColor(Color color) {
        b.setColor(color);
    }

    final void drawRect(Position loc, Size size) {
        drawRect(loc.x, loc.y, size.width, size.height);
    }

    final void drawRect(int x, int y, int width, int height) {
        drawLine(x, y, x + width, y);
        drawLine(x + width, y, x + width, y + height);
        drawLine(x + width, y + height, x, y + height);
        drawLine(x, y + height, x, y);
    }

    final void drawLine(int x1, int y1, int x2, int y2) {
        if (bounds.contains(x1, y1) || bounds.contains(x2, y2)) {
            //Deal with coordinates less than 0.
            if (x1 < bounds.getX()) {
                x1 = bounds.getX();
            }
            if (x2 < bounds.getX()) {
                x2 = bounds.getX();
            }
            if (y1 < bounds.getY()) {
                y1 = bounds.getY();
            }
            if (y2 < bounds.getY()) {
                y2 = bounds.getY();
            }
            //Deal with coordinates greater than that of bounds.
            if (x1 > bounds.getWidth()) {
                x1 = bounds.getWidth();
            }
            if (x2 > bounds.getWidth()) {
                x2 = bounds.getWidth();
            }
            if (y1 > bounds.getHeight()) {
                y1 = bounds.getHeight();
            }
            if (y2 > bounds.getHeight()) {
                y2 = bounds.getHeight();
            }
//            y1 = flipY(y1, y2 - y1);
//            y2 = flipY(y2, y2 - y1);
//            b.drawLine(x1, y1, x2, y2);
        }
    }

    final void fillRect(Position loc, Size size) {
        fillRect(loc.x, loc.y, size.width, size.height);
    }

    final void fillRect(int x, int y, int width, int height) {
        if (x < bounds.getX()) {
            x = bounds.getX();
        }
        if (y < bounds.getY()) {
            y = bounds.getX();
        }
        if (width < bounds.getWidth()) {
            width = bounds.getWidth();
        }
        if (height < bounds.getHeight()) {
            height = bounds.getHeight();
        }

//        System.out.println(y);
//        y = flipY(y, height);
//        System.out.println(y);

        b.fillRect(x, y, width, height);
    }

    final void drawText(String text, Position loc, String font, int size) {
        drawText(text, loc.x, loc.y, font, size);
    }

    final void drawText(String text, int x, int y, String font, int size) {
        b.drawString(text, x, y);
    }

    final void drawChar(char character, Position loc, Font font, int size) {
        drawChar(character, loc.x, loc.y, font, size);
    }

    final void drawChar(char character, int x, int y, Font font, int size) {
        String text = "" + character;
        b.drawString(text, x, y, font);
    }

    final int getCharWidth(char character, Font font, int size) {
        return font.getCharWidth(character);
    }

    final int flipY(int y, int height) {
        return ((y - height) + bounds.getHeight()) + y;
    }
}
