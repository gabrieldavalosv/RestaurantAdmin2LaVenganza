package modelo;

public class Pago {
    private String id;
    private float monto;
    private String metodo;
    private String estado;

    public Pago(String id, float monto, String metodo, String estado) {
        this.id = id;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
    }

    public boolean procesarPago() {
        if (validarPago()) {
            System.out.println("Procesando el pago de: " + monto + " mediante " + metodo);

            this.estado = "Pago realizado";
            return true;
        } else {
            System.out.println("El pago no se ha podido realizar");
            this.estado = "Pago fallido";
            return false;
        }
    }

    public boolean validarPago() {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0");
            return false;
        }
        if (!metodo.equals("Tarjeta") && !metodo.equals("Efectivo") && !metodo.equals("Transferencia")) {
            System.out.println("Los metodos de pago aceptado solo son Tarjeta, Efectivo, Transferencia");
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
        return metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
