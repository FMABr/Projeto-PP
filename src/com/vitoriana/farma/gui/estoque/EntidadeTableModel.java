package com.vitoriana.farma.gui.estoque;

import javax.swing.table.AbstractTableModel;

import com.vitoriana.farma.model.Entidade;

public class EntidadeTableModel<E extends Entidade> extends AbstractTableModel {

	// private HashTa ble<int, E> 
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
}
