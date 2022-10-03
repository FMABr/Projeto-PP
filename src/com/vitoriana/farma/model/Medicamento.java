package com.vitoriana.farma.model;

public class Medicamento extends Item {

	private MedicamentoCategoria mcategoria;
	private Prescricao prescricao;

	public Medicamento() {
		super(0);
	}

	public Medicamento(int id) {
		super(id);
	}

	public Medicamento(String nome, String localizacao, int quantidade, Fornecedor fornecedor, double preco,
			Funcionario estoquista, MedicamentoCategoria mcategoria, Prescricao prescricao) {
		super(0, nome, localizacao, quantidade, fornecedor, ItemCategoria.MEDICAMENTO, preco, estoquista);
		this.mcategoria = mcategoria;
		this.prescricao = prescricao;
	}

	public Medicamento(int id, String nome, String localizacao, int quantidade, Fornecedor fornecedor, double preco,
			Funcionario estoquista, MedicamentoCategoria mcategoria, Prescricao prescricao) {
		super(id, nome, localizacao, quantidade, fornecedor, ItemCategoria.MEDICAMENTO, preco, estoquista);
		this.mcategoria = mcategoria;
		this.prescricao = prescricao;
	}

	public MedicamentoCategoria getMcategoria() {
		return mcategoria;
	}

	public void setMcategoria(MedicamentoCategoria mcategoria) {
		this.mcategoria = mcategoria;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	public void mostrarMedicamento() {
		System.out.println("\n<Item>");
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + getNome());
		System.out.println("Localizacao: " + getLocalizacao());
		System.out.println("Quantidade: " + getQuantidade());
		System.out.println("Fornecedor: " + getFornecedor().getNome());
		System.out.println("Categoria: " + getCategoria());
		System.out.println("Estoquista: " + getEstoquista().getNome());
	}
}
