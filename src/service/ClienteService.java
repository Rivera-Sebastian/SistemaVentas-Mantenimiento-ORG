package service;

import model.Cliente;
import repository.IClienteRepository;
import util.Console;
import util.Validaciones;

public class ClienteService {

    private IClienteRepository clienteRepo;

    public ClienteService(IClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public void registrarCliente(String dni, String nombre, String tipo) {

        if (!Validaciones.validarDni(dni)) {
            Console.error("DNI inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
        Console.info("Cambio2 de rama 1: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
