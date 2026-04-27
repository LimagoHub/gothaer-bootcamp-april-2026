package de.gothaer.tiere;
public class Schwein {

    private String name;
    private int gewicht;
    private static int counter;

    static {
        counter = 0;
    }

    {
        System.out.println("Häh?");
    }
    public Schwein() {
        name = "Nobody";
        gewicht = 10;
        counter ++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(final int gewicht) {
        this.gewicht = gewicht;
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
