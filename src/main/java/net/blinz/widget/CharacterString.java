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
 * A chunk of contiguous characters with the same formatting.
 * @author Blinz
 */
class CharacterString {

    private String string = "";
    private short size = 12;

    @Override
    public final String toString(){
        return string;
    }

    /**
     * Sets the value of this string.
     * @param string the new value of this string
     */
    final void setString(final String string){
        this.string = string;
    }

    /**
     * Gets the font size for this string.
     * @return the font size for this string
     */
    final short getSize(){
        return size;
    }

    /**
     * Sets the font size for this string.
     * @param size the font size for this string
     */
    final void setSize(int size){
        if(size < 1) size = 1;
        if(size > 127) size = 127;
        this.size = (byte)size;
    }

}
