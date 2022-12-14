package com.vitoriana.farma.model;

public class Funcionario extends Entidade {

	private static final long serialVersionUID = 2997191113890560251L;
	
	private String nome;
	private String matricula;
	private boolean administrador;
	private String senha;

	public Funcionario() {
		super();
	}

	public Funcionario(int id) {
		super(id);
	}

	public Funcionario(String nome, String matricula, boolean administrador, String senha) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.administrador = administrador;
		this.senha = senha;
	}

	public Funcionario(int id, String nome, String matricula, boolean administrador, String senha) {
		super(id);
		this.nome = nome;
		this.matricula = matricula;
		this.administrador = administrador;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void mostrarFuncionario() {
		System.out.println(this);
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + nome);
		System.out.println("Matricula: " + matricula);
		System.out.println("Administrador: " + (administrador ? "Sim" : "Não"));
	}
}
