package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final var listaPeliculas = FileManagerPeliculas.leerPeliculas("src/ejercicio3/peliculas.txt");
        final var resultadoPelicula = manipularPeliculas(listaPeliculas);

        FileManagerPeliculas.escribirResultado("src/ejercicio3/resultado3.txt", resultadoPelicula);
    }

    static List<String> manipularPeliculas(List<String> lista) {
        final var listaActualizada = new ArrayList<String>(); //Creo la lista vacía
        for (var i = 1; i < lista.size(); i++) {
            var pelicula = lista.get(i);
            var convertirMayuscula = String.format("%d. %s%n", i, pelicula.toUpperCase());
            listaActualizada.add(convertirMayuscula);
        }
        return listaActualizada;
    }
}
