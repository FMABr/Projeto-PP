package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Funcionario;

public class FuncionarioService implements EntidadeService<Funcionario> {

	private SerializationService<Funcionario> serializador = SerializationService.of(Funcionario.class);

	@Override
	public Funcionario registrar(Funcionario entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario atualizar(Funcionario entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario deletar(Funcionario entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
