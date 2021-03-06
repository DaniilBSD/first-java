/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//first commit from mc mini!
package sasa.helloworld;

import java.awt.*;

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
    @Override
    public void move(int dX, int dY) {
        setX1(getX1() + dX);
        setY1(getY1() + dY);
        setX2(getX2() + dX);
        setY2(getY2() + dY);
        setX3(getX3() + dX);
        setY3(getY3() + dY);
    }
    @Override
    public boolean isThere(int x, int y) {
        boolean ret = false;
        int[] xa = {x1 , x2 , x3};
        int[] ya = {y1 , y2 , y3};
        Polygon t = new Polygon(xa, ya, 3);
        ret = t.contains(x, y);
        return ret;
        
    }
    
    @Override
    public int[][] getPoints() {
        int[][] arr = new int[3][2];
        arr[0][0] = x1;
        arr[0][1] = y1;
        
        arr[1][0] = x2;
        arr[1][1] = y2;
        
        arr[2][0] = x3;
        arr[2][1] = y3;
        
        return arr;
    }
    
}
