package de.gothaer.app;
import de.gothaer.tiere.Schwein;



public class Main {
    public static void main(String[] args) {

        new Main().run();
    }

    private void run() {

        System.out.println(Schwein.getCounter());

        Schwein piggy;
        piggy = new Schwein();

        System.out.println(Schwein.getCounter());
        piggy.setName("Miss Piggy");


        System.out.println(piggy.toString());

        piggy.fuettern();
        System.out.println(piggy.toString());
    }
}
