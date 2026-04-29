package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class Fenster extends Frame {

    private static final int SIZE = 400;

    private BufferedImage image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

    Fenster() {
        setSize(SIZE,SIZE);
        setResizable(false);
        setBackground(Color.BLACK);
        addMouseListener(new MyMouseListener());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {dispose();}
        });
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        new Fenster().setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        private int x, y;
        @Override
        public void mousePressed(final MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
        @Override
        public void mouseReleased(final MouseEvent e) {

            Graphics schattenfenster = image.createGraphics();
            schattenfenster.drawLine(x,y,e.getX(), e.getY());
            schattenfenster.dispose();
            repaint();
        }
    }
}
