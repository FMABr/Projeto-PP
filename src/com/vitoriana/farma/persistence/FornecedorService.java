package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Fornecedor;

public class FornecedorService implements EntidadeService<Fornecedor> {

	private SerializationService<Fornecedor> serializador = SerializationService.of(Fornecedor.class);

	@Override
	public Fornecedor registrar(Fornecedor entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Fornecedor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor atualizar(Fornecedor entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor deletar(Fornecedor entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
