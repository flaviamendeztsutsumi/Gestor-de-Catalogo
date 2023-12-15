// Importamos las clases y paquetes necesarios
package presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import dominio.*;

/**
 * La clase Interfaz es la interfaz de usuario que maneja la interacción con el programa.
 */
public class Interfaz 
{

    // Atributos de la clase
    private Almacen almacen;
    private Scanner scanner;

    /**
     * Constructor de la clase Interfaz.
     * Inicializa un nuevo almacen y un nuevo Scanner para entrada de usuario.
     * Lee el estado anterior del almacén desde un archivo.
     */
    public Interfaz() 
    {
        almacen = new Almacen(); 
        scanner = new Scanner(System.in);
        leer();
    }

    /**
     * Lee el estado anterior del almacén desde un archivo.
     */
    private void leer() {
        File file = new File("almacen.dat");

        if (file.exists()) {
            try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
                almacen = (Almacen) obj.readObject();
                System.out.println("Leído");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo del almacén: " + e.getMessage());
            }
        } else {
            System.out.println("No hay archivo de almacén existente. Se ha creado un almacén nuevo.");
        }
    }
    

    /**
     * Menú para el dueño de la tienda.
     */
    public void menuDuenno() 
    {
        System.out.println("========= Menú del Dueño =========");
        System.out.println("|1. Agregar Zapatilla           |");
        System.out.println("|2. Borrar Zapatilla            |");
        System.out.println("|3. Actualizar Zapatilla        |");
        System.out.println("|4. Mostrar el Almacen          |");
        System.out.println("|5. Precio total Almacen        |");
        System.out.println("|6. Salir                       |");
        System.out.print("Elige una opción: ");
    }

    /**
     * Menú para el cliente.
     */
    public void menuCliente() 
    {
        System.out.println("========= Menú del Cliente ========");
        System.out.println("|1. Borrar Zapatilla              |");
        System.out.println("|2. Buscar Zapatilla              |");
        System.out.println("|3. Mostrar el Almacen            |");
        System.out.println("|4. Salir                         |");
        System.out.print("Elige una opción: ");
    }

    /**
     * Método principal para iniciar la interfaz.
     * Permite a los usuarios (dueño o cliente) realizar diversas operaciones en la tienda.
     */
    public void iniciar() 
    {
        int opc;
        System.out.print("Si eres dueño 1 y si eres cliente:");
        int escribir = scanner.nextInt(); 
        do {
            if (escribir == 1) {
                menuDuenno();
                opc = scanner.nextInt(); 
                scanner.nextLine();
                comandosDueno(opc); 
            } else if (escribir == 2) {
                menuCliente();
                opc = scanner.nextInt(); 
                scanner.nextLine();
                comandoCliente(opc); 
            } else {
                System.out.println("Tipo de usuario no válido, solo puedes ser dueño o cliente.");
                break;
            }
        } while ((escribir == 1 && opc != 6) || (escribir == 2 && opc != 4));
    }

    /**
     * Ejecuta los comandos del dueño basados en la opción seleccionada.
     * @param opcion La opción seleccionada por el dueño.
     */
    private void comandosDueno(int opcion) 
    {
        if (opcion == 1) {
            agregarZapatilla();
        } else if (opcion == 2) {
            borrarZapatilla();
            System.out.println("Zapatilla retirada del almacen");
        } else if (opcion == 3) {
            actualizarZapatilla();
        } else if (opcion == 4) {
            System.out.println("Precio total de todas tus existencias");
            mostrarAlmacen();
        } else if (opcion == 5) {
            calcularTotalTienda();
        } else if (opcion == 6) {
            grabar();
            System.out.println("Saliendo del menú como dueño.");
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

    /**
     * Ejecuta los comandos del cliente basados en la opción seleccionada.
     * @param opcion La opción seleccionada por el cliente.
     */
    private void comandoCliente(int opcion) 
    {
        if (opcion == 1) {
            borrarZapatilla();
            System.out.println("Has comprado la zapatilla exitosamente.");
        } else if (opcion == 2) {
            buscarZapatilla();
        } else if (opcion == 3) {
            System.out.println("Tienes estos productos en tu cesta");
            mostrarAlmacen();
        } else if (opcion == 4) {
            grabar();
            System.out.println("Saliendo del menú como cliente.");
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

    /**
     * Agrega una zapatilla al almacén.
     */
    private void agregarZapatilla() 
    {
        System.out.print("Nombre de la zapatilla que quiere añadir : ");
        String nombre = scanner.nextLine();
        System.out.print("Precio de la zapatilla: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("¿Cúal es el color de la zapatilla?: ");
        String color = scanner.nextLine();

        Zapatilla zapatilla = new Zapatilla(nombre, precio, color);
        almacen.agregarZapatilla(zapatilla);

        System.out.println("Zapatilla añadida.");
    }

    /**
     * Borra una zapatilla del almacén.
     */
    private void borrarZapatilla() 
    {
        System.out.println("¿Cúal es el nombre de la zapatilla que quiere borrar?: ");
        String nombre = scanner.nextLine();
        almacen.borrarZapatilla(nombre);
        System.out.println("Zapatilla retirada del almacén.");
    }

    /**
     * Busca una zapatilla en el almacén.
     */
    private void buscarZapatilla() 
    {
        System.out.println("¿Cúal es el nombre de la zapatilla que quiere buscar?: ");
        // Aquí se debería implementar la lógica para buscar una zapatilla específica
    }

    /**
     * Muestra todas las zapatillas en el almacén.
     */
    private void mostrarAlmacen() 
    {
        almacen.mostrarZapatilla();
    }

    /**
     * Actualiza una zapatilla en el almacén.
     */
    private void actualizarZapatilla() {
        System.out.println("Nombre de la zapatilla que quiere actualizar");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo color de la zapatilla (o deje en blanco para mantener el actual): ");
        String nuevoColor = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio de la zapatilla (o -1 para mantener el actual): ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        almacen.actualizarZapatilla(nombre, nuevoColor, nuevoPrecio);
    }

    /**
     * Calcula el precio total de todas las zapatillas en el almacén.
     */
    private void calcularTotalTienda() {
        almacen.calcularTotalTienda();
    }

    /**
     * Guarda el estado actual del almacén en un archivo.
     */
    public void grabar() 
    {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("almacen.dat"))) {
            obj.writeObject(almacen);
            System.out.println("El almacen se ha grabado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al grabar el almacen: " + e.getMessage());
        }
    }
}
