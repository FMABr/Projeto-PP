package com.vitoriana.farma.persistence;

import java.util.Collection;

import com.vitoriana.farma.model.Entidade;

public interface EntidadeService {
	public abstract Entidade registrar(Entidade entidade);
	public abstract Collection<Entidade> listar(Entidade entidade);
	public abstract Entidade atualizar(Entidade entidade);
	public abstract Entidade buscar(Entidade entidade);
	public abstract Entidade deletar(Entidade entidade);
}
