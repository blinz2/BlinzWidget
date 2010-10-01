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

import org.blinz.input.InputTrigger;
import org.blinz.util.Position;
import org.blinz.util.Size;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Menu {

    private Size dimensions = new Size();
    private Size cellSize = new Size();
    private MenuItem[][] menuItems;
    private Position cursorAddress = new Position(1, 1);
    private InputTrigger up, down, left, right, enter;
    private ArrayList<Menu> subMenuList = new ArrayList<Menu>();
    private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
    /**
     * X coordinate of this Menu on the screen.
     */
    private int x = 0;
    /**
     * Y coordinate of this Menu on the screen.
     */
    private int y = 0;

    public Menu(int width, int height) {
        dimensions.setSize(width, height);
        menuItems = new MenuItem[width][height];
    }

    public Menu(Size dimension) {
        dimension.setSize(dimension);
        menuItems = new MenuItem[dimension.width][dimension.height];
    }

    //PUBLIC METHODS////////////////////////////////////////////////////////////
    public boolean addMenuItem(MenuItem menuItem) {
        for (int yi = 0; yi < dimensions.height; yi++) {
            for (int xi = 0; xi < dimensions.height; xi++) {
                if (menuItems[xi][yi] == null) {
                    menuItems[xi][yi] = menuItem;
                    //Set the menu item to the proper location
                    if (menuItem.getWidth() > cellSize.width) {
                        cellSize.width = menuItem.getWidth();
                    }//end of if

                    if (menuItem.getHeight() > cellSize.height) {
                        cellSize.height = menuItem.getHeight();
                    }
                    menuItem.setPosition((x + (cellSize.width * xi)),
                            (y + (cellSize.height * yi)));
                    return true;
                }
            }
        }
        menuItemList.add(menuItem);
        return false;
    }

    public void removeMenuItem(MenuItem menuItem) {
        for (int yi = 0; yi < dimensions.height; yi++) {
            for (int xi = 0; xi < dimensions.height; xi++) {
                if (menuItems[xi][yi].equals(menuItem)) {
                    menuItems[xi][yi] = null;
                }
            }
        }
        menuItemList.remove(menuItem);
    }

    public void createBEvents() {
        this.up = new InputTrigger(InputTrigger.KEYBOARD, KeyEvent.VK_UP);
        this.down = new InputTrigger(InputTrigger.KEYBOARD, KeyEvent.VK_DOWN);
        this.left = new InputTrigger(InputTrigger.KEYBOARD, KeyEvent.VK_LEFT);
        this.right = new InputTrigger(InputTrigger.KEYBOARD, KeyEvent.VK_RIGHT);
        this.enter = new InputTrigger(InputTrigger.KEYBOARD, KeyEvent.VK_ENTER);
    }

    public void delete() {
        for (int i = 0; i < subMenuList.size(); i++) {
            subMenuList.get(i).delete();
            subMenuList.remove(i);
        }

        for (int i = 0; i < menuItemList.size(); i++) {
            menuItemList.get(i).delete();
        }

    }

    public void moveCursorUp() {
        if (menuIsPopulated()) {
            Position tempCursorAddress = new Position();
            while (menuItems[tempCursorAddress.x][tempCursorAddress.y] == null) {
                if (tempCursorAddress.y > 0) {
                    tempCursorAddress.y--;
                } else {
                    tempCursorAddress.y = dimensions.height;
                }
            }
            this.cursorAddress.setPosition(tempCursorAddress);
        }
    }

    public void moveCursorDown() {
        if (menuIsPopulated()) {
            Position tempCursorAddress = new Position();
            while (menuItems[tempCursorAddress.x][tempCursorAddress.y] == null) {
                if (tempCursorAddress.y < dimensions.height) {
                    tempCursorAddress.y++;
                } else {
                    tempCursorAddress.y = 0;
                }
            }
            this.cursorAddress.setPosition(tempCursorAddress);
        }
    }

    public void moveCursorRight() {
        if (menuIsPopulated()) {
            Position tempCursorAddress = new Position();
            while (menuItems[tempCursorAddress.x][tempCursorAddress.y] == null) {
                if (tempCursorAddress.x < dimensions.width) {
                    tempCursorAddress.x++;
                } else {
                    tempCursorAddress.x = 0;
                }
            }
            this.cursorAddress.setPosition(tempCursorAddress);
        }
    }

    public void moveCursorLeft() {
        if (menuIsPopulated()) {
            Position tempCursorAddress = new Position();
            while (menuItems[tempCursorAddress.x][tempCursorAddress.y] == null) {
                if (tempCursorAddress.x > 0) {
                    tempCursorAddress.x--;
                } else {
                    tempCursorAddress.x = dimensions.width;
                }
            }
            this.cursorAddress.setPosition(tempCursorAddress);
        }
    }

    public void addSubMenu(Menu menu) {
        subMenuList.add(menu);
    }

    public void removeSubMenu(Menu menu) {
        menu.delete();
        subMenuList.remove(menu);
    }

    //END OF PUBLIC METHODS/////////////////////////////////////////////////////
    //PROTECTED METHODS/////////////////////////////////////////////////////////
    protected boolean menuIsPopulated() {
        Position p = new Position();
        while (p.y < dimensions.height) {
            p.x = 0;
            while (p.x < dimensions.width) {
                if (menuItems[p.x][p.y] != null) {
                    return true;
                }
                p.x++;
            }
            p.y++;
        }
        return false;
    }

    protected Size getDimension() {
        return dimensions;
    }

    protected void update() {
        if (up != null && up.condition()) {
            moveCursorUp();
        }
        if (down != null && down.condition()) {
            moveCursorDown();
        }
        if (left != null && left.condition()) {
            moveCursorLeft();
        }
        if (right != null && right.condition()) {
            moveCursorRight();
        }
        if (enter != null && enter.condition()) {
            menuItems[cursorAddress.x][cursorAddress.y].condition = true;
        }

    }

    //END OF PROTECTED METHODS//////////////////////////////////////////////////
    //DEEFAULT ACCESS METHODS///////////////////////////////////////////////////
    MenuItem[][] getMenuItems() {
        return menuItems;
    }//END OF DEFAULT ACCESS METHODS/////////////////////////////////////////////
    //PRIVATE METHODS///////////////////////////////////////////////////////////
    //END OF PRIVATE METHODS////////////////////////////////////////////////////
}
