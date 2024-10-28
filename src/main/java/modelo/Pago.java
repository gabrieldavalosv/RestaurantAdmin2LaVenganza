package modelo;

public class Pago {
    private String id;
    private Float monto;
    private String metodoPago;
    private String estado;

    public Pago(String id, Float monto, String metodoPago) {
        if (id == null || monto == null || metodoPago == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        this.id = id;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = "Pendiente";
    }

    public boolean procesarPago() {
        try {
            if (verificarFondos()) {
                switch (metodoPago.toLowerCase()) {
                    case "efectivo":
                        return procesarPagoEfectivo();
                    case "tarjeta":
                        return procesarPagoTarjeta();
                    default:
                        throw new IllegalStateException("Método de pago no soportado");
                }
            }
            return false;
        } catch (Exception e) {
            estado = "Fallido";
            return false;
        }
    }

    private boolean verificarFondos() {
        return true;
    }

    private boolean procesarPagoEfectivo() {
        estado = "Completado";
        return true;
    }

    private boolean procesarPagoTarjeta() {
        estado = "Completado";
        return true;
    }
}

