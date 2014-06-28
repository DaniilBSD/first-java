/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sasa.helloworld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author sasa
 */
public class Triangle extends Shape {

    private int x1;

    private int y1;

    private int x2;

    private int y2;

    private int x3;

    private int y3;

    @Override
    public String getShape() {
        return "Triangle";
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    
    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public void readFromString(String shape) {
        this.setX1(Integer.valueOf(getParam(shape, "x1:")));
        this.setX2(Integer.valueOf(getParam(shape, "x2:")));
        this.setX3(Integer.valueOf(getParam(shape, "x3:")));
        this.setY1(Integer.valueOf(getParam(shape, "y1:")));
        this.setY2(Integer.valueOf(getParam(shape, "y2:")));
        this.setY3(Integer.valueOf(getParam(shape, "y3:")));
        readColor(shape);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int[] x = {this.getX1(),this.getX2(),this.getX3()};
        int[] y = {this.getY1(),this.getY2(),this.getY3()};
        Polygon t = new Polygon(x, y, 3);
        g.fillPolygon(t);
    }
    
    public void move(int dX, int dY) {
        setX1(getX1() + dX);
        setY1(getY1() + dY);
        setX2(getX2() + dX);
        setY2(getY2() + dY);
        setX3(getX3() + dX);
        setY3(getY3() + dY);
    }
    public boolean rightSide(int x1 , int y1 , int x2 , int y2 , int x3 ,int y3 , int x4 , int y4){
        boolean ret = false;
        int ydif = y2 - y1;
        int xdif = x2 - x1;
        int gradient;
        
        return ret;
    }
    @Override
    public boolean isThere(int x, int y) {
        boolean ret = false;
        if(rightSide(x1, y1, x2, y2, x3, y3, x, y) && rightSide(x3, y3, x1, y1, x2, y2, x, y) && rightSide(x2, y2, x3, y3, x1, y1, x, y)){
            ret = true;
        }
        return ret;
        
    }
    
}