package gui;

import java.awt.*;

public interface Item {

    public boolean checkCollision(Item otherItem) ;
    public Rectangle getBounds();
    public void paint(Graphics g);


}
