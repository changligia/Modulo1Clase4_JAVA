package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerPeliculas {
    static List<String> leerPeliculas(String path) {

        final var listaPelicula = new ArrayList<String>(); //Creo la lista vacía

        var filePeliculas = new File(path); //declaro la variable file

        try {
            var scanner = new Scanner(filePeliculas);
            while (scanner.hasNextLine()) { //mientras que haya contenido hago lo siguiente

                final var lineaPelicula = scanner.nextLine();
                listaPelicula.add(lineaPelicula); //meto las peliculas a la lista

            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File No encontrado");
            System.out.println(fileNotFoundException.getLocalizedMessage());

        }
        return listaPelicula;
    }

    public static void escribirResultado(String path, List<String> listaResultado) {
        try {
            var fileWriter = new FileWriter(path);

            for (var resultado : listaResultado) {
                var mensaje = String.format("%s", resultado);
                fileWriter.write(mensaje);
            }

            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
    }
}
