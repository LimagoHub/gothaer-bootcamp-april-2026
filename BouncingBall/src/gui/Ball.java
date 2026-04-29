package gui;

import java.awt.*;

public class Ball implements MoveableItem {

    private Point position = new Point(0, 0);

    @Override
    public void setPosition(final Point p) {
        position = p;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public boolean checkCollision(final Item otherItem) {
        return getBounds().intersects(otherItem.getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, 30, 30);
    }

    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getPosition().x, getPosition().y, 30, 30);
    }
}
