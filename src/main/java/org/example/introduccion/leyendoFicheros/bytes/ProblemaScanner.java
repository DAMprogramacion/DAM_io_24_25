package org.example.introduccion.leyendoFicheros.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaScanner {
    public static void main(String[] args) {
        String numeros = "1 2 3 4 5 6 7 8 9";
        Scanner scanner = new Scanner(numeros);
        while (scanner.hasNextInt()){
            int numero = scanner.nextInt();
            System.out.printf("Leido: %d%n", numero);
        }

        System.out.println("=========Datos a procesar=============");
        String digitos = "1 2 3 4 5 6 7 8 9 0\n10 11 12 13 14 15 16 17 18 19\n20 21 22 23 24";
        System.out.println(digitos);
        scanner = new Scanner(digitos);
        while (scanner.hasNextInt()){
            int numero = scanner.nextInt();
            System.out.printf("  %d  ", numero);
        }
        System.out.println("=========Procesamos datos desde consola como int=============");
        scanner = new Scanner(System.in);
        int digito = -1;
        List<Integer> valores = new ArrayList<>();
        do {
            System.out.println("Introduce número");
            digito = scanner.nextInt();
            System.out.printf("Leido: %d%n", digito);
            valores.add(digito);
        } while (digito != -1);
        System.out.println("=========Procesamos datos desde consola como String=============");
        String sDigito = "-1";
        do {
            System.out.println("Introduce número");
            sDigito = scanner.next();
            if (!sDigito.matches("[0-9]+"))
                continue;
            digito = Integer.parseInt(sDigito);
            System.out.printf("Leido: %d%n", digito);
            valores.add(digito);
        } while (!sDigito.equals("-1"));
    }
}
