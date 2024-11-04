import modelo.Orden;
import modelo.OrdenArreglo;
import modelo.personal.Administrador;
import modelo.personal.Cajero;
import modelo.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Sabogal 👻");

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        Administrador administrador = new Administrador("1", "admin", "admin");
        Cajero cajero = new Cajero("101", "Sabogal", "admin", "24920348942");
        administrador.agregarCajero(cajero);
        cajero.crearOrden("105", "Mathias");
        Orden orden = new Orden("105", "Sabogal");

        for (int i = 0; i < 5; i++) {
            menu.mostrarMenu();
            System.out.print("ID: ");
            String id = scanner.nextLine();
            cajero.getOrdenArreglo().agregarOrden(new Orden(id, "Sabogal"));
            cajero.getOrdenArreglo().buscarOrden(orden.mostrarOrden());

        }

    }
}