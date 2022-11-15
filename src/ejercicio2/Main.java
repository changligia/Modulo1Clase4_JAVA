package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final var mapNumeros = FileManagerNumeros.leerNumeros("src/ejercicio2/numeros.txt");
        final var listaResultado = new ArrayList<String>(); //Creo la lista vacía

        var scanner = new Scanner(System.in);
        int keyNumero;

        do {
            System.out.println("Escriba -1 para salir del programa: ");
            imprimirKeys(mapNumeros);
            keyNumero = scanner.nextInt();

            listaResultado.add(buscarNumero(keyNumero, mapNumeros));
        } while (keyNumero != -1);
        scanner.close();

        FileManagerNumeros.escribirResultado("src/ejercicio2/resultado2.txt", listaResultado);
    }

    static void imprimirKeys(HashMap<Integer, String> map) {
        System.out.println();
        for (var set : map.entrySet()) {
            System.out.printf("Palabra: %s%n", set.getKey());
        }
    }

    static String buscarNumero(int n, HashMap<Integer, String> map) {
        return map.getOrDefault(n, "No existe");
    }
}