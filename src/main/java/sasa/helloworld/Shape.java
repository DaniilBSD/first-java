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
    
    public abstract int[][] getPoints();

    protected String getParam(String shape, String param){
        int ind1 = shape.indexOf(param) + param.length();
        int ind2 = shape.indexOf(",", ind1);
        return shape.substring(ind1, ind2);
    }
    
    public Polygon getPolygon(){
        int[][] arr = getPoints();
        int angles_quantity = arr.length;
        int[] xa = new int[angles_quantity];
        int[] ya = new int[angles_quantity];
        
        for(int i = 0; i < angles_quantity; i++){
            xa[i] = arr[i][0];
            ya[i] = arr[i][1];
        }

        Polygon h = new Polygon(xa, ya, angles_quantity);
        return h;
    }

    public boolean intersects( Shape s ){
       int[][] sarr = s.getPoints();
       Polygon pol = getPolygon();
       int[][] arr = this.getPoints();
       Polygon spol = s.getPolygon();
       for(int[] a : sarr){
           if(pol.contains(new Point(a[0], a[1]))){
               return true;
           }
       }
       for(int[] a : arr){
           if(spol.contains(new Point(a[0], a[1]))){
               return true;
           }
       }
       return false;
    }

}
