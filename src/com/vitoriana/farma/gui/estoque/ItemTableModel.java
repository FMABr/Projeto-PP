package com.vitoriana.farma.gui.estoque;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.vitoriana.farma.model.Item;

public class ItemTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	protected List<Item> tableData;
	protected String[] colunas;

	public ItemTableModel(List<Item> tableData) {
		this.tableData = tableData;
		this.colunas = new String[]{ "Nome", "Categoria", "Preço", "Quantidade" };
	}
	
	public ItemTableModel(List<Item> tableData, String... colunas) {
		this.tableData = Collections.synchronizedList(tableData);		
		this.colunas = colunas;
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
		String coluna = colunas[columnIndex];

		
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
