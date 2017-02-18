/* =======================================
 * JFreeChart : a Java Chart Class Library
 * =======================================
 *
 * Project Info:  http://www.jrefinery.com/jfreechart
 * Project Lead:  David Gilbert (david.gilbert@jrefinery.com);
 *
 * This file...
 * $Id: AbstractTitle.java,v 1.6 2001/11/21 15:15:56 mungady Exp $
 *
 * Original Author:  David Berry;
 * Contributor(s):   David Gilbert;
 *
 * (C) Copyright 2000, 2001, David Berry;
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * Changes (from 21-Aug-2001)
 * --------------------------
 * 21-Aug-2001 : Added standard header (DG);
 * 18-Sep-2001 : Updated e-mail address in header (DG);
 * 14-Nov-2001 : Package com.jrefinery.common.ui.* changed to com.jrefinery.ui.* (DG);
 *
 */

package com.jrefinery.chart;

import java.awt.Insets;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import com.jrefinery.ui.*;
import com.jrefinery.chart.event.*;

/**
 * The base class for all chart titles.  A chart can have multiple titles, appearing at the top,
 * bottom, left or right of the chart (defined by the constants TOP, BOTTOM, LEFT and RIGHT --- we
 * also use the constants NORTH, SOUTH, EAST and WEST to remain consistent with
 * java.awt.BorderLayout, as most developers will be familiar with that class).
 * <P>
 * Concrete implementations of this class will render text, images, and hence do the actual work of
 * drawing titles.
 */
public abstract class AbstractTitle extends Object implements Cloneable {

    /** Useful constant for the title position (also used for vertical alignment); */
    public static final int TOP = 0;

    /** Useful constant for the title position (also used for vertical alignment); */
    public static final int BOTTOM = 1;

    /** Useful constant for the title position (also used for horizontal alignment); */
    public static final int RIGHT = 2;

    /** Useful constant for the title position (also used for horizontal alignment); */
    public static final int LEFT = 3;

    /** Useful constant for the title position; */
    public static final int NORTH = 0;

    /** Useful constant for the title position; */
    public static final int SOUTH = 1;

    /** Useful constant for the title position; */
    public static final int EAST = 2;

    /** Useful constant for the title position; */
    public static final int WEST = 3;

    /** Useful constant for the title alignment (horizontal or vertical); */
    public static final int CENTER = 4;

    /** Useful constant for the title alignment (horizontal or vertical); */
    public static final int MIDDLE = 4;

    /** Flag that controls whether or not the listener mechanism is used - useful for temporarily
        disabling the mechanism; */
    protected boolean notify;

    /** The position of the title (use the constants NORTH, SOUTH, EAST and WEST, or if you prefer
        you can also use TOP, BOTTOM, LEFT and RIGHT); */
    protected int position;

    /** The horizontal alignment of the title (use the constants LEFT, CENTER and RIGHT, defined in
        this class); */
    protected int horizontalAlignment;

    /** The vertical alignment of the title (use the constants TOP, MIDDLE and BOTTOM, defined in
        this class); */
    protected int verticalAlignment;

    /** The amount of blank space to leave around the title; */
    protected Insets insets;

    /** Storage for registered change listeners; */
    protected List listeners;

    /**
     * Full constructor - builds an abstract title with the specified position and alignment. This
     * class defines constants for the valid position and alignment values---an
     * IllegalArgumentException will be thrown if invalid values are passed to this constructor.
     * @param position The relative position of the title (TOP, BOTTOM, RIGHT and LEFT---or NORTH,
     *                 SOUTH, EAST and WEST if you prefer);
     * @param horizontalAlignment The horizontal alignment of the title (LEFT, CENTER or RIGHT);
     * @param verticalAlignment The vertical alignment of the title (TOP, MIDDLE or BOTTOM);
     * @exception IllegalArgumentException If an invalid location or alignment value is passed;
     */
    protected AbstractTitle(int position, int horizontalAlignment, int verticalAlignment,
                            Insets insets) {

        // check position
        if (!this.isValidPosition(position)) {
            throw new IllegalArgumentException("AbstractTitle: Invalid position.");
        }

        // check the horizontal and vertical alignment
        if ((horizontalAlignment!=LEFT) &&
            (horizontalAlignment!=CENTER) &&
            (horizontalAlignment!=RIGHT)) {
            throw new IllegalArgumentException("AbstractTitle: Invalid horizontal alignment.");
        }

        if ((verticalAlignment!=TOP) &&
            (verticalAlignment!=BOTTOM) &&
            (verticalAlignment!=MIDDLE)) {
            throw new IllegalArgumentException("AbstractTitle: Invalid vertical alignment.");
        }

        this.position = position;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.insets = insets;
        this.listeners = new java.util.ArrayList();
        this.notify = true;
    }

    /**
     * Standard constrcutor - builds an abstract title with the specified position and alignment,
     * with a default inset of 2 pixels around the title.  This class defines constants for the valid
     * position and alignment values---an IllegalArgumentException will be thrown if invalid values
     * are passed to this constructor.
     * @param position The relative position of the title (TOP, BOTTOM, RIGHT and LEFT---or NORTH,
     *                 SOUTH, EAST and WEST if you prefer);
     * @param horizontalAlignment The horizontal alignment of the title (LEFT, CENTER or RIGHT);
     * @param verticalAlignment The vertical alignment of the title (TOP, MIDDLE or BOTTOM);
     * @exception IllegalArgumentException If an invalid location or alignment value is passed;
     */
    protected AbstractTitle(int position, int horizontalAlignment, int verticalAlignment) {
        this(position, horizontalAlignment, verticalAlignment, new Insets(2, 2, 2, 2));
    }

