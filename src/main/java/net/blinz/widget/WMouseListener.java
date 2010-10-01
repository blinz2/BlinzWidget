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

/**
 * A mouse listener class limited to the widget package so not to export the mouse
 * listening methods.
 * @author Blinz Project
 */
interface WMouseListener {

    abstract void buttonClick(int buttonNumber, int clickCount, int cursorX, int cursorY);

    abstract void buttonPress(int buttonNumber, int cursorX, int cursorY);

    abstract void buttonRelease(int buttonNumber, int cursorX, int cursorY);
}
