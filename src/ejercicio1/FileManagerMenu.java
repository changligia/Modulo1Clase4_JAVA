package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerMenu {

    public static List<String> leerMenu(String path) {
        var listaMenu = new ArrayList<String>(); //Creo la lista vacía

        var fileMenu = new File(path); //declaro la variable file

        try {
            var scanner = new Scanner(fileMenu);
            while (scanner.hasNextLine()) { //mientras que haya contenido hago lo siguiente
                var lineaMenu = scanner.nextLine();
                listaMenu.add(lineaMenu); //meto las opcionesMenu a la lista
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File No encontrado");
            System.out.println(fileNotFoundException.getLocalizedMessage());
        }
        return listaMenu;
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

