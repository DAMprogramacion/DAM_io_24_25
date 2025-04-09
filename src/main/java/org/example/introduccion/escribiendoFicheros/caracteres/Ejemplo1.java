package org.example.introduccion.escribiendoFicheros.caracteres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) {
        String mensaje = "Hola que tal, adios, vamos a usar una eñe y una acento, José";
        File outFile = new File("files/outFiles/cuatro.txt");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outFile, true))) {
            out.write(mensaje);
            out.newLine();
            out.flush();
            System.out.printf("Escritos %d bytes en fichero %s%n", outFile.length(), outFile);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
    }
}
