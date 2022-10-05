package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
		Cliente[] clientes = serializador.desserializarTodos();
		
		return new ArrayList<>(Arrays.asList(clientes));
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
