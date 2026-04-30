package tiere;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Schwein {

    private static final int MAX_WEIGHT = 20;
    private String name;
    private int gewicht;
    private static int counter;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private List<PigTooFatListener> listeners = new ArrayList<>();


    public boolean addPigTooFatListener(final PigTooFatListener pigTooFatListener) {
        return listeners.add(pigTooFatListener);
    }

    public boolean removePigTooFatListener(final PigTooFatListener o) {
        return listeners.remove(o);
    }

    private void firePigTooFatEvent() {
        listeners.forEach(listener -> listener.pigTooFat(this));
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    static {
        counter = 0;
    }

    {
        System.out.println("Häh?");
    }

    public Schwein() {
        this("nobody");
    }

    public Schwein(String name) {
        setName(name);
        gewicht = 10;
        counter ++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public final void setName(final String name) {
        if(name.equals(this.name)) return ;

        support.firePropertyChange("name", this.name, this.name=name);
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(final int gewicht) {

        support.firePropertyChange("gewicht", this.gewicht, this.gewicht=gewicht);
        if(this.gewicht > MAX_WEIGHT) {
            firePigTooFatEvent();
        }
    }

    public void fuettern(){
        setGewicht(getGewicht()+1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Main von Schwein");
    }
}
