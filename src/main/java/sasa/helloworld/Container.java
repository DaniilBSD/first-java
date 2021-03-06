/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasa.helloworld;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sasa
 */
public class Container {

    private List<Shape> shapes = new LinkedList<>();
    private Shape movingShape = null;
    private int frameWidth;
    private int frameHaight;

    public Container(int x, int y){
        frameWidth = x;
        frameHaight = y;
    }
    
    public void releaseShape() {
        movingShape = null;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void draw(Graphics g) {
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public void readFromFile() {
        File file = new File("shapes.txt");
        List<String> strings = Collections.EMPTY_LIST;
        try {
            strings = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(Container.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String s : strings) {
            System.err.println("String : " + s);
            if (s.indexOf("Circle") == 0) {
                Circle c = new Circle();
                c.readFromString(s);
                shapes.add(c);
            }
            if (s.indexOf("Rectangle") == 0) {
                Rectangle r = new Rectangle();
                r.readFromString(s);
                shapes.add(r);
            }
            if (s.indexOf("Triangle") == 0) {
                Triangle t = new Triangle();
                t.readFromString(s);
                shapes.add(t);
            }
            if (s.indexOf("Hexagon") == 0) {
                Hexagon h = new Hexagon();
                h.readFromString(s);
                shapes.add(h);
            }
        }
    }

    public void pickShape(int xs, int ys) {
        Shape sh = null;
        for (Shape s : shapes) {
            if (s.isThere(xs, ys)) {
                sh = s;
            }
        }
        if (sh != null) {
            shapes.remove(sh);
            shapes.add(sh);
        }
        movingShape = sh;
    }
    public void moveFromBorder(int xs, int ys, int xf, int yf){
        for(Shape s1 : shapes){
            if( s1.notInsideTheArea(frameWidth , frameHeight) ){
                List<Shape> shapesCopy = new ArrayList<>(this.shapes);
                move( s1 , shapesCopy , xs - xf , ys - yf );
            }
        }
    }
    
    private void move( Shape shape , List<Shape> shapes,int deltaX ,int deltaY){
        shape.move(deltaX, deltaY);
        for(Shape s1 : shapes){
             if( shape != s1 && shape.intersects(s1)){
                 List<Shape> shapesCopy = new ArrayList<>(shapes);
                 shapesCopy.remove(s1);
                 move(s1, shapesCopy, deltaX, deltaY);
             }
         }
    }
            
    public void move(int xs, int ys, int xf, int yf) {
        List<Shape> shapesCopy = new ArrayList<>(this.shapes);
        if (movingShape != null) {
            move(movingShape , shapesCopy , xf - xs , yf - ys);
        }
        
    }
}
