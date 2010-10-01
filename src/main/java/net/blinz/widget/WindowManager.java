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
import org.blinz.input.KeyListener;
import org.blinz.input.MouseListener;
import org.blinz.input.MouseWheelListener;

/**
 *
 * @author Blinz Project
 */
public class WindowManager {

    /**
     * Accepts input to pass onto the Windows in the WindowManager.
     */
    private final class InputListener implements MouseListener, MouseWheelListener, KeyListener {

        @Override
        public void buttonClick(int buttonNumber, int clickCount, int cursorX, int cursorY) {
        }

        @Override
        public void buttonPress(int buttonNumber, int cursorX, int cursorY) {
        }

        @Override
        public void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
        }

        @Override
        public void keyPressed(int key) {
        }

        @Override
        public void keyReleased(int key) {
        }

        @Override
        public void keyTyped(int key) {
        }

        @Override
        public void wheelScroll(int i, int i1, int i2) {
        }
    }
    /**
     * List of Windows to be drawn and receive input.
     */
    private final ArrayList<Window> windows = new ArrayList<Window>();

    /**
     * Adds the given Window to this WindowManager. The Window will be added with
     * focus by default.
     * @param window
     */
    public final void addWindow(final Window window) {
        windows.add(window);
    }
}
