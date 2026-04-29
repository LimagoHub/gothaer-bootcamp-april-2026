package gui;

import java.awt.*;

public class BouncingBall extends Frame {
    private static final int SIZE = 800;
    private boolean gameover = false;
    private Ball ball = new Ball();

    private int x,  y;
    private int xRichtung = -2;
    private int yRichtung = -1;

    public BouncingBall() {
        super("Bouncing Ball");
        setResizable(false);
        setSize(SIZE, SIZE);
        ball.setPosition(new Point(SIZE/2, SIZE/2));
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
        Point p = ball.getPosition();
        p.x += xRichtung;
        p.y += yRichtung;
        ball.setPosition(p);

        if(p.x <  0 || p.x > SIZE) {
            xRichtung *= -1;
        }
        if(p.y <  0 || p.y > SIZE) {
            yRichtung *= -1;
        }
    }

    private void renderScence() {
        Graphics g = null;
        try {
            g = getBufferStrategy().getDrawGraphics();
            g.clearRect(0,0,getWidth(),getHeight());
            ball.paint(g);
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
