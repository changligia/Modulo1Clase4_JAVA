package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var listaMenu = FileManagerMenu.leerMenu("src/ejercicio1/opcionesMenu.txt");
        var listaResultado = new ArrayList<String>(); //Creo la lista vacía

        var scanner = new Scanner(System.in);
        String opcion;

        do {
            imprimirMenu(listaMenu);
            opcion = scanner.nextLine();
            listaResultado.add(ejecutarOpcion(opcion));
        } while (!opcion.equals("despedirse"));
        scanner.close();

        FileManagerMenu.escribirResultado("src/ejercicio1/resultado1.txt", listaResultado);
    }

    static void imprimirMenu(List<String> lista) {
        System.out.println();
        for (var palabra : lista) {
            System.out.printf("Palabra: %s%n", palabra);
        }
    }

    static String ejecutarOpcion(String palabra) {
        switch (palabra) {
            case "saludarme":
                return "Hola, como estas?";
            case "hora":
                return "Ok, te diré la hora";
            case "comida":
                return "Es hora de comer!";
            case "despedirse":
                return "Adios";
            default:
                return "Opción Incorrecta";
        }
    }
}

