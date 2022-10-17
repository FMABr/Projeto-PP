package com.vitoriana.farma.model;

public class Fornecedor extends Entidade {

    private static final long serialVersionUID = 830421036236131546L;

    private String nome;

    public Fornecedor() {
        super();
    }

    public Fornecedor(int id) {
        super(id);
    }

    public Fornecedor(String nome) {
        super();
        this.nome = nome;
    }

    public Fornecedor(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrarFornecedor() {
        System.out.println(this);
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + nome);
    }
}
