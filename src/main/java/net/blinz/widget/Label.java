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

import org.blinz.graphics.Font;
import org.blinz.graphics.FontLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.blinz.graphics.Color;
import org.blinz.graphics.Graphics;

/**
 *
 * @author gary
 */
public class Label extends Component {

    String text = "";
    Font font;
    private Color color = new Color();
    private int fontSize = 12;

    public Label() {
        try {
            font = FontLoader.getFont("serif", fontSize);
        } catch (Exception ex) {
            Logger.getLogger(Label.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(final String text) {
        this.text += text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    /**
     *
     * @return the text contained within this label
     */
    public String getText() {
        return text;
    }

    public void setFontSize(final int size) {
        fontSize = size;
    }

    public void setFont(final Font font) {
        this.font = font;
    }

    @Override
    protected void initComponent() {
    }

    @Override
    protected void draw(final Graphics g, final int x, final int y) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, x, y);
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
