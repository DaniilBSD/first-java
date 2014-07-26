/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasa.helloworld;

import javax.swing.*;

/**
 *
 * @author sasa
 */
public class Main {

    public static void printColor(Shape s) {
        System.err.println("Color: " + s.getColor());
    }

    public static void openWindow() {
        JFrame jf = new JFrame("Main");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1000, 500);


        Container container = new Container(1000,500);
        container.readFromFile();
        MyPanel jp = new MyPanel();
        MouseEventListener listener = new MouseEventListener(container);
        jp.addMouseListener(listener);
        jp.addMouseMotionListener(listener);
        jp.setSize(1000, 500);
        jp.setCont(container);
        jf.add(jp);
         
    
        
        jf.setVisible(true);
        
        //jp.getGraphics().setColor(Color.red);
        //jp.getGraphics().drawLine(1, 1, 100, 100);
        jp.repaint();
        
    }
    public static void main(String[] a) {

        System.err.println("Hello!");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

          @Override
        public void run() {
           openWindow();
           }
        });
        
    }
}
