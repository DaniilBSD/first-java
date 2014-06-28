/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasa.helloworld;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

        Container container = new Container();
        container.readFromFile();

        MyPanel jp = new MyPanel();
        jp.addMouseListener(new MouseEventListener(container));
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
