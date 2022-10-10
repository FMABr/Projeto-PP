package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.vitoriana.farma.model.Item;

public class ItemService implements EntidadeService<Item> {

	private SerializationService<Item> serializador = SerializationService.of(Item.class);

	public Item registrar(Item entidade) {
		Item registrado = serializador.serializar(entidade) ? entidade : null;
		
		return registrado;
	}

	@Override
	public Collection<Item> listar() {
		Item[] Items = serializador.desserializarTodos();
		
		return new ArrayList<>(Arrays.asList(Items));
	}

	@Override
	public Item atualizar(Item entidade) {
		Item atualizado = serializador.serializar(entidade) ? entidade : null;

		return atualizado;
	}

	@Override
	public Item buscar(int id) {
		Item Item = serializador.desserializar(id);

		return Item;
	}

	@Override
	public Item deletar(Item entidade) {
		Item deletado = null;
		try {
			if (serializador.remover(entidade))
				deletado = entidade;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return deletado;
	}

}
