package gui;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame {


    public Fenster()  {
        setSize(500,500);
        addWindowListener(new MyWindowListener());
    }

    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }

    class MyWindowListener extends WindowAdapter {

        @Override
        public void windowClosing(final WindowEvent e) {
            dispose();
        }
    }

}
