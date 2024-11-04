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
        Cajero cajero = new Cajero("101", "Mathias", "admin", "24920348942");
        Cajero cajero2 = new Cajero("102", "Leo malcriao", "admin", "77777777");
        administrador.agregarCajero(cajero);
        System.out.println(administrador.getCajeroArreglo());
        administrador.agregarCajero(cajero2);
        System.out.println(administrador.getCajeroArreglo());
        cajero.crearOrden("304", "Sabogal");

        for (int i = 0; i < 5; i++) {
            System.out.println(menu);
            System.out.print("ID: ");
            String id = scanner.nextLine();
            cajero.getOrdenArreglo().buscarOrden("304").agregarProductoALaOrden(id, menu);
            cajero.getOrdenArreglo().buscarOrden("304").mostrarOrden();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(menu);
            System.out.print("ID: ");
            String id = scanner.nextLine();
            cajero2.getOrdenArreglo().buscarOrden("304").agregarProductoALaOrden(id, menu);
            cajero2.getOrdenArreglo().buscarOrden("304").mostrarOrden();
        }

    }
}