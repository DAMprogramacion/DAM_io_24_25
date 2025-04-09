package org.example.introduccion.escribiendoFicheros.caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Ejemplo2 {
    public static void main(String[] args) {
        int entero = 26;
        double decimal = Math.PI;
        boolean booleano = true;
        char caracter = 'ü';
        String cadena = "Esto es una cadena";
        System.out.printf("entero: %d; decimal: %.2f, boolean: %B%n", entero, decimal, booleano);
        System.out.printf("caracter: %c, cadena: %s%n",caracter, cadena);
        /// ////////ESCRIBIENDO EN FICHERO:
        File outFile = new File("files/outFiles/cinco.txt");
        try (PrintWriter out = new PrintWriter(outFile)) {
            out.printf("entero: %d; decimal: %.2f, boolean: %B%n", entero, decimal, booleano);
            out.printf("caracter: %c, cadena: %s%n",caracter, cadena);
            out.flush();
            System.out.printf("Escritos %d bytes en fichero %s%n", outFile.length(), outFile);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
    }
}
