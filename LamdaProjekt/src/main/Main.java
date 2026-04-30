package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Consumer<String> print = v-> System.out.println(v);

        print.accept("Hello World");

        Consumer<String> p2 = new Consumer<String>() {
            List<String> list = new ArrayList<>();
            @Override
            public void accept(String s) {
                list.add(s);
                System.out.println(s);
            }
        };

        p2.accept("Hello World");
    }

}



