package com.vitoriana.farma.model;

import java.time.LocalDateTime;
import java.util.ArrayList;;

public class Venda extends Entidade {

	private static final long serialVersionUID = 2290765111126281137L;
	
	private LocalDateTime dataHora;
	private ArrayList<Item> produtos;
	private double precoTotal;
	private Cliente cliente;
	private Funcionario funcionario;

	public Venda() {
		super(0);
	}

	public Venda(int id) {
		super(id);
	}

	public Venda(LocalDateTime dataHora, Cliente cliente, Funcionario funcionario) {
		super(0);
		this.dataHora = dataHora;
		this.produtos = new ArrayList<Item>();
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Venda(int id, LocalDateTime dataHora, Cliente cliente, Funcionario funcionario) {
		super(id);
		this.dataHora = dataHora;
		this.produtos = new ArrayList<Item>();
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public ArrayList<Item> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Item> produtos) {
		this.produtos = produtos;
	}

	public void inserirItem(Item item) {
		produtos.add(item);
	}

	public double getPrecototal() {
		precoTotal = 0.0;
		for (Item item : produtos) {
			precoTotal += item.getPreco();
		}
		return precoTotal;
	}

	public void setPrecototal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void mostrarVenda() {
		System.out.println(this);
		System.out.println("ID: " + getId());
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Data da Compra: " + dataHora);
		System.out.println("Lista de Itens: " + produtos.toString());
		System.out.println("Valor Total: " + getPrecototal() + " R$");
		System.out.println("Responsavel da Venda: " + funcionario.getNome());
	}
}
