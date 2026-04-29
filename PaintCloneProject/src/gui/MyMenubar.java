package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import static gui.DrawingTool.*;

public class MyMenubar extends MenuBar {

    public MyMenubar(PaintClone paintClone) {
        Menu menu;

        menu = new Menu("Datei");
        addItem(menu, "Beenden", e -> paintClone.dispose());
        add(menu);

        menu = new Menu("Formen");
        addItem(menu, "Linie",     e -> paintClone.setDrawingTool(LINE));
        addItem(menu, "Oval",      e -> paintClone.setDrawingTool(OVAL));
        addItem(menu, "Rechteck",  e -> paintClone.setDrawingTool(RECTANGLE));
        menu.addSeparator();
        addItem(menu, "Loeschen",  e -> paintClone.setDrawingTool(ERASE));
        add(menu);

        menu = new Menu("Farben");
        addItem(menu, "Weiss", e -> paintClone.setColor(Color.WHITE));
        addItem(menu, "Rot",   e -> paintClone.setColor(Color.RED));
        addItem(menu, "Blau",  e -> paintClone.setColor(Color.BLUE));
        addItem(menu, "Gruen", e -> paintClone.setColor(Color.GREEN));
        addItem(menu, "Gelb",  e -> paintClone.setColor(Color.YELLOW));
        addItem(menu, "Pink",  e -> paintClone.setColor(Color.PINK));
        add(menu);
    }

    private void addItem(Menu menu, String label, ActionListener listener) {
        MenuItem item = new MenuItem(label);
        item.addActionListener(listener);
        menu.add(item);
    }
}
