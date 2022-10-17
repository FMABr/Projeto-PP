package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import com.vitoriana.farma.model.Cliente;

public class ClienteService implements EntidadeService<Cliente> {

    private SerializationService<Cliente> serializador = SerializationService.of(Cliente.class);

    @Override
    public Cliente registrar(Cliente entidade) {
        Cliente registrado = serializador.serializar(entidade) ? entidade : null;

        return registrado;
    }

    @Override
    public Collection<Cliente> listar() {
        List<Cliente> clientes = serializador.desserializarTodos();

        return clientes;
    }

    @Override
    public Cliente atualizar(Cliente entidade) {
        Cliente atualizado = serializador.serializar(entidade) ? entidade : null;

        return atualizado;
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = serializador.desserializar(id);

        return cliente;
    }

    @Override
    public Cliente deletar(Cliente entidade) {
        Cliente deletado = null;
        try {
            if (serializador.remover(entidade))
                deletado = entidade;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return deletado;
    }

}
