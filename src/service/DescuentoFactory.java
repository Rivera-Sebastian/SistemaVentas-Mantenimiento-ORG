package service;

/**
 * Factory para crear instancias de estrategias de descuento.
 * Implementa el patrón Factory para evitar condicionales directas
 * en el código de negocio.
 */
public class DescuentoFactory {
    
    public enum TipoCliente {
        VIP,
        NORMAL,
        EMPRESA,
        ESTUDIANTE
    }
    
    /**
     * Crea una estrategia de descuento según el tipo de cliente.
     * 
     * @param tipoCliente El tipo de cliente
     * @return Una instancia de IDescuentoStrategy apropiada
     * @throws IllegalArgumentException si el tipo de cliente no es válido
     */
    public static IDescuentoStrategy crearDescuento(TipoCliente tipoCliente) {
        switch (tipoCliente) {
            case VIP:
                return new DescuentoVIP();
            case NORMAL:
                return new DescuentoNormal();
            case EMPRESA:
                return new DescuentoEmpresa();
            case ESTUDIANTE:
                return new DescuentoEstudiante();
            default:
                throw new IllegalArgumentException("Tipo de cliente no válido: " + tipoCliente);
        }
    }
    
    /**
     * Crea una estrategia de descuento según una cadena de texto.
     * Útil para conversiones desde bases de datos o entrada de usuario.
     * 
     * @param tipo El tipo como cadena (VIP, NORMAL, EMPRESA, ESTUDIANTE)
     * @return Una instancia de IDescuentoStrategy apropiada
     * @throws IllegalArgumentException si el tipo no es válido
     */
    public static IDescuentoStrategy crearDescuento(String tipo) {
        try {
            return crearDescuento(TipoCliente.valueOf(tipo.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de cliente no válido: " + tipo);
        }
    }
}
