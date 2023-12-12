// La clase Principal es la entrada principal del programa
package aplicacion;

import presentacion.*;

// La clase Principal contiene el método main que inicia la aplicación
public class Principal {

    /**
     * El método main es el punto de entrada principal del programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) 
    {
        // Se crea una instancia de la clase Interfaz para manejar la interacción con el usuario
        Interfaz interfaz = new Interfaz();
        // Se llama al método iniciar() para comenzar la ejecución de la interfaz
        interfaz.iniciar();
    }
}
