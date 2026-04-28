package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            int [] feld = new int[2];
            int a, b, c;
            a = b =  0;
            feld[1000] = 17;
            c = a / b;

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vielen Dank, Sie haben ein kleines Programm echt gluecklich gemacht");
    }


}
