package main;

import de.gothaer.collections.Stapel;
import de.gothaer.collections.StapelException;
import geometrie.Kreis;
import geometrie.Punkt;
import tiere.Schwein;

public class Main {

    public static void main(String[] args) {
        try {
            Stapel<Punkt> stapel = new Stapel<>(40);

            for(int i = 0; i < 10; i++){
                if(! stapel.isFull()) {
                    //stapel.push(new Schwein("Schwein Nr." + i));
                    stapel.push(new Punkt(i,i));
                    stapel.push(new Kreis(i));
                    //stapel.push(i);
                }
            }

            while( ! stapel.isEmpty()){

                System.out.println(stapel.pop());
            }
           
        } catch (StapelException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }
    }
}
