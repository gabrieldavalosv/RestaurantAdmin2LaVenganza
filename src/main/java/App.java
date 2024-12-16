import controlador.CtrlPantallaLogin;
import vista.GestionDePlatos;
import vista.PantallaLogin;

/**
 *
 * @author Davi
 */

public class App {
    public static void main(String[] args) {

        //Pantalla Login
        var pantallaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin(pantallaLogin);
    }
}
