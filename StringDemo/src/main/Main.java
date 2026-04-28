package main;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {


        Instant start = Instant.now();
        StringBuilder buffer =new StringBuilder("gruss");

        for(int i = 0; i < 2_000_000; i++) {
            buffer.append( "A");
        }
        Instant end = Instant.now();
        String s = buffer.toString();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
        System.out.println("Fertig");
    }
}
