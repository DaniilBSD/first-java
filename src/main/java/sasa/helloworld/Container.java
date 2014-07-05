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
 *
 * @author sasa
 */
public class Container {

    private List<Shape> shapes = new LinkedList<>();
    private Shape movingShape = null;
    
    public void releaseShape(){
        movingShape = null;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
    public void draw(Graphics g){
        for(Shape s : shapes){
            s.draw(g);
        }
    }
    public void readFromFile() {
        File file = new File("shapes.txt");
        List<String> strings = Collections.EMPTY_LIST;
        try {
            strings = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        }
        catch (IOException ex) {
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
        }
    }
    public void pickShape(int xs ,int ys){
        for(Shape s : shapes){
            if(s.isThere(xs, ys)){
                movingShape = s;
            }
        }
        shapes.remove(movingShape);
        shapes.add(movingShape);
    }
    public void move(int xs ,int ys, int xf , int yf){
        if( movingShape != null){
            movingShape.move(xf - xs, yf- ys);
        }
    }
    

}
