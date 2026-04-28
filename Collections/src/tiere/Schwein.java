package tiere;

import java.util.Objects;

public class Schwein implements Comparable<Schwein>{
    @Override
    public int compareTo(final Schwein o) {
        return this.name.compareTo(o.name);
    }

    private String name;
    private int gewicht;
    private static int counter;

    static {
        counter = 0;
    }


    public Schwein() {
        this("nobody");
    }

    public Schwein(String name) {
        setName(name);
        gewicht = 10;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(final int gewicht) {
        this.gewicht = gewicht;
    }

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Schwein schwein = (Schwein) o;
        return gewicht == schwein.gewicht && Objects.equals(name, schwein.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gewicht);
    }
}

