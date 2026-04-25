package service;

/**
 * Estrategia de descuento para clientes VIP.
 * Aplica un descuento progresivo basado en el monto de la compra.
 */
public class DescuentoVIP implements IDescuentoStrategy {
    
    private static final double DESCUENTO_BASE = 15.0;
    private static final double DESCUENTO_MEJORADO = 20.0;
    private static final double MONTO_MINIMO = 1000.0;
    
    @Override
    public double calcularDescuento(double montoTotal) {
        if (montoTotal >= MONTO_MINIMO) {
            return DESCUENTO_MEJORADO;
        }
        return DESCUENTO_BASE;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Descuento VIP: 15-20% según monto";
    }
}
