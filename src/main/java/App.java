import modelo.excepciones.ArregloLLenoException;
import modelo.personal.Administrador;
import modelo.personal.Cajero;

import vista.PantallaLogin;

import controlador.CtrlPantallaLogin;

/**
 *
 * @author Davi
 */

public class App {
    public static void main(String[] args) throws ArregloLLenoException {
        
        // Creacion de personales
        Administrador administrador = new Administrador("1", "admin", "admin");
        Cajero cajero = new Cajero("101", "Mathias", "admin", "24920348942");
        Cajero cajero2 = new Cajero("102", "Leo malcriao", "admin", "77777777");
        
        administrador.agregarCajero(cajero);
        administrador.agregarCajero(cajero2);
        
        //Pantalla Login
        var pantallaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin(administrador, pantallaLogin);
    }
}
