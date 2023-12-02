package dominio;
import java.util.ArrayList;
import java.io.Serializable;

public class  Almacen implements Serializable{

    private ArrayList<Zapatilla> zapatillas;

    public Almacen()
    {
        zapatillas = new ArrayList<>();
    }    

    
    public void agregarZapatilla(Zapatilla zapatilla)
    {
        zapatillas.add(zapatilla);
    }


    public void mostrarZapatilla()
    {
        for (Zapatilla zapatilla : zapatillas)
        {
            System.out.println(zapatilla);
        }
    }


    public void borrarZapatilla(String nombre)
    {
        for (Zapatilla zapatilla : zapatillas)
        {
            if (zapatilla.getNombre().equals(nombre))
            {
                zapatillas.remove(zapatilla);
                return;
            }
        }
        System.out.println("No se ha encontrado la zapatilla"+ " " + nombre + " "+ " en la tienda");
    }


    public void actualizarZapatilla(String nombre, String color, double precio)
    {
        for (Zapatilla zapatilla : zapatillas)
        {
            if (zapatilla.getNombre().equals(nombre))
            {
                zapatilla.actualizar(color, precio);
                System.out.println("Zapatilla actualizada");
                return;

            }
        }
        System.out.println("Zapatilla no encontrada, vuelva a intentarlo");
    }

    public double calcularTotalTienda()
    {
        double totalTienda = 0;
        for (Zapatilla zapatilla : zapatillas)
        {
            totalTienda += zapatilla.getPrecio();
        }
        System.out.println("El precio total del almacen es:" + " " + totalTienda + "");
        return totalTienda;
    }
}   
