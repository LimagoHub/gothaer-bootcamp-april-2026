package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame implements  KeyListener, MouseMotionListener {

    private String message = "Hallo Fenster";

    private int x = 200;
    private int y = 200;

    public Fenster() {
        addKeyListener(this);
        addMouseMotionListener(this);
        setSize(400,400);
    }
    @Override
    public void paint(final Graphics g) {
        g.drawString(message , 50, 50);
        g.drawRect(x,y,50,50);

    }

    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
       switch (e.getKeyCode()) {
           case KeyEvent.VK_LEFT->x-=5;
           case KeyEvent.VK_RIGHT->x+=5;
           case KeyEvent.VK_UP->y-=5;
           case KeyEvent.VK_DOWN->y+=5;
           case KeyEvent.VK_ESCAPE ->dispose();
       }
        message = "Taste wurde gedrückt!";
        repaint();
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }

    @Override
    public void mouseDragged(final MouseEvent e) {

    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        x += (e.getX()-x) /20;
        y += (e.getY()-y)/20;
        repaint();
    }
}
