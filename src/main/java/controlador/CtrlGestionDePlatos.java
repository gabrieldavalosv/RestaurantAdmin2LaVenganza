package controlador;

import modelo.Menu;
import vista.GestionDePlatos;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Davi
 */

public class CtrlGestionDePlatos {
    private Menu modelo;
    private GestionDePlatos vista;
    
    public CtrlGestionDePlatos(Menu modelo, GestionDePlatos vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.buttonCrearPlato.addActionListener( e -> eventoCrearPlato() );
        
        this.vista.setVisible(true);
    }
    
    private void eventoCrearPlato(){

    }
}
