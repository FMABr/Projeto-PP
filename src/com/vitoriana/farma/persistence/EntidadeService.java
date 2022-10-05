package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;

public interface EntidadeService<E extends Entidade> {
	public abstract E registrar(E entidade);
	public abstract Collection<E> listar();
	public abstract E atualizar(E entidade);
	public abstract E buscar(int id);
	public abstract E deletar(E entidade);
}
