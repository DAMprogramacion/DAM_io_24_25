package org.example.ejercicios.ejercicio1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Helper {
    public static Set<String> getSetNames(String sPath) {
        Path path = Path.of(sPath);
        Set<String> nombres = new TreeSet<>();
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine())
                nombres.add(scanner.nextLine().toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nombres;
    }

    public static void main(String[] args) {
        Set<String> hombres = getSetNames(
                "files/ejercicios/nombres_hombre.txt");
        hombres.forEach(System.out::println);
    }

}
