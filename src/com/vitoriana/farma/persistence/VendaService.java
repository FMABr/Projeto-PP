package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;
import com.vitoriana.farma.model.Venda;

public class VendaService implements EntidadeService {

	private SerializationService<Venda> serializador = SerializationService.of(Venda.class);
	
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
