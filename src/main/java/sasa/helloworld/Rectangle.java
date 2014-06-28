/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasa.helloworld;

import java.awt.*;

/**
 *
 * @author sasa
 */
public class Rectangle extends Shape {

    private int x;

    private int y;

    private int width;

    private int height;

    @Override
    public String getShape() {
        return "Rectangle";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void readFromString(String shape) {
        this.setX(Integer.valueOf(getParam(shape, "x:")));
        this.setY(Integer.valueOf(getParam(shape, "y:")));
        this.setHeight(Integer.valueOf(getParam(shape, "height:")));
        this.setWidth(Integer.valueOf(getParam(shape, "width:")));
        readColor(shape);
    }

    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(x, y, width, height);
    }
    
    public void move(int dX, int dY) {
        setX(getX() + dX);
        setY(getY() + dY);
    }
    
    @Override
    public boolean isThere(int x, int y) {
        return x >= getX() && x <= (getX() + getWidth()) && y >= getY() && y <= (getY() + getHeight());
        
    }
}
