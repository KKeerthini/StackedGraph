package com.graphlayout.stackedgraph.model;

import android.graphics.Color;

/**
 * Created by KEERTHINI on 6/27/2016.
 */

public class StackGraphModel {
    private int xUpBackgrdColor = Color.WHITE;
    private int xDownBackgrdColor = Color.WHITE;
    private int xUpBarcolor = Color.RED;
    private int xDownBarColor = Color.DKGRAY;
    private int barWidth = 30;

    public int getxUpBackgrdColor() {
        return xUpBackgrdColor;
    }

    public void setxUpBackgrdColor(int xUpBackgrdColor) {
        this.xUpBackgrdColor = xUpBackgrdColor;
    }

    public int getxDownBackgrdColor() {
        return xDownBackgrdColor;
    }

    public void setxDownBackgrdColor(int xDownBackgrdColor) {
        this.xDownBackgrdColor = xDownBackgrdColor;
    }

    public int getxUpBarcolor() {
        return xUpBarcolor;
    }

    public void setxUpBarcolor(int xUpBarcolor) {
        this.xUpBarcolor = xUpBarcolor;
    }

    public int getxDownBarColor() {
        return xDownBarColor;
    }

    public void setxDownBarColor(int xDownBarColor) {
        this.xDownBarColor = xDownBarColor;
    }

    public int getBarWidth() {
        return barWidth;
    }

    public void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
    }
}
