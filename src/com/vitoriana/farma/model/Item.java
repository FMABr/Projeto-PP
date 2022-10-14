package com.vitoriana.farma.model;

public class Item extends Entidade {

	private static final long serialVersionUID = 5239308963818507111L;
	
    private String nome;
    private String localizacao;
    private int quantidade;
    private Fornecedor fornecedor;
    private ItemCategoria categoria;
    private double preco;
    private Funcionario estoquista;

	public Item() {
		super(0);
	}

	public Item(int id) {
		super(id);
	}

	public Item(String nome, String localizacao, int quantidade, Fornecedor fornecedor, ItemCategoria categoria,
			double preco, Funcionario estoquista) {
		super(0);
		this.nome = nome;
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.preco = preco;
		this.estoquista = estoquista;
	}

	public Item(int id, String nome, String localizacao, int quantidade, Fornecedor fornecedor, ItemCategoria categoria,
			double preco, Funcionario estoquista) {
		super(id);
		this.nome = nome;
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.preco = preco;
		this.estoquista = estoquista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ItemCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ItemCategoria categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Funcionario getEstoquista() {
		return estoquista;
	}

	public void setEstoquista(Funcionario estoquista) {
		this.estoquista = estoquista;
	}

	public String toString() {
		return nome;
	}

	public void mostrarItem() {
		System.out.println(this);
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + nome);
		System.out.println("Localizacao: " + localizacao);
		System.out.println("Quantidade: " + quantidade);
		System.out.println("Fornecedor: " + fornecedor.getNome());
		System.out.println("Categoria: " + categoria);
		System.out.println("Estoquista: " + estoquista.getNome());
	}
}
