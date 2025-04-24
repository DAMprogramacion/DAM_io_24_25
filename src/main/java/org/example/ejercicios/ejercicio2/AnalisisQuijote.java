package org.example.ejercicios.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AnalisisQuijote {
    private static int numeroLetras = 0;
    private static int numeroCaracteres = 0;
    private static int numeroPreposiciones = 0;
    private static Set<String> capitulos = new HashSet<>();
    private static List<String> numeros = new ArrayList<>();
    private static List<String> preposiciones = List.of("a", "ante", "bajo", "cabe", "con", "contra",
            "de", "desde", "durante", "en", "entre", "hacia", "hasta", "mediante", "para", "por",
            "según", "sin", "so", "sobre", "tras", "versus", "vı́a");
    public static void main(String[] args) {
        List<String> lineasQuijote = getLineasQuijote("files/ejercicios/elQuijote.txt");
        System.out.printf("Nº de líneas del libro el Quijote: %d%n", lineasQuijote.size());
        List<String> palabras = getPalabrasQuijote(lineasQuijote);
        System.out.printf("Nº palabras en el libro el Quijote: %d%n", palabras.size());
        System.out.printf("Nº letras en el libro el Quijote: %d%n", numeroLetras);
        System.out.println(numeros);
        StringBuilder builder = new StringBuilder();
        for (String numero : numeros)
            builder.append(numero);
        int numeroDigitos = builder.toString().length();
        System.out.printf("Nº dígitos en el libro el Quijote: %d%n",numeroDigitos );
        int numeroSignosPuntuacion = numeroCaracteres - numeroDigitos - numeroLetras;
        System.out.printf("Nº signos de puntuación en el libro el Quijote: %d%n",
                numeroSignosPuntuacion);
        String palabra = "Quijote";
        long numeroOcurrenciasPalabra1 =  numeroOcurrenciacontienePalabra(palabra, palabras);
        System.out.printf("La palabra %s aparece %d veces en el libro del Quijote%n",
                palabra, numeroOcurrenciasPalabra1);
        int numeroOcurrenciasPalabra2 = Collections.frequency(palabras, palabra.toLowerCase());
        System.out.printf("La palabra %s aparece %d veces en el libro del Quijote%n",
                palabra, numeroOcurrenciasPalabra2);
        System.out.printf("Nº capítulos en el libro el Quijote: %d%n", capitulos.size() );
        System.out.printf("Nº preposicines en el libro el Quijote: %d%n", numeroPreposiciones );




    }
    private static List<String> getLineasQuijote(String sPath) {
        Path path = Paths.get(sPath);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> getPalabrasQuijote (List<String> lineas) {
        int contador = 0;
        List<String> palabras = new ArrayList<>();
        for (String linea : lineas) {
            //Capítulo 4: ddsgfdgfdsg
            if (linea.toLowerCase().matches("capítulo \\d+:.*"))
                capitulos.add(linea);
            String[] tokens = linea.split("\\s+");
            String tokenLimpio = "";
            for (String token : tokens) {
                numeroCaracteres += token.length();

                if (token.matches(".*[0-9]+.*"))
                    numeros.add(token.replaceAll("[-,¡!;:\\.\"')(?¿]",""));
                tokenLimpio = token.toLowerCase().replaceAll("[-,¡!;:\\.0-9\"')(?¿]", "");
                if (tokenLimpio.length() != 0) {
                    palabras.add(tokenLimpio);
                    numeroLetras += tokenLimpio.length();
                    if (preposiciones.contains(tokenLimpio))
                        numeroPreposiciones++;
                }


            }
        }
        return palabras;
    }
    private static long numeroOcurrenciacontienePalabra (String vocablo, List<String> palabras) {
        return palabras.stream().
                filter(palabra -> palabra.equalsIgnoreCase(vocablo)).
                count();
    }
}
