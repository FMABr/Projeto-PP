package com.vitoriana.farma.gui.estoque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;

import com.vitoriana.farma.controller.EstoqueController;
import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.model.ItemCategoria;

public class PainelEstoque {

	private JPanel mainPanel;
	private List<Item> tableData;
	private JTable itemTable;

	public PainelEstoque(EstoqueController controller) {
		this.mainPanel = createMainPanel();
		this.tableData = new ArrayList<>();

		JPanel contentPanel = new JPanel(new BorderLayout());

		JPanel actionPanel = createActionPanel();

		this.itemTable = new JTable(createEstoqueTableModel(tableData));
		JScrollPane tablePane = new JScrollPane(itemTable);

//		contentPanel.add(titlePanel, BorderLayout.NORTH);
		contentPanel.add(tablePane, BorderLayout.CENTER);
		contentPanel.add(actionPanel, BorderLayout.SOUTH);

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 15, 10, 15);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1d;
		c.weighty = 1d;

		this.mainPanel.add(createInternalFrame("ITENS DO ESTOQUE", contentPanel), c);
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);

		return panel;
	}

	private JPanel createActionPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 0));
		JButton buscarButton = new JButton("Pesquisar");
		JButton criarButton = new JButton("Cadastrar");
		JButton deletarButton = new JButton("Deletar");
		JButton atualizarButton = new JButton("Atualizar");

		buscarButton.addActionListener(e -> pesquisarItem());
		criarButton.addActionListener(e -> cadastrarNovoItem());
		deletarButton.addActionListener(e -> deletarItem(itemTable.getSelectedRow()));
		atualizarButton.addActionListener(e -> atualizarItem(itemTable.getSelectedRow()));

		buttonPanel.add(buscarButton);
		buttonPanel.add(criarButton);
		buttonPanel.add(atualizarButton);
		buttonPanel.add(deletarButton);

		panel.add(buttonPanel);
		panel.add(Box.createRigidArea(new Dimension(0, 1)));

		return panel;
	}

	private TableModel createEstoqueTableModel(List<Item> tableData) {
		TableModel model = new ItemTableModel(tableData);

		return model;
	}

	private JInternalFrame createInternalFrame(String title, Container contentPane) {
		JInternalFrame frame = new JInternalFrame(title, false, false, false, false);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.show();

		return frame;
	}

	private Item cadastrarItemModal() {
		JPanel modalPanel = new JPanel();
		JTextField nomeField = new JTextField(10);
		JTextField localField = new JTextField(10);
        JSpinner quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        JSpinner precoSpinner = new JSpinner(new SpinnerNumberModel(10d, 0.50d, 0d, 0.1d));
		JComboBox<String> categoriaCombo = new JComboBox<>(ItemCategoria.names());
		JComboBox<String> fornecedorCombo = new JComboBox<>(controller.getFornecedores());


		int result = JOptionPane.showConfirmDialog(mainPanel, modalPanel, "Cadastrar novo Item",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		Item itemNovo = null;
		if (result == JOptionPane.OK_OPTION) {
		    String nome = nomeField.getText();
		    String localizacao = localField.getText();
		    int quantidade = (int) quantidadeSpinner.getValue();
		    int preco = (int) precoSpinner.getValue();
		    ItemCategoria categoria = ItemCategoria.of(categoriaCombo.getSelectedItem().toString());
		    Fornecedor fornecedor = new For
		    
		    
			itemNovo = new Item(nome, localizacao, quantidade, fornecedor, categoria, preco, estoquista);
		}
		
		return itemNovo;
	}

	private void pesquisarItem() {

	}

	private void cadastrarNovoItem() {
		Item item = cadastrarItemModal();
		if (item != null) {
			this.tableData.add(item);
			// CHAMAR O CONTROLLER PARA PERSISTIR O ITEM AQUI
		}
	}

	private void deletarItem(int row) {

	}

	private void atualizarItem(int row) {

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
}
