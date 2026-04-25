package service;

/**
 * Interfaz que define la estrategia para calcular descuentos.
 * Implementa el patrón Strategy para diferentes tipos de descuentos.
 */
public interface IDescuentoStrategy {
    
    /**
     * Calcula el descuento aplicable a un monto.
     * 
     * @param montoTotal El monto total antes del descuento
     * @return El porcentaje de descuento a aplicar (0-100)
     */
    double calcularDescuento(double montoTotal);
    
    /**
     * Obtiene la descripción del tipo de descuento.
     * 
     * @return Descripción del descuento
     */
    String obtenerDescripcion();
}
