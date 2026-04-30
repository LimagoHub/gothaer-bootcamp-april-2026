package gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;


public class BouncingBall extends Frame {
    private static final int SIZE = 800;
    private boolean gameover = false;
    private Ball ball = new Ball();
    private Paddle paddle = new Paddle();

    private int x,  y;
    private int xRichtung = -2;
    private int yRichtung = -1;

    public BouncingBall() {
        super("Bouncing Ball");
        setResizable(false);
        addKeyListener(new MyKeyListener());
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

        if(p.x < 0 || p.x > getWidth()) xRichtung *= -1;
        if(p.y < 0 ) yRichtung *= -1;

        if(ball.checkCollision(paddle)) {
            yRichtung *= -1;
        }

        if(p.y >= getHeight()) {
            gameover = true;
        }
    }

    private void renderScence() {
        Graphics g = null;
        try {
            g = getBufferStrategy().getDrawGraphics();
            g.clearRect(0,0,getWidth(),getHeight());
            if(gameover) {
                g.drawString("Game Over", getWidth()/2, getHeight()/2);
            }
            ball.paint(g);
            paddle.paint(g);
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

    private class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent e) {
            switch (e.getKeyCode()) {
                case VK_UP->yRichtung-=2;
                case VK_DOWN->yRichtung+=2;
                case VK_LEFT->paddle.moveLeft();
                case VK_RIGHT->paddle.moveRight();
                case VK_SPACE->xRichtung = yRichtung = 0;
            }
        }
    }

}
