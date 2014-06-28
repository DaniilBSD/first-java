/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasa.helloworld;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sasa
 */
public class Circle extends Shape {

    private int radius;

    private int x;

    private int y;

    public Circle( ) {
        
    }
    public Circle( int radius , int x , int y){
        this.radius = radius;
        this.x = x ;
        this.y = y;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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

    @Override
    public String getShape() {
        return "Circle";
    }
    
    @Override
    public void readFromString(String shape) {
        this.setRadius(Integer.valueOf(getParam(shape, "radius:")));
        this.setX(Integer.valueOf(getParam(shape, "x:")));
        this.setY(Integer.valueOf(getParam(shape, "y:")));
        readColor(shape);
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle){
            Circle c = (Circle) obj;
            return c.getColor().equals(this.getColor()) && c.getRadius() == this.getRadius();
        }
        else{
            return false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(x - radius  , y - radius , radius*2, radius*2);
    }

    @Override
    public void move(int dX, int dY) {
        setX(getX() + dX);
        setY(getY() + dY);
    }

    @Override
    public boolean isThere(int x, int y) {
        return getRadius() >= Math.sqrt((getX() - x) * (getX() - x) + (getY() - y) * (getY() - y));
    }
    
    
    
    

}
