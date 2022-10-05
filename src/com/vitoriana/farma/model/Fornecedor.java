package com.vitoriana.farma.model;

public class Fornecedor extends Entidade {

	private static final long serialVersionUID = 830421036236131546L;
	
	private String nome;
	private String contato;

	public Fornecedor() {
		super(0);
	}

	public Fornecedor(int id) {
		super(id);
	}

	public Fornecedor(String nome, String contato) {
		super(0);
		this.nome = nome;
		this.contato = contato;
	}

	public Fornecedor(int id, String nome, String contato) {
		super(id);
		this.nome = nome;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void mostrarFornecedor() {
		System.out.println(this);
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + nome);
		System.out.println("Contato: " + contato);
	}
}
