package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class PaintClone extends Frame {

    private static final int SIZE = 500;

    private final BufferedImage image =  new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

    private DrawingTool drawingTool = DrawingTool.LINE;
    private Color color = Color.WHITE;
    private boolean drawing = false;


    public PaintClone() {
        setSize(SIZE,SIZE);
        setResizable(false);
        setMenuBar(new MyMenubar(this));
        addMouseListener(new MyMouseListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                dispose();
            }
        });
    }


    public DrawingTool getDrawingTool() {
        return drawingTool;
    }

    public void setDrawingTool(final DrawingTool drawingTool) {
        this.drawingTool = drawingTool;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(image, 0, 0, this);

    }

    private void applyStroke(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(getColor());
        switch (getDrawingTool()) {
            case LINE      -> {  g.drawLine(x1, y1, x2, y2); }
            case RECTANGLE -> {  Rectangle r = normalize(x1, y1, x2, y2); g.drawRect(r.x, r.y, r.width, r.height); }
            case OVAL      -> {  Rectangle r = normalize(x1, y1, x2, y2); g.drawOval(r.x, r.y, r.width, r.height); }
            case ERASE     -> {  Rectangle r = normalize(x1, y1, x2, y2); g.clearRect(r.x, r.y, r.width, r.height); }
        }
    }

    // Ensures x/y are always top-left regardless of drag direction.
    private Rectangle normalize(int x1, int y1, int x2, int y2) {
        return new Rectangle(
                Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x2 - x1), Math.abs(y2 - y1)
        );
    }


    public static void main(String[] args) {
        new PaintClone().setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        private int x, y;

        @Override
        public void mousePressed(final MouseEvent e) {
            x =e.getX();
            y =e.getY();
            drawing = true;
        }


        @Override
        public void mouseReleased(final MouseEvent e) {
            Graphics g = image.getGraphics();
            applyStroke(g, x, y, e.getX(), e.getY());
            g.dispose();
            drawing = false;
            repaint();
        }
    }
}
