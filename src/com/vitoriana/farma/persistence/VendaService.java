package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.vitoriana.farma.model.Venda;

public class VendaService implements EntidadeService<Venda> {

	private SerializationService<Venda> serializador = SerializationService.of(Venda.class);


	public Venda registrar(Venda entidade) {
		Venda registrado = serializador.serializar(entidade) ? entidade : null;
		
		return registrado;
	}

	@Override
	public Collection<Venda> listar() {
		Venda[] Vendas = serializador.desserializarTodos();
		
		return new ArrayList<>(Arrays.asList(Vendas));
	}

	@Override
	public Venda atualizar(Venda entidade) {
		Venda atualizado = serializador.serializar(entidade) ? entidade : null;

		return atualizado;
	}

	@Override
	public Venda buscar(int id) {
		Venda Venda = serializador.desserializar(id);

		return Venda;
	}

	@Override
	public Venda deletar(Venda entidade) {
		Venda deletado = null;
		
		try {
			if (serializador.remover(entidade))
				deletado = entidade;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return deletado;
	}

}
