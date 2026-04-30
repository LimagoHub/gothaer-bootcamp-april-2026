package gui;

import java.awt.*;

public class Paddle implements MoveableItem{

    private Point position = new Point(100, 700);
    @Override
    public void setPosition(final Point p) {
        position = p;
    }

    @Override
    public Point getPosition() {
        return getPosition();
    }

    @Override
    public boolean checkCollision(final Item otherItem) {
        return getBounds().intersects(otherItem.getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, 200, 20);
    }

    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(position.x, position.y, getBounds().width, getBounds().height);
    }

    public void moveRight() {
        position.x += 10;
    }
    public void moveLeft() {
        position.x -= 10;
    }
}
