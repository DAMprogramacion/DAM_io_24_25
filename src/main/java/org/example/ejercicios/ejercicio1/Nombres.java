package org.example.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Nombres {
    private final Set<String> nombreMujer;
    private final Set<String> nombreHombre;

    public Nombres(Set<String> nombreMujer, Set<String> nombreHombre) {
        this.nombreMujer = nombreMujer;
        this.nombreHombre = nombreHombre;
    }

    /*public Set<String> getNombreMujer() {
        return nombreMujer;
    }*/
    public String obtenerGenero(String nombre) {
        if (nombreHombre.contains(nombre.toLowerCase()))
            return "nombre de hombre";
        if (nombreMujer.contains(nombre.toLowerCase()))
            return "nombre de mujer";
        return "no existe ese nombre";

    }
    public List<String> nombresCoincidentes(String caracteres){
        List<String> nombreHombreCoincidentes = nombreHombre.stream().
                filter(nombre -> nombre.startsWith(caracteres.toLowerCase())).
                collect(Collectors.toList());
        List<String> nombreMujerCoincidentes = nombreMujer.stream().
                filter(nombre -> nombre.startsWith(caracteres.toLowerCase())).
                toList();
        nombreHombreCoincidentes.addAll(nombreMujerCoincidentes);
        return nombreHombreCoincidentes;

    }
    public String getNombreAleatorio(String genero) {
        Random random = new Random();
        int contador = 0;
        if (genero.equalsIgnoreCase("mujer")) {
            int aleatorio =  random.nextInt(nombreMujer.size());
            for (String nombre : nombreMujer) {
                if (aleatorio == contador)
                    return nombre;
                contador++;
            }
        }
        if (genero.equalsIgnoreCase("hombre")) {
            int aleatorio = random.nextInt(nombreHombre.size());
            for (String nombre : nombreHombre) {
                if (aleatorio == contador)
                    return nombre;
                contador++;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Set<String> hombres = Helper.getSetNames(
                "files/ejercicios/nombres_hombre.txt");
        Set<String> mujeres = Helper.getSetNames(
                "files/ejercicios/nombres_mujer.txt");
        Nombres nombres = new Nombres(mujeres, hombres);
        //nombres.getNombreMujer().forEach(System.out::println);
        /*List<String> uno = new ArrayList<String>(List.of("uno", "dos"));
        List<String> dos = List.of("tres", "cuatro");
        uno.addAll(dos);*/
        System.out.println(nombres.nombresCoincidentes("ABE"));
        System.out.printf("Aleatorio de hombre: %S%n",
                nombres.getNombreAleatorio("Hombre"));
        System.out.printf("Aleatorio de mujer: %S%n",
                nombres.getNombreAleatorio("mujer"));
    }
}
