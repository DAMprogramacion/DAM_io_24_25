package org.example.claseFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    static Path inPath  = Path.of("files/inFiles/passwords.txt");
    static Path outPath = Path.of("files/outFiles/passwords_backup.txt");
    public static void main(String[] args) {

        //leer el fichero password.txt
        List<String> passwords = null;
        try {
            passwords = Files.readAllLines(inPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Contraseña a buscar:");
        String password = scanner.nextLine();
        String mensaje = existePassword(passwords, password) ? "SI" : "NO";
        System.out.printf("La contraseña %s %s exite en fichero%n", password, mensaje);
        System.out.println("\n¿Quieres generar un fichero de contraseñas (SI/NO)");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("SI")) {
            String sOffset = "", sLength ="";
            do {
                System.out.println("Introduce offset y length");
                sOffset = scanner.nextLine();
                sLength = scanner.nextLine();
            } while (!(sOffset.matches("[0-9]+") && sLength.matches("[0-9]+")));
            int offset = Integer.parseInt(sOffset);
            int length = Integer.parseInt(sLength);
            escribirContraseñas(passwords, offset, length);
        }
        scanner.close();

    }
    //metodo que se le pasa la lista contraseñas y una contraseña y decimos si existe
    public static boolean existePassword (List<String> passwords, String password) {
        return passwords.contains(password);
    }
    //metodo que se le pasa la lista contraseñas y dos nº (offset y length),
    // y copia en un fichero desde el offset la cantidad length de contraseñas
    public static void escribirContraseñas (List<String> passwords, int offset, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = offset; i < offset +length; i++) {
            builder.append(passwords.get(i)).append('\n');
        }
        String datos = builder.toString();
        String escribir = datos.substring(0, datos.length() - 1);
        try {
            if (Files.exists(outPath))
                Files.writeString(outPath, escribir, StandardOpenOption.TRUNCATE_EXISTING);
            else
                Files.writeString(outPath, escribir, StandardOpenOption.CREATE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


