package modelo;

public class Pago {
    private String id;
    private float monto;
    private MetodoPago metodoPago;
    private String estado;

    public Pago(float monto, MetodoPago metodoPago){
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
    
    public Pago(String id, float monto, MetodoPago metodoPago, String estado) {
        this.id = id;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public boolean procesarPago() {
        if (validarPago()) {

            this.estado = "Pago realizado";
            return true;
        } else {
            this.estado = "Pago fallido";
            return false;
        }
    }

    public boolean validarPago() {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0");
            return false;
        }
        if (!metodoPago.getMetodo().equals("Tarjeta") && !metodoPago.getMetodo().equals("Efectivo") && !metodoPago.getMetodo().equals("Transferencia")) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
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
