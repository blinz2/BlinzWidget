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
import org.blinz.util.Position;
import org.blinz.util.Size;

class Caret {

    private long timer = 0;
    private int address = 0;
    private boolean draw = false;
    Position location = new Position();
    Size size = new Size();

    Caret() {
        size.setSize(1, 12);
    }

    void decrementAddress() {
        address--;
        if (address < 0) {
            address++;
        }
    }

    void incrementAddress() {
        address++;
    }

    int getAddress() {
        return address;
    }

    void draw(Graphics b) {
        if (draw) {
            b.fillRect(location, size);
        }
    }

    void update() {
        if (System.currentTimeMillis() - timer >= 500) {
            if (draw) {
                draw = false;
            } else {
                draw = true;
            }
            timer = System.currentTimeMillis();
        }
    }
}
