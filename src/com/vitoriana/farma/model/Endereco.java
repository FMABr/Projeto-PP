package com.vitoriana.farma.model;

import java.io.Serializable;

public class Endereco implements Serializable {
	
	private static final long serialVersionUID = -7873021416773021966L;
	
	private String cep;
	private String bairro;
	private String rua;
	private String complemento;
	private int numero;

	public Endereco() {
	}

	public Endereco(String cep, String bairro, String rua, String complemento, int numero) {
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Endereco(String cep, String bairro, String rua, int numero) {
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		complemento = null;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void mostrarEndereco() {
		System.out.println("Cep: " + cep);
		System.out.println("Bairro: " + bairro);
		System.out.println("Rua: " + rua);
		System.out.println("Complemento: " + complemento);
		System.out.println("Numero: " + numero);
	}
}
