package service;

/**
 * Estrategia de descuento para clientes estudiantes.
 * Aplica un descuento especial fijo.
 */
public class DescuentoEstudiante implements IDescuentoStrategy {
    
    private static final double DESCUENTO_ESTUDIANTE = 8.0;
    
    @Override
    public double calcularDescuento(double montoTotal) {
        return DESCUENTO_ESTUDIANTE;
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Descuento Estudiante: 8% descuento fijo";
    }
}
