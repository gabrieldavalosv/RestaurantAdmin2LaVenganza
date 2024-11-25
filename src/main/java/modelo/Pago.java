package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.excepciones.MetodoInvalidoException;
import modelo.excepciones.MontoInsuficienteException;

public class Pago {
    private float monto;
    private MetodoPago metodoPago;
    private String estado;

    public Pago(float monto, MetodoPago metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public Pago(String id, float monto, MetodoPago metodoPago, String estado) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public boolean procesarPago(float totalPago, Orden orden, VentaArreglo ventas) {
        if (validarPago(totalPago)) {
            this.estado = "Pago realizado";

            // Obtener la fecha actual y formatearla a un String
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fecha = fechaActual.format(formatoFecha);
            
            Venta venta = new Venta(orden, fecha, this);
            ventas.agregarVenta(venta);
            System.out.println(venta.generarComprobante());

            return true;
        } else {
            this.estado = "Pago fallido";
            return false;
        }
    }

    public boolean validarPago(float totalPago) {
        try {
            if (monto < totalPago) {
                throw new MontoInsuficienteException();
            }
            if (!metodoPago.getMetodo().equals("Tarjeta") && !metodoPago.getMetodo().equals("Efectivo")) {
                throw new MetodoInvalidoException();
            }
            return true;
        } catch (MontoInsuficienteException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (MetodoInvalidoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public float getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodoPago.getMetodo();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
