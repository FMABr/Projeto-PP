package com.vitoriana.farma.gui.vendas;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.vitoriana.farma.gui.estoque.ItemTableModel;
import com.vitoriana.farma.model.Item;

public class CarrinhoTableModel extends ItemTableModel {

	private static final long serialVersionUID = 1L;

	private Map<Integer, Integer> quantidadeItens;

	public CarrinhoTableModel(List<Item> tableData, Map<Integer, Integer> quantidadeItens) {
		super(tableData, "Nome", "Categoria", "Preço", "Quantidade");

		this.quantidadeItens = Collections.synchronizedMap(quantidadeItens);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item linha = tableData.get(rowIndex);
		String coluna = colunas[columnIndex];

		if (coluna.equalsIgnoreCase("Quantidade")) {
			return quantidadeItens.get(linha.getId());
		}

		Field value;
		try {
			value = linha.getClass().getField(coluna);
		} catch (NoSuchFieldException e) {
			value = null;
			System.err.println("Coluna não existe: " + coluna);
			System.err.println(e.getLocalizedMessage());
		}

		return value;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return colunas[columnIndex].equalsIgnoreCase("Quantidade");
	}
}
