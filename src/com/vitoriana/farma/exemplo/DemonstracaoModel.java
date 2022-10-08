package com.vitoriana.farma.exemplo;

import com.vitoriana.farma.model.*;
import java.time.LocalDateTime;

public class DemonstracaoModel {

	public static void main(String[] args) {
		Endereco endereco1 = new Endereco("123", "Alvorada", "Anjo", 3);

		Cliente cliente1 = new Cliente(12, "Asunder", "922", endereco1);

		Fornecedor fornecedor1 = new Fornecedor(11, "VANDERLEI DISTRIBUI��ES", "19922");
		Fornecedor fornecedor2 = new Fornecedor(18, "Genericos.Ltda", "131112");

		Funcionario funcionario1 = new Funcionario(14, "Jefferson", "14985", false, "Jeff011022");
		Funcionario funcionario2 = new Funcionario(25, "Luiz Henrique", "17736", true, "Mori27372");

		Item item1 = new Item(13, "Refrigerante Bob", "Setor das Geladeiras", 100, fornecedor1, ItemCategoria.ALIMENTO,
				5.00, funcionario1);

		Medicamento medicamento1 = new Medicamento("Ibrupofeno", "Farmacia", 120, fornecedor2, 7.85, funcionario2,
				MedicamentoCategoria.GENERICO, Prescricao.ISENTO);

		Venda venda1 = new Venda(17, LocalDateTime.of(22, 10, 02, 01, 42, 00), cliente1, funcionario1);
		venda1.inserirItem(item1);
		venda1.inserirItem(medicamento1);

		cliente1.mostrarCliente();
		fornecedor1.mostrarFornecedor();
		fornecedor2.mostrarFornecedor();
		funcionario1.mostrarFuncionario();
		funcionario2.mostrarFuncionario();
		item1.mostrarItem();
		medicamento1.mostrarMedicamento();
		venda1.mostrarVenda();

	}

}
