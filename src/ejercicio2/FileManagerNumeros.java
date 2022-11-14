package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileManagerNumeros {
    public static HashMap<Integer, String> leerNumeros(String path) {
        final var mapNumeros = new HashMap<Integer, String>(); //creo el map vacío

        final var fileNumero = new File(path); //declaro la variable file

        try {
            var scanner = new Scanner(fileNumero);
            while (scanner.hasNextLine()) { //mientras que haya contenido hago lo siguiente

                final var lineaNumero = scanner.nextLine();

                final var lista = Arrays.asList(lineaNumero.split(","));

                final var numero = Integer.parseInt(lista.get(0));
                final var descripcion = lista.get(1);

                mapNumeros.put(numero, descripcion);

            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File No encontrado");
            System.out.println(fileNotFoundException.getLocalizedMessage());
        }
        return mapNumeros;
    }

    public static void escribirResultado(String path, List<String> listaResultado) {
        try {
            var fileWriter = new FileWriter(path);

            for (var resultado : listaResultado) {
                var mensaje = String.format("%s\n", resultado);
                fileWriter.write(mensaje);
            }

            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
    }
}

