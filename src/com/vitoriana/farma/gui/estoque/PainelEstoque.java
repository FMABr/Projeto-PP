package com.vitoriana.farma.gui.estoque;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelEstoque {

	private JPanel mainPanel;

	public PainelEstoque() {
		mainPanel = new JPanel();

		JTable table = new JTable(new ItemTableModel(new ArrayList<>(20)));
		JScrollPane tablePane = new JScrollPane(table);

		mainPanel.add(tablePane);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
}
