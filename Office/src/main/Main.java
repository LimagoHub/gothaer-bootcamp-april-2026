package main;

import office.Dokument;
import office.Excel;
import office.Word;

import java.util.logging.Logger;

public class Main {

  
    public static void main(String[] args) {
        Dokument d = new Excel();
        d.drucken();
    }
}
