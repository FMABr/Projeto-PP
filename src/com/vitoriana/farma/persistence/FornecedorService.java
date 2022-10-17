package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import com.vitoriana.farma.model.Fornecedor;

public class FornecedorService implements EntidadeService<Fornecedor> {

    private SerializationService<Fornecedor> serializador = SerializationService.of(Fornecedor.class);

    public Fornecedor registrar(Fornecedor entidade) {
        Fornecedor registrado = serializador.serializar(entidade) ? entidade : null;

        return registrado;
    }

    @Override
    public Collection<Fornecedor> listar() {
        List<Fornecedor> fornecedores = serializador.desserializarTodos();

        return fornecedores;
    }

    @Override
    public Fornecedor atualizar(Fornecedor entidade) {
        Fornecedor atualizado = serializador.serializar(entidade) ? entidade : null;

        return atualizado;
    }

    @Override
    public Fornecedor buscar(int id) {
        Fornecedor fornecedor = serializador.desserializar(id);

        return fornecedor;
    }

    @Override
    public Fornecedor deletar(Fornecedor entidade) {
        Fornecedor deletado = null;

        try {
            if (serializador.remover(entidade))
                deletado = entidade;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return deletado;
    }

}