    /**
     * Default constructor - builds an AbstractTitle positioned at the top of the page, centered
     * horizontally and vertically within its space.
     */
    protected AbstractTitle() {
        this(TOP, CENTER, MIDDLE);
    }

    /**
     * Returns a clone of the title. One situation when this is useful is when editing the title
     * properties - you can edit a clone, and then it is easier to cancel the changes if necessary.
     * @return A clone of the title;
     */
    public Object clone() {
        AbstractTitle duplicate = null;
        try {
            duplicate = (AbstractTitle)(super.clone());
        }
        catch (CloneNotSupportedException e) {
            // this should never happen because Cloneable is implemented
            throw new RuntimeException("AbstractTitle.clone()");
        }

        duplicate.setNotify(false);
        duplicate.setInsets((Insets)this.getInsets().clone());
        duplicate.setNotify(true);
        return duplicate;
    }

    /**
     * Returns the flag that indicates whether or not the notification mechanism is enabled.
     * @return A boolean that indicates whether or not the notification mechanism is enabled;
     */
    public boolean getNotify() {
        return this.notify;
    }

    /**
     * Sets the flag that indicates whether or not the notification mechanism is enabled.  There are
     * certain situations (such as cloning) where you want to turn notification off temporarily.
     * @param flag A boolean that indicates whether or not the notification mechanism is enabled;
     */
    public void setNotify(boolean flag) {
        this.notify = flag;
    }

    /**
     * Returns the relative position of the title---represented by one of four integer constants
     * defined in this class: TOP, BOTTOM, RIGHT or LEFT (or the equivalent NORTH, SOUTH, EAST and
     * WEST).
     * @return The title position;
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Sets the position for the title.
     * @param position The relative position of the title (use one of the constants TOP, BOTTOM,
     *                 RIGHT and LEFT, or the equivalent NORTH, SOUTH, EAST and WEST);
     */
    public void setPosition(int position) {
        if (this.position!=position) {
            // check that the position is valid
            this.position = position;
            notifyListeners(new TitleChangeEvent(this));
        }
    }

    /**
     * Returns the horizontal alignment of the title.  The constants LEFT, CENTER and RIGHT (defined
     * in this class) are used.
     * @return The horizontal alignment of the title (LEFT, CENTER or RIGHT);
     */
    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /**
     * Sets the horizontal alignment for the title, and notifies any registered listeners of the
     * change.  The constants LEFT, CENTER and RIGHT (defined in this class) can be used to specify
     * the alignment.
     * @param alignment The new horizontal alignment (LEFT, CENTER or RIGHT).
     */
    public void setHorizontalAlignment(int alignment) {
        if (this.horizontalAlignment!=alignment) {
            this.horizontalAlignment = alignment;
            notifyListeners(new TitleChangeEvent(this));
        }
    }

    /**
     * Returns the vertical alignment of the title.  The constants TOP, MIDDLE and BOTTOM (defined
     * in this class) are used.
     * @return The vertical alignment of the title (TOP, MIDDLE or BOTTOM);
     */
    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /**
     * Sets the vertical alignment for the title, and notifies any registered listeners of the change.
     * The constants TOP, MIDDLE and BOTTOM (defined in this class) can be used to specify the
     * alignment.
     * @param alignment The new vertical alignment (TOP, MIDDLE or BOTTOM);
     */
    public void setVerticalAlignment(int alignment) {
        if (this.verticalAlignment!=alignment) {
            this.verticalAlignment = alignment;
            notifyListeners(new TitleChangeEvent(this));
        }
    }

    /**
     * Returns the insets (the blank space around the edges) for this title.
     */
    public Insets getInsets() {
        return this.insets;
    }

    /**
     * Sets the insets for the title, and notifies registered listeners of the change.
     * @param insets The new insets value;
     */
    public void setInsets(Insets insets) {
        if (!this.insets.equals(insets)) {
            this.insets = insets;
            notifyListeners(new TitleChangeEvent(this));
        }
    }

    /**
     * Returns true if the title can assume the specified location, and false otherwise.
     */
    public abstract boolean isValidPosition(int position);

    /**
     * Returns the preferred width of the title.
     */
    public abstract double getPreferredWidth(Graphics2D g2);

    /**
     * Returns the preferred height of the title.
     */
    public abstract double getPreferredHeight(Graphics2D g2);

    /**
     * Draws the title on a Java 2D graphics device (such as the screen or a printer).
     * @param g2 The graphics device;
     * @param chartArea The area within which the chart will be drawn (the title chooses a
     *                  subset of this area in which to draw itself, based on its position);
     */
    public abstract void draw(Graphics2D g2, Rectangle2D titleArea);

    /**
     * Registers an object for notification of changes to the title.
     * @param listener The object that is being registered;
     */
    public void addChangeListener(TitleChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters an object for notification of changes to the chart title.
     * @param listener The object that is being unregistered;
     */
    public void removeChangeListener(TitleChangeListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all registered listeners that the chart title has changed in some way.
     * @param event An object that contains information about the change to the title;
     */
    protected void notifyListeners(TitleChangeEvent event) {
        if (this.notify) {
            java.util.Iterator iterator = listeners.iterator();
            while (iterator.hasNext()) {
                TitleChangeListener listener = (TitleChangeListener)iterator.next();
                listener.titleChanged(event);
            }
        }
    }

}
