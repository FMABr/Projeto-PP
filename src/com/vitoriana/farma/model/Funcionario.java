package com.vitoriana.farma.model;

public class Funcionario extends Entidade {
	private String nome;
	private String matricula;
	private boolean administrador;
	private String senha;

	public Funcionario() {
		super(0);
	}

	public Funcionario(int id) {
		super(id);
	}

	public Funcionario(String nome, String matricula, boolean administrador, String senha) {
		super(0);
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
		if (isAdministrador == true) {
			System.out.println("\n<Funcionario>");
			System.out.println("ID: " + getId());
			System.out.println("Nome: " + nome);
			System.out.println("Matricula: " + matricula);
			System.out.println("Administrador: Sim");
			System.out.println("Senha: " + senha);
		} else {
			System.out.println("\n<Funcionario>");
			System.out.println("ID: " + getId());
			System.out.println("Nome: " + nome);
			System.out.println("Matricula: " + matricula);
			System.out.println("Administrador: N�o");
			System.out.println("Senha: " + senha);
		}
	}
}
