package service;

/**
 * Estrategia de descuento para clientes empresariales.
 * Aplica descuentos escalonados según el volumen de compra.
 */
public class DescuentoEmpresa implements IDescuentoStrategy {
    
    private static final double DESCUENTO_BAJO = 10.0;
    private static final double DESCUENTO_MEDIO = 15.0;
    private static final double DESCUENTO_ALTO = 25.0;
    
    private static final double MONTO_MINIMO_BAJO = 2000.0;
    private static final double MONTO_MINIMO_MEDIO = 5000.0;
    
    @Override
    public double calcularDescuento(double montoTotal) {
        if (montoTotal >= MONTO_MINIMO_MEDIO) {
            return DESCUENTO_ALTO;
        } else if (montoTotal >= MONTO_MINIMO_BAJO) {
            return DESCUENTO_MEDIO;
        }
        return DESCUENTO_BAJO;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Descuento Empresa: 10-25% escalonado por volumen";
    }
}
