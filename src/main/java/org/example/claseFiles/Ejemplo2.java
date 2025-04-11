package org.example.claseFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ejemplo2 {
    public static void main(String[] args) {
        /*File outFile  = new File("files/outFiles/prueba_backup.txt");
        File inFile = new File(  "files/inFiles/prueba.txt");*/
        Path outPath = Path.of("files/outFiles/prueba_backup_files.txt");
        Path  inPath = Paths.get("files/inFiles/prueba.txt");
        try {
            Files.copy(inPath, outPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outPath = Path.of("files/outFiles/java_backup.webp");
        inPath = Paths.get("files/inFiles/java.webp");
        try {
            Files.copy(inPath, outPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
