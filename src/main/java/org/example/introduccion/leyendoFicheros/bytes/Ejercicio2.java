package org.example.introduccion.leyendoFicheros.bytes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        File inFile = new File("files/outFiles/cinco.txt");
        try (BufferedReader in = new BufferedReader(new FileReader(inFile))) {
            String linea = in.readLine();
            int contador = 0;
            while (linea != null) {
                System.out.printf("%d línea: %s%n", ++contador, linea);
                linea = in.readLine();
            }
        } catch (
        IOException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }

    }
}
