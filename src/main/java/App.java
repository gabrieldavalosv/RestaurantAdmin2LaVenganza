import modelo.personal.Administrador;
import modelo.personal.Cajero;

import controlador.CtrlPantallaLogin;
import vista.PantallaLogin;

/**
 *
 * @author Davi
 */

public class App {
    public static void main(String[] args) {
        
        // Creacion de personales
        Administrador administrador1 = new Administrador("100", "Mathias", "2301");
        Cajero cajero = new Cajero("201", "Sabogal", "wasa", "0145480641");
        Cajero cajero2 = new Cajero("202", "David", "admin", "7777777777");

        /*
        administrador.agregarCajero(cajero);
        administrador.agregarCajero(cajero2);

         */
        
        //Pantalla Login
        var pantallaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin(administrador1, pantallaLogin);
    }
}
