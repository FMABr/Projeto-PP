package com.vitoriana.farma.model;

public class Cliente extends Entidade {
	private String nome;
	private String cpf;
	private Endereco endereco;

	public Cliente() {
		super(0);
	}

	public Cliente(int id) {
		super(id);
	}

	public Cliente(String nome, String cpf, Endereco endereco) {
		super(0);
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Cliente(int id, String nome, String cpf, Endereco endereco) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void mostrarCliente() {
		System.out.println("\n<Cliente>");
		System.out.println("Nome: " + nome);
		System.out.println("Cpf: " + cpf);
		System.out.println("ID: " + getId());
		endereco.mostrarEndereco();
	}
}
