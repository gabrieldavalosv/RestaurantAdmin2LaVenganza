import modelo.personal.Administrador;
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
        
        //Pantalla Login
        var pantallaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin(administrador1, pantallaLogin);
    }
}
