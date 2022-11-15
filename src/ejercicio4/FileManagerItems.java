package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileManagerItems {
    static List<String> llamarData(String path) {
        final var listaItems = new ArrayList<String>(); //Creo la lista vacía

        var fileItems = new File(path); //declaro la variable file

        try {
            var scanner = new Scanner(fileItems);
            while (scanner.hasNextLine()) { //mientras que haya contenido hago lo siguiente

                final var lineaItems = scanner.nextLine();
                listaItems.add(lineaItems); //meto los items a la lista
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File No encontrado");
            System.out.println(fileNotFoundException.getLocalizedMessage());
        }
        return listaItems;
    }

    public static void escribirResultadoStock(String path, HashMap<String, Integer> mapStock) {
        try {
            var fileWriter = new FileWriter(path);

            for (var set : mapStock.entrySet()) {
                var mensaje = String.format("Nombre: %s\t Stock: %d\n", set.getKey(), set.getValue());
                fileWriter.write(mensaje);
            }

            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
    }

    public static void escribirResultadoPrecio(String path, HashMap<String, Double> mapPrecio) {
        try {
            var fileWriter = new FileWriter(path);

            for (var set : mapPrecio.entrySet()) {
                var mensaje = String.format("Item: %s\t Precio: %.2f\n", set.getKey(), set.getValue());
                fileWriter.write(mensaje);
            }

            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
    }

    public static void escribirResultadoTienda(String path, HashMap<String, Double> mapPrecio,
                                               HashMap<String, Integer> mapStock) {
        try {
            var fileWriter = new FileWriter(path);

            for (var set : mapPrecio.entrySet()) {
                var stock = mapStock.get(set.getKey());
                var mensaje = String.format("Item: %s\t Precio: %.2f\t Stock: %d\n", set.getKey(),
                        set.getValue(), stock);
                fileWriter.write(mensaje);
            }
            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
    }
}
