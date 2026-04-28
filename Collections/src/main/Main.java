package main;

import tiere.Schwein;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Schwein> items = new TreeSet<>();
        items.add(new Schwein("Piggy"));
        items.add(new Schwein("Piggy"));
        items.add(new Schwein("Babe"));
        items.add(new Schwein("Rudi"));




        for(var item : items) {
            System.out.println(item.toString());
        }


    }
}
