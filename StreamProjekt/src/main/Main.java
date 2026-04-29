package main;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

       var main =new Main();
       main.run();

    }

    public void run() {
        IntStream.rangeClosed(1, 1000_000)
                .parallel()
                .filter(this::isPrime)
                .forEach(System.out::println);
    }

    public boolean isPrime(int possiblePrime) {
        for (int i = 2; i <= possiblePrime/2; i++) {
            if (possiblePrime % i == 0) {
                return false;
            }
        }
        return true;
    }

}
