package org.example.introduccion.leyendoFicheros.bytes;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        File inFile = new File("files/outFiles/cinco.txt");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile))) {
            int bytes = in.read();
            while (bytes != -1) {
                System.out.println("bytes leído: " + (char) bytes);
                bytes = in.read();

            }
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
    }
}
