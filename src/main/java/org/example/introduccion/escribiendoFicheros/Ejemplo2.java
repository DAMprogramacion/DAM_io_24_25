package org.example.introduccion.escribiendoFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejemplo2 {
    public static void main(String[] args) {
        File outFile = new File("files/outFiles/dos");
        try (FileOutputStream out = new FileOutputStream(outFile)) {
            for (int i = 0; i < 40; i++) {
                out.write(getRandomBytes());
            }
            out.flush();
            System.out.printf("Escritos %d bytes en el fichero %s%n", outFile.length(), outFile);
       /* } catch (FileNotFoundException e) {
            throw new RuntimeException(e);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int getRandomBytes() {
        int valor = new Random().nextInt(256);
        if (valor < 32 || valor > 136)
            System.out.printf("No imprimible: %d%n", valor);
        return valor;
    }
}
