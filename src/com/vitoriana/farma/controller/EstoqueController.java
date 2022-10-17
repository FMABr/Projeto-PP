package com.vitoriana.farma.controller;

import java.util.List;

import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.persistence.FornecedorService;
import com.vitoriana.farma.persistence.ItemService;

public class EstoqueController {

    private List<Item> estoque;
    private List<Fornecedor> fornecedores;

    private ItemService itemService;
    private FornecedorService fornecedorService;

    public EstoqueController() {
        this.itemService = new ItemService();
        this.fornecedorService = new FornecedorService();

        this.estoque = (List<Item>) itemService.listar();
        this.fornecedores = (List<Fornecedor>) fornecedorService.listar();
    }

    public boolean cadastrarItem(Item item) {
        Item cadastrado = itemService.registrar(item);

        if (cadastrado == null)
            return false;

        this.estoque.add(cadastrado);

        return true;
    }

    public boolean listarItens() {
        this.estoque = (List<Item>) itemService.listar();

        return true;
    }

    public boolean atualizarItem(int index, Item item) {
        Item atualizado = itemService.atualizar(item);

        if (atualizado == null)
            return false;

        this.estoque.set(index, atualizado);

        return true;
    }

    public boolean removerItem(int index, Item item) {
        Item removido = itemService.deletar(item);

        if (removido == null)
            return false;

        this.estoque.remove(index);

        return true;
    }

    public boolean cadastrarFornecedor(Fornecedor fornecedor) {
        Fornecedor cadastrado = fornecedorService.registrar(fornecedor);

        if (cadastrado == null)
            return false;

        this.fornecedores.add(cadastrado);
        
        return true;
    }

    public boolean listarFornecedores() {
        this.fornecedores = (List<Fornecedor>) fornecedorService.listar();
        
        return true;
    }

    public boolean atualizarFornecedor(int index, Fornecedor fornecedor) {
        Fornecedor atualizado = fornecedorService.atualizar(fornecedor);
        
        if (atualizado == null)
            return false;
        
        this.fornecedores.set(index, atualizado);
        
        return true;
    }

    public boolean removerFornecedor(int index, Fornecedor fornecedor) {
        Fornecedor removido = fornecedorService.deletar(fornecedor);

        if (removido == null)
            return false;

        this.fornecedores.remove(index);
        
        return true;
    }
    
    public List<Item> getEstoque() {
        return estoque;
    }
    
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
}
