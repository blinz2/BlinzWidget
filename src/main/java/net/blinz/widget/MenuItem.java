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
import org.blinz.input.MouseListener;

public class MenuItem extends Button implements MouseListener {

    boolean condition = false;
    private boolean outGoingCondition = false;

    public MenuItem() {
    }

    public boolean condition() {
        return outGoingCondition;
    }

    @Override
    public void buttonClick(int buttonNumber, int numberOfClicks, int cursorX, int cursorY) {
        if (buttonNumber == 1) {
            condition = true;
        }
    }

    @Override
    public void buttonPress(int buttonNumber, int cursorX, int cursorY) {
    }

    @Override
    public void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
    }

    protected void update() {
        outGoingCondition = condition;
        condition = false;
    }

    void delete() {
    }

    @Override
    protected void initComponent() {
    }

    @Override
    protected void draw(final Graphics b, final int x, final int y) {
    }
}
