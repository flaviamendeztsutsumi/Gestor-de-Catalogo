package dominio;
import java.io.Serializable;

public class Zapatilla implements Serializable 
{
    private String nombre;
    private String color;
    private double precio;

    public Zapatilla(String nombre, double precio, String color) 
    {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setColor(String color) 
    {
        this.color = color;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getColor() 
    {
        return color;
    }

    public double getPrecio() 
    {
        return precio;
    }

    public void actualizar(String color, double precio) {
        this.color = color;
        this.precio = precio;
    }


    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Zapatilla zapatilla = (Zapatilla) obj;
        return nombre != null ? nombre.equals(zapatilla.nombre) : zapatilla.nombre == null;
    }


    public String toString() {
        return "Nombre: " + nombre + ", Color: " + color + ", Precio: $" + precio;
    }
}
