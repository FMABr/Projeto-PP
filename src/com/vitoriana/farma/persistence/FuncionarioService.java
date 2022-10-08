package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.vitoriana.farma.model.Funcionario;

public class FuncionarioService implements EntidadeService<Funcionario> {

	private SerializationService<Funcionario> serializador = SerializationService.of(Funcionario.class);

	@Override
	public Funcionario registrar(Funcionario entidade) {
		Funcionario registrado = serializador.serializar(entidade) ? entidade : null;
		
		return registrado;
	}

	@Override
	public Collection<Funcionario> listar() {
		Funcionario[] funcionario = serializador.desserializarTodos();
		
		return new ArrayList<>(Arrays.asList(funcionario));
	}

	@Override
	public Funcionario atualizar(Funcionario entidade) {
		Funcionario atualizado = serializador.serializar(entidade) ? entidade : null;

		return atualizado;
	}

	@Override
	public Funcionario buscar(int id) {
		Funcionario funcionario = serializador.desserializar(id);

		return funcionario;
	}

	@Override
	public Funcionario deletar(Funcionario entidade) {
		Funcionario deletado = null;
		try {
			if (serializador.remover(entidade))
				deletado = entidade;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return deletado;
	}

}
