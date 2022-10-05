package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;
import com.vitoriana.farma.model.Venda;

public class VendaService implements EntidadeService<Venda> {

	private SerializationService<Venda> serializador = SerializationService.of(Venda.class);

	@Override
	public Venda registrar(Venda entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Venda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda atualizar(Venda entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda deletar(Venda entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
