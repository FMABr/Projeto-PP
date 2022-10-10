package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.vitoriana.farma.model.Fornecedor;

public class FornecedorService implements EntidadeService<Fornecedor> {

	private SerializationService<Fornecedor> serializador = SerializationService.of(Fornecedor.class);

	public Fornecedor registrar(Fornecedor entidade) {
		Fornecedor registrado = serializador.serializar(entidade) ? entidade : null;
		
		return registrado;
	}

	@Override
	public Collection<Fornecedor> listar() {
		Fornecedor[] Fornecedors = serializador.desserializarTodos();
		
		return new ArrayList<>(Arrays.asList(Fornecedors));
	}

	@Override
	public Fornecedor atualizar(Fornecedor entidade) {
		Fornecedor atualizado = serializador.serializar(entidade) ? entidade : null;

		return atualizado;
	}

	@Override
	public Fornecedor buscar(int id) {
		Fornecedor Fornecedor = serializador.desserializar(id);

		return Fornecedor;
	}

	@Override
	public Fornecedor deletar(Fornecedor entidade) {
		Fornecedor deletado = null;
		
		try {
			if (serializador.remover(entidade))
				deletado = entidade;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return deletado;
	}

}
