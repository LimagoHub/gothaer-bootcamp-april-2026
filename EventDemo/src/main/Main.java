package main;

import tiere.PigTooFatListener;
import tiere.Schwein;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main implements PropertyChangeListener {
    private Metzger metzger = new Metzger();
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Schwein schwein = new Schwein("Miss Piggy");
        schwein.addPigTooFatListener(s->metzger.schlachten(s));
        schwein.addPropertyChangeListener(this);
        for (int i = 0; i < 11; i++) {
            schwein.fuettern();
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        System.out.println(evt);
    }
}

class Metzger  {


    public void schlachten(final Schwein dickeSchwein) {
        System.out.println("Messer wetz!");
    }
}
