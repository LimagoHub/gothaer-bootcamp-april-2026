package gui;

import java.awt.*;

public class BouncingBall extends Frame {
    private static final int SIZE = 800;
    private boolean gameover = false;

    private int x,  y;
    private int xRichtung = -2;
    private int yRichtung = -1;

    public BouncingBall() {
        super("Bouncing Ball");
        setResizable(false);
        setSize(SIZE, SIZE);
        x = y = SIZE/2;
        setVisible(true);
        createBufferStrategy(2);
    }

    public void gameLoop() {
        while( ! gameover ) {
            calculateScene();
            renderScence();

        }
    }


    private void calculateScene() {
        x += xRichtung;
        y += yRichtung;
        if(x <  0 || x > SIZE) {
            xRichtung *= -1;
        }
        if(y <  0 || y > SIZE) {
            yRichtung *= -1;
        }
    }

    private void renderScence() {
        Graphics g = null;
        try {
            g = getBufferStrategy().getDrawGraphics();
            g.clearRect(0,0,getWidth(),getHeight());
            g.setColor(Color.RED);
            g.fillOval(x,y,50,50);
        } finally {
            if (g != null) {
                g.dispose();
            }
        }
        getBufferStrategy().show();
    }

    public static void main(String[] args) {
        new BouncingBall().gameLoop();
    }

}
