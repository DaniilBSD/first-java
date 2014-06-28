/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sasa.helloworld;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author elenabesedina
 */
public class MyPanel extends JPanel{
    private Container container;
    @Override
    public void paint(Graphics g) {

        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Color c = Color.getColor("", 0xff);
        g.setColor(c);
        container.draw(g);
    }
    
    public void setCont(Container cont){
        this.container = cont;
        
    }
   
}
