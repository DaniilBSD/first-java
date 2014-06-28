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
public abstract class Shape {
    
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getShape();

    public abstract void draw(Graphics g);
            
    public abstract void readFromString(String shape);
    
    public void readColor(String shape){
        int colorint = Integer.parseInt(getParam(shape, "color:") , 16);
        this.setColor( Color.getColor("", colorint));
    }
    
    public abstract void move( int dX , int dY );
    
    public abstract boolean isThere( int x, int y);
    
    

    protected String getParam(String shape, String param){
        int ind1 = shape.indexOf(param) + param.length();
        int ind2 = shape.indexOf(",", ind1);
        return shape.substring(ind1, ind2);
    }

}
