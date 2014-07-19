/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sasa.helloworld;

import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author elenabesedina
 */
public class Hexagon extends Shape{

    private int x;

    private int y;
    
    private int radius;

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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void readFromString(String shape) {
        this.setX(Integer.valueOf(getParam(shape, "x:")));
        this.setY(Integer.valueOf(getParam(shape, "y:")));
        this.setRadius(Integer.valueOf(getParam(shape, "radius:")));
        readColor(shape);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        Polygon h = createAnygon(16);
        g.fillPolygon(h);
    }
    @Override
    public void move(int dX, int dY) {
        setX(getX() + dX);
        setY(getY() + dY);
    }
    
    public Polygon createHexagon(){
        int a = radius / 2;
        int b = (int) (Math.sin(1.04719755) * radius);
        int xm = x - b;
        int ym = y - radius;
        int[] xa = {(0), 0 , b , (b + b) , (b + b) , b};
        int[] ya = {(a * 3) , a , 0 , a , (a * 3) , (a * 4)};
        int ind = 0;
        for(int i : xa){
            xa[ind] += xm;
            ind++;
        }
        ind = 0;
        for(int i : ya){
            ya[ind] += ym;
            ind++;
        }
        Polygon h = new Polygon(xa, ya, 6);
        return h;
    }

    public Polygon createAnygon(int k){
        double  cir = 3.14159265 * 2;
        double angle = cir / k;
        int xa[] = new int[k];
        int ya[] = new int[k];

        for(int i = 0; i < k; i++){
            xa[i] = (int)(radius * Math.sin(angle * i)) + getX();
            ya[i] = (int)(radius * Math.cos(angle * i)) + getY();
        }

        Polygon h = new Polygon(xa, ya, k);
        return h;
    }


    @Override
    public boolean isThere(int x, int y) {
        boolean ret = false;
        Polygon h = createAnygon(16);
        ret = h.contains(x, y);
        return ret;
        
    }

    @Override
    public String getShape() {
        return "Hexagon";
    }

}
