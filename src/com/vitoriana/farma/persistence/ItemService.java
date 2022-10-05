package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;
import com.vitoriana.farma.model.Item;

public class ItemService implements EntidadeService<Item> {

	private SerializationService<Item> serializador = SerializationService.of(Item.class);

	@Override
	public Item registrar(Item entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Item> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item atualizar(Item entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item deletar(Item entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
