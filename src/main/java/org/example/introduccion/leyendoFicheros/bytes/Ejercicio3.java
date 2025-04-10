package org.example.introduccion.leyendoFicheros.bytes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    private static Random random = new Random();
    public static void main(String[] args) {
        //usamos Scanner, leemos contraseñas y añadir a una List<String>
        List<String> passwords = new ArrayList<>();
        int maximaLongitud = Integer.MIN_VALUE;
        int minimoLongitud = Integer.MAX_VALUE;
        try (Scanner scanner = new Scanner(new File("files/inFiles/passwords.txt"))) {

            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                //System.out.println(scanner.nextLine());
                passwords.add(linea);
                int length = linea.length();
                if (length > maximaLongitud)
                    maximaLongitud = length;
                if (length < minimoLongitud)
                    minimoLongitud = length;
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
        //passwords.forEach(System.out::println);
        System.out.printf("leidas %d contraseñas, longitud mínima %d, longitud maxima %d%n",
                passwords.size(), minimoLongitud, maximaLongitud);
        long passwordConAlgunNumero = obtnerPasswordConAlgunNumero(passwords);
        System.out.printf("Contraseñas con al menos un número: %d%n", passwordConAlgunNumero);
        long passwordSoloNumeros = obtnerPasswordTodoNumeros(passwords);
        System.out.printf("Contraseñas con todo números: %d%n", passwordSoloNumeros);
        long passwordSoloLetras = passwords.size() - passwordConAlgunNumero;
        System.out.printf("Contraseñas con todo letras: %d%n", passwordSoloLetras);
        String passwordPalabra = "";
        for (;;) { //bucle infinito
            long startTime = System.nanoTime();
            int longitud = minimoLongitud +random.nextInt(maximaLongitud + 1);
            passwordPalabra = generarPasswordSoloLetras(longitud, true);
            if (passwords.contains(passwordPalabra)) {
                System.out.printf("Contraseña coincidente: %s%n", passwordPalabra);
                long endTime = System.nanoTime() - startTime;
                System.out.printf("Tiempo en buscar contraseña: %d nanosegundos%n", endTime);
                break;
            }
        }
        while (true) {
            long startTime = System.nanoTime();
            int longitud = minimoLongitud +random.nextInt(maximaLongitud + 1);
            String passwordNumero = generarPasswordSoloLetras(longitud, false);
            if (passwords.contains(passwordNumero)) {
                System.out.printf("Contraseña coincidente: %s%n", passwordNumero);
                long endTime = System.nanoTime() - startTime;
                System.out.printf("Tiempo en buscar contraseña: %d nanosegundos%n", endTime);
                break;
            }

        }

    }
    private static long obtnerPasswordConAlgunNumero(List<String> passwords) {
        return passwords.stream().
                filter(password -> password.matches(".*\\d.*") ).
                count();
    }
    private static long obtnerPasswordTodoNumeros(List<String> passwords) {
        return passwords.stream().
                filter(password -> password.matches("\\d+") ).
                count();
    }
    private static String generarPasswordSoloLetras (int size, boolean letras) {
        int asciiBajo = 48, ascciAmplitud = 11;
        if (letras)
            asciiBajo = 97; ascciAmplitud = 26;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char iCaracter = (char) (asciiBajo + random.nextInt(ascciAmplitud));  //usamos tabla ASCII
            builder.append(iCaracter);
        }
        return builder.toString();
    }

}
