package modelo;

// Clase que representa un Pago realizado por un cliente
public class Pago {
    // Identificador único del pago
    private String id;

    // Monto total del pago
    private Float monto;

    // Método de pago utilizado (por ejemplo, "efectivo", "tarjeta")
    private String metodoPago;

    // Estado actual del pago (por ejemplo, "Pendiente", "Completado", "Fallido")
    private String estado;


    public Pago(String id, Float monto, String metodoPago) {
        // Validación: Ningún parámetro puede ser null
        if (id == null || monto == null || metodoPago == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        // Validación: El monto debe ser mayor que cero
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        this.id = id;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = "Pendiente"; // Estado inicial del pago
    }


    public boolean procesarPago() {
        try {
            // Verifica si hay fondos suficientes para procesar el pago
            if (verificarFondos()) {
                switch (metodoPago.toLowerCase()) {
                    case "efectivo":
                        return procesarPagoEfectivo(); // Procesa pago en efectivo
                    case "tarjeta":
                        return procesarPagoTarjeta(); // Procesa pago con tarjeta
                    default:
                        throw new IllegalStateException("Método de pago no soportado");
                }
            }
            return false; // Fondos insuficientes
        } catch (Exception e) {
            estado = "Fallido"; // Actualiza el estado del pago a "Fallido" en caso de excepción
            return false;
        }
    }


    private boolean verificarFondos() {
        return true;
    }


    private boolean procesarPagoEfectivo() {
        estado = "Completado"; // Actualiza el estado del pago a "Completado"
        return true;
    }


    private boolean procesarPagoTarjeta() {
        estado = "Completado"; // Actualiza el estado del pago a "Completado"
        return true;
    }

    public String getId() {
        return id;
    }

    public Float getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }


    public String getEstado() {
        return estado;
    }


    public void setMetodoPago(String metodoPago) {
        // Validación: El método de pago no puede ser null ni estar vacío
        if (metodoPago == null || metodoPago.trim().isEmpty()) {
            throw new IllegalArgumentException("El método de pago no puede estar vacío");
        }
        this.metodoPago = metodoPago;
    }
}
