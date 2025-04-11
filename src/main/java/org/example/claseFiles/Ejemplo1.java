package org.example.claseFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        //usando File, un fichero de entrada y uno de salida (nuevo)
        File outFile  = new File("files/outFiles/prueba_backup.txt");
        File inFile = new File(  "files/inFiles/prueba.txt");
        int contador = 0;
        try (
             Scanner scanner = new Scanner(inFile);
             PrintWriter out = new PrintWriter(outFile)
        ) {

            while (scanner.hasNextLine()) {
                contador++;
               // String linea = scanner.nextLine();
                out.println(scanner.nextLine());
            }
            out.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Nº líneas leídas: %d%n", contador);
        System.out.printf("Nº bytes escritos: %d%n", outFile.length());
        //leemos el fichero con Scanner y escribimos fichero con PrintWriter
        //el fichero de salida es igual al original
        //un report en consola: nº de líneas procesadas (leidas o escritas) y nº de bytes.
    }
}
