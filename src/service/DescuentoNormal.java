package service;

/**
 * Estrategia de descuento para clientes normales.
 * Aplica un descuento fijo o ninguno según el monto.
 */
public class DescuentoNormal implements IDescuentoStrategy {
    
    private static final double DESCUENTO_STANDAR = 5.0;
    private static final double MONTO_MINIMO = 500.0;
    
    @Override
    public double calcularDescuento(double montoTotal) {
        if (montoTotal >= MONTO_MINIMO) {
            return DESCUENTO_STANDAR;
        }
        return 0.0;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Descuento Normal: 5% si compra mayor a S/ 500";
    }
}
