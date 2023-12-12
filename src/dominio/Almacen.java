package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Almacen representa un almacenamiento de zapatillas y permite realizar operaciones en ellas.
 * Implementa la interfaz Serializable para que los objetos de esta clase puedan ser grabados y guardados en un archivo.
 */
public class Almacen implements Serializable {

    // ArrayList que almacena objetos de la clase Zapatilla
    private ArrayList<Zapatilla> zapatillas;

    /**
     * Constructor de la clase Almacen. Inicializa el ArrayList que almacenará las zapatillas.
     */
    public Almacen() {
        zapatillas = new ArrayList<>();
    }

    /**
     * Agrega una zapatilla al ArrayList del Almacen.
     *
     * @param zapatilla La zapatilla a agregar.
     */
    public void agregarZapatilla(Zapatilla zapatilla) {
        zapatillas.add(zapatilla);
    }

    /**
     * Muestra todas las zapatillas en el Almacen.
     */
    public void mostrarZapatilla() {
        for (Zapatilla zapatilla : zapatillas) {
            System.out.println(zapatilla);
        }
    }

    /**
     * Borra una zapatilla del Almacen por su nombre.
     *
     * @param nombre El nombre de la zapatilla a borrar.
     */
    public void borrarZapatilla(String nombre) {
        for (Zapatilla zapatilla : zapatillas) {
            if (zapatilla.getNombre().equals(nombre)) {
                // Elimina la zapatilla si se encuentra
                zapatillas.remove(zapatilla);
                return;
            }
        }
        System.out.println("No se ha encontrado la zapatilla " + nombre + " en el almacén");
    }

    /**
     * Actualiza una zapatilla del Almacen por su nombre, color y precio.
     *
     * @param nombre El nombre de la zapatilla a actualizar.
     * @param color  El nuevo color de la zapatilla.
     * @param precio El nuevo precio de la zapatilla.
     */
    public void actualizarZapatilla(String nombre, String color, double precio) {
        for (Zapatilla zapatilla : zapatillas) {
            if (zapatilla.getNombre().equals(nombre)) {
                // Llama al método actualizar de la clase Zapatilla
                zapatilla.actualizar(color, precio);
                System.out.println("Zapatilla actualizada");
                return;
            }
        }
        System.out.println("Zapatilla no encontrada, vuelva a intentarlo");
    }

    /**
     * Calcula el precio total del Almacen sumando los precios de todas las zapatillas.
     *
     * @return El precio total del Almacen.
     */
    public double calcularTotalTienda() {
        double totalTienda = 0;
        for (Zapatilla zapatilla : zapatillas) {
            totalTienda += zapatilla.getPrecio();
        }
        System.out.println("El precio total del almacen es: " + totalTienda);
        return totalTienda;
    }
}
