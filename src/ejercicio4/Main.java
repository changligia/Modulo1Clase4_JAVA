package ejercicio4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final var listaTexto = FileManagerItems.llamarData("src/ejercicio4/items.txt");
        final var mapPrecio = new HashMap<String, Double>(); //creo el map vacío, key: nombre, value: precio
        final var mapStock = new HashMap<String, Integer>(); //creo el map vacío, key: nombre, value: stock

        organizarData(listaTexto, mapPrecio, mapStock);

        FileManagerItems.escribirResultadoStock("src/ejercicio4/stock.txt", mapStock);

        FileManagerItems.escribirResultadoPrecio("src/ejercicio4/precio.txt", mapPrecio);

        FileManagerItems.escribirResultadoTienda("src/ejercicio4/tienda.txt", mapPrecio, mapStock);
    }

    static void organizarData(List<String> listaTexto, HashMap<String, Double> mapPrecio,
                              HashMap<String, Integer> mapStock) {
        for (var linea : listaTexto) {
            final var listaItems = Arrays.asList(linea.split(","));
            final var index = listaItems.get(0).indexOf("USD"); //posición

            final var precioSinDolar = Double.parseDouble(listaItems.get(0).substring(0, index)); // "XX.XX"
            final var stock = Integer.parseInt(listaItems.get(1));
            final var nombre = listaItems.get(2);

            mapPrecio.put(nombre, precioSinDolar);
            mapStock.put(nombre, stock);
        }
    }
}