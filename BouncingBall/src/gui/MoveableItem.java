package gui;

import java.awt.*;

public interface MoveableItem extends Item {

    void setPosition(Point  p );
    Point getPosition();
}