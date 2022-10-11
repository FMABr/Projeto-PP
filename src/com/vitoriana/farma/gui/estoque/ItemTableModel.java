package com.vitoriana.farma.gui.estoque;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.vitoriana.farma.model.Item;

public class ItemTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Item> tableData;
	private String[] colunas;

	public ItemTableModel(List<Item> tableData) {
		this.tableData = Collections.synchronizedList(tableData);
		this.colunas = new String[]{ "Nome", "Categoria", "Preço", "Quantidade" };
	}

	@Override
	public int getRowCount() {
		return tableData.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item linha = tableData.get(rowIndex);

		Object value = null;

		switch (columnIndex) {
		case 0:
			value = linha.getNome();
		case 1:
			value = linha.getCategoria();
		case 2:
			value = linha.getPreco();
		case 3:
			value = linha.getQuantidade();
		}

		return value;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	public List<Item> getTableData() {
		return tableData;
	}
}
