package org.example.introduccion.escribiendoFicheros.bytes;

import java.io.*;
import java.util.Random;

public class Ejemplo3 {
    public static void main(String[] args) {
        //definir el objeto files
        File outFile = new File("files/outFiles/tres");
        //abrir buffered y meter dentro el fileoutputstream
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
            for (int i = 0; i < 1_024; i++) {
                out.write(getRandomByteImprimible());
            }
            out.flush();
            System.out.printf("Escritos %d bytes en el fichero %s%n", outFile.length(), outFile);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //escribimos 1024 bytes de bytes imprimibles

    }
    //creamos un metodo devuelva solo bytes imprimibles
    public static int getRandomByteImprimible() {
        int valor = -1;
        while (valor < 32 || valor > 126)
            valor = new Random().nextInt(256);
        return valor;
    }
}
