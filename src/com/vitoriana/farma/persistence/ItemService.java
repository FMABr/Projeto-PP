package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;
import com.vitoriana.farma.model.Item;

public class ItemService implements EntidadeService {

	private SerializationService<Item> serializador = SerializationService.of(Item.class);
	
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
