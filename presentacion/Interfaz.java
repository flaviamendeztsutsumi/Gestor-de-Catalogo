package presentacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import dominio.Almacen;
import dominio.Zapatilla;

public class Interfaz {

    private Almacen almacen;
    private Scanner scanner;

    public Interfaz() 
    {
        almacen = new Almacen();
        scanner = new Scanner(System.in);
    }

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

    public void menuCliente() 
    {
        System.out.println("========= Menú del Cliente ========");
        System.out.println("|1. Borrar Zapatilla              |");
        System.out.println("|2. Buscar Zapatilla              |");
        System.out.println("|3. Mostrar el Almacen            |");
        System.out.println("|4. Salir                         |");
        System.out.print("Elige una opción: ");
    }

    public void iniciar() 
    {
        int opc;
        System.out.println("Si eres dueño 1 y si eres cliente:");
        int escribir = scanner.nextInt();
        do {
            if (escribir == 1) {
                menuDuenno();
                opc = scanner.nextInt();
                scanner.nextLine();
                comandosDueño(opc);
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

    private void comandosDueño(int opcion) 
    {
        if (opcion == 1) {
            agregarZapatilla();
        } else if (opcion == 2) {
            borrarZapatilla();
            System.out.println("Zapatilla retirada del almacen");
        } else if (opcion == 3) {
            actualizarZapatilla();
        } else if (opcion == 4) {
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

    private void comandoCliente(int opcion) 
    {
        if (opcion == 1) {
            borrarZapatilla();
            System.out.println("Has comprado la zapatilla exitosamente.");
        } else if (opcion == 2) {
            buscarZapatilla();
        } else if (opcion == 3) {
            mostrarAlmacen();
        } else if (opcion == 4) {
            grabar();
            System.out.println("Saliendo del menú como cliente.");
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

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
    

    private void borrarZapatilla() 
    {
        System.out.println("¿Cúal es el nombre de la zapatilla que quiere borrar?: ");
        String nombre = scanner.nextLine();
        almacen.borrarZapatilla(nombre);
    }

    
    private void buscarZapatilla() 
    {
        System.out.println("¿Cúal es el nombre de la zapatilla que quiere buscar?: ");
    }

    private void mostrarAlmacen() 
    {
        almacen.mostrarZapatilla();
    }


    private void actualizarZapatilla() 
    {
        System.out.println("Nombre de la zapatillas que quiere actualizar");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo color de la zapatilla (o deje en blanco para mantener el actual): ");
        String nuevoColor = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio de la zapatilla (o -1 para mantener el actual): ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine(); 

        almacen.actualizarZapatilla(nombre, nuevoColor, nuevoPrecio);

    }

    private void calcularTotalTienda() 
    {
        almacen.calcularTotalTienda();
    }

 
    public void grabar() 
    {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("almacen.dat"))) 
        {
            obj.writeObject(almacen);
            System.out.println("El almacen se ha grabado correctamente.");
        } catch (IOException e) 
        {
            System.out.println("Error al grabar el almacen: " );
        }
    }
}

