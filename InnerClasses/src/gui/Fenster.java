package gui;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame {


    public Fenster()  {
        setSize(500,500);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {beenden();}
        });
    
        addKeyListener(new MyKeyListener());
    }

    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }

    private void beenden() {
        dispose();
    }


    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                beenden();
            }
        }
    }

}
