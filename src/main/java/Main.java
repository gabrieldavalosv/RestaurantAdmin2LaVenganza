import modelo.Menu;
import modelo.Orden;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Sabogal 👻");

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Orden orden = new Orden("3043", "ANDRES");
        for (int i = 0; i<5 ; i++){
            menu.mostrarMenu();
            System.out.print("Ingrese id: ");
            String id = scanner.nextLine();
            orden.agregarProducto(id, menu);
            orden.mostrarOrden();
        }


    }
}