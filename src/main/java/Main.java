import modelo.Cajero;
import modelo.Menu;
import modelo.Orden;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Sabogal 👻");

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Cajero cajero = new Cajero("101", "Sabogal", "admin", "24920348942");
        cajero.crearOrden();
    }
}