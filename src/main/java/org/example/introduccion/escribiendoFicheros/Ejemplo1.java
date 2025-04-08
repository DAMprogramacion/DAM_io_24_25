package org.example.introduccion.escribiendoFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Ejemplo1 {
    public static void main(String[] args) {
        File outFile = new File("files/outFiles/uno.txt");
        if (outFile.exists()) {
            System.out.printf("YA existe el fichero %s%n", outFile);
            return;
        }

        String mensaje = "Hola, que tal, amigo José";
        //trabajamos con try-catch-finally (clásico)
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(outFile);
            byte[] bytes = mensaje.getBytes();
            out.write(bytes);
            out.flush();
            System.out.printf("Escritos %d bytes en fichero %s%n", outFile.length(), outFile);
       /* } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());*/
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}




