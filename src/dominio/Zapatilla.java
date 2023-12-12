package dominio;

import java.io.Serializable;

/**
 * La clase Zapatilla representa un objeto de tipo zapato en una tienda.
 * Esta clase implementa la interfaz Serializable para que las instancias puedan ser convertidas a bytes y viceversa.
 */
public class Zapatilla implements Serializable {
    // Atributos de la clase
    private String nombre;
    private String color;
    private double precio;

    /**
     * Constructor que inicializa una Zapatilla con un nombre, precio y color.
     *
     * @param nombre Nombre de la zapatilla.
     * @param precio Precio de la zapatilla.
     * @param color  Color de la zapatilla.
     */
    public Zapatilla(String nombre, double precio, String color) {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
    }

    // Métodos de acceso (getters y setters)

    /**
     * Obtiene el nombre de la zapatilla.
     *
     * @return El nombre de la zapatilla.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la zapatilla.
     *
     * @param nombre Nuevo nombre de la zapatilla.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el color de la zapatilla.
     *
     * @return El color de la zapatilla.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la zapatilla.
     *
     * @param color Nuevo color de la zapatilla.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el precio de la zapatilla.
     *
     * @return El precio de la zapatilla.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la zapatilla.
     *
     * @param precio Nuevo precio de la zapatilla.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Actualiza el color y precio de la Zapatilla.
     *
     * @param color  Nuevo color de la zapatilla.
     * @param precio Nuevo precio de la zapatilla.
     */
    public void actualizar(String color, double precio) {
        setColor(color);
        setPrecio(precio);
    }

    /**
     * Compara si dos Zapatillas son iguales.
     *
     * @param obj Objeto a comparar.
     * @return true si las Zapatillas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Zapatilla zapatilla = (Zapatilla) obj;
        return nombre.equals(zapatilla.nombre);
    }

    /**
     * Representa la información de la Zapatilla en forma de cadena.
     *
     * @return Cadena que representa la información de la Zapatilla.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Color: " + color + ", Precio: $" + precio;
    }
}
