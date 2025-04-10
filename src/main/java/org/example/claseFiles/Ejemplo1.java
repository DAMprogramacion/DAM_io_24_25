package org.example.claseFiles;

import java.io.File;

public class Ejemplo1 {
    public static void main(String[] args) {
        //usando File, un fichero de entrada y uno de salida (nuevo)
        File outFile  = new File("files/outFiles/nuevo.txt");
        File inFile = new File(  "files/inFiles/prueba.txt");

        //leemos el fichero con Scanner y escribimos fichero con PrintWriter
        //el fichero de salida es igual al original
        //un report en consola: nº de líneas procesadas (leidas o escritas) y nº de bytes.
    }
}
