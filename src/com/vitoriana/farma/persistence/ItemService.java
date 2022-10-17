package com.vitoriana.farma.persistence;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import com.vitoriana.farma.model.Item;

public class ItemService implements EntidadeService<Item> {

    private SerializationService<Item> serializador = SerializationService.of(Item.class);

    public Item registrar(Item entidade) {
        Item registrado = serializador.serializar(entidade) ? entidade : null;

        return registrado;
    }

    @Override
    public Collection<Item> listar() {
        List<Item> items = serializador.desserializarTodos();

        return items;
    }

    @Override
    public Item atualizar(Item entidade) {
        Item atualizado = serializador.serializar(entidade) ? entidade : null;

        return atualizado;
    }

    @Override
    public Item buscar(int id) {
        Item item = serializador.desserializar(id);

        return item;
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
