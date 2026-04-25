package service;

/**
 * Servicio para gestionar y aplicar descuentos.
 * Utiliza el patrón Strategy a través del Factory para
 * calcular descuentos sin condicionales complejos.
 */
public class DescuentoService {
    
    /**
     * Calcula el monto del descuento para un cliente.
     * 
     * @param tipoCliente El tipo de cliente
     * @param montoTotal El monto total de la compra
     * @return El monto del descuento en soles
     */
    public double calcularMontoDescuento(DescuentoFactory.TipoCliente tipoCliente, double montoTotal) {
        IDescuentoStrategy estrategia = DescuentoFactory.crearDescuento(tipoCliente);
        double porcentaje = estrategia.calcularDescuento(montoTotal);
        return (montoTotal * porcentaje) / 100.0;
    }
    
    /**
     * Calcula el monto del descuento para un cliente usando string.
     * 
     * @param tipoCliente El tipo de cliente como cadena
     * @param montoTotal El monto total de la compra
     * @return El monto del descuento en soles
     */
    public double calcularMontoDescuento(String tipoCliente, double montoTotal) {
        return calcularMontoDescuento(DescuentoFactory.TipoCliente.valueOf(tipoCliente.toUpperCase()), montoTotal);
    }
    
    /**
     * Calcula el monto final después de aplicar el descuento.
     * 
     * @param tipoCliente El tipo de cliente
     * @param montoTotal El monto total de la compra
     * @return El monto final con descuento aplicado
     */
    public double calcularMontoFinal(DescuentoFactory.TipoCliente tipoCliente, double montoTotal) {
        double descuento = calcularMontoDescuento(tipoCliente, montoTotal);
        return montoTotal - descuento;
    }
    
    /**
     * Obtiene el porcentaje de descuento para un cliente.
     * 
     * @param tipoCliente El tipo de cliente
     * @param montoTotal El monto total de la compra
     * @return El porcentaje de descuento
     */
    public double obtenerPorcentajeDescuento(DescuentoFactory.TipoCliente tipoCliente, double montoTotal) {
        IDescuentoStrategy estrategia = DescuentoFactory.crearDescuento(tipoCliente);
        return estrategia.calcularDescuento(montoTotal);
    }
    
    /**
     * Obtiene la descripción del tipo de descuento aplicable.
     * 
     * @param tipoCliente El tipo de cliente
     * @return Descripción del descuento
     */
    public String obtenerDescripcionDescuento(DescuentoFactory.TipoCliente tipoCliente) {
        IDescuentoStrategy estrategia = DescuentoFactory.crearDescuento(tipoCliente);
        return estrategia.obtenerDescripcion();
    }
    
    /**
     * Obtiene un resumen detallado del descuento aplicable.
     * 
     * @param tipoCliente El tipo de cliente
     * @param montoTotal El monto total de la compra
     * @return Resumen con descripción, porcentaje y monto del descuento
     */
    public String obtenerResumenDescuento(DescuentoFactory.TipoCliente tipoCliente, double montoTotal) {
        IDescuentoStrategy estrategia = DescuentoFactory.crearDescuento(tipoCliente);
        double porcentaje = estrategia.calcularDescuento(montoTotal);
        double monto = (montoTotal * porcentaje) / 100.0;
        
        return String.format(
            "%s%nPorcentaje: %.2f%%%nMonto descuento: S/ %.2f%nMonto final: S/ %.2f",
            estrategia.obtenerDescripcion(),
            porcentaje,
            monto,
            montoTotal - monto
        );
    }
}
