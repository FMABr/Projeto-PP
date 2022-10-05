package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Cliente;
import com.vitoriana.farma.model.Entidade;

public class ClienteService implements EntidadeService {

	private SerializationService<Cliente> serializador = SerializationService.of(Cliente.class);
	
	@Override
	public Entidade registrar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Entidade> listar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade atualizar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade buscar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade deletar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
