/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sasa.helloworld;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author elenabesedina
 */
public class MouseEventListener implements MouseListener {

    private Container container;
    private int x;
    private int y;
    
    public MouseEventListener(Container c){
        container = c;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        System.err.println(" -- pressed " + x + " == " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        container.move(x, y, e.getX(), e.getY());
        ((MyPanel)e.getComponent()).repaint();
        System.err.println(" -- released ");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
