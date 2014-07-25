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

    public void move(int xs, int ys, int xf, int yf) {
        if (movingShape != null) {
            movingShape.move(xf - xs, yf - ys);
            for(Shape s1 : shapes){
                if( movingShape != s1 && movingShape.intersects(s1)){
                    s1.move(xf - xs, yf - ys);
                    for(Shape s2 : shapes){
                        if( movingShape != s2 && s1 != s2 && s1.intersects(s2)){
                            s2.move(xf - xs, yf - ys);
                            for(Shape s3 : shapes){
                                if( movingShape != s3 && s1 != s3 && s2 != s3 && s2.intersects(s3)){
                                    s3.move(xf - xs, yf - ys);
                                    for(Shape s4 : shapes){
                                        if( movingShape != s4 && s1 != s4 && s2 != s4 && s3 != s4 && s3.intersects(s4)){
                                            s4.move(xf - xs, yf - ys);
                                            for(Shape s5 : shapes){
                                                if( movingShape != s5 && s1 != s5 && s4 != s5 && s2 != s5 && s3 != s5 && s4.intersects(s5)){
                                                    s5.move(xf - xs, yf - ys);
                                                    for(Shape s6 : shapes){
                                                        if( movingShape != s6 && s1 != s6 && s4 != s6 && s2 != s6 && s5 != s6 && s3 != s6 && s5.intersects(s6)){
                                                            s6.move(xf - xs, yf - ys);
                                                            for(Shape s7 : shapes){
                                                                if( movingShape != s7 && s1 != s7 && s4 != s7 && s2 != s7 && s5 != s7 && s3 != s7  && s6 != s7 && s6.intersects(s7)){
                                                                    s7.move(xf - xs, yf - ys);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
