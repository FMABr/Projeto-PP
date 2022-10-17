package com.vitoriana.farma.gui.vendas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.vitoriana.farma.model.Item;

public class PainelVendas {

	JPanel mainPanel;
	List<Item> itens;
	Map<Integer, Integer> quantidades;

	public PainelVendas() {
		mainPanel = new JPanel(new BorderLayout());
		itens = Collections.synchronizedList(new ArrayList<>(20));
		quantidades = Collections.synchronizedMap(new HashMap<>(20));

		JLayeredPane layeredPane = createDesktopPane();

		mainPanel.add(layeredPane);

		JInternalFrame carrinhoFrame = createInternalFrame("Carrinho", createCarrinhoPanel(itens, quantidades));
		JInternalFrame estoqueFrame = createInternalFrame("Estoque", createEstoquePanel());

		try {
			carrinhoFrame.setIcon(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		layeredPane.add(estoqueFrame);
		layeredPane.add(carrinhoFrame);
	}

	private JInternalFrame createInternalFrame(String title, Container contentPane) {
		JInternalFrame frame = new JInternalFrame(title, true, false, false, true);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocation(10, 10);
		frame.show();

		return frame;
	}

	private JDesktopPane createDesktopPane() {
		JDesktopPane panel = new JDesktopPane();

		// Override dragFrame para evitar que o usuário mova o icone do JInternalFrame
		// minimizado
		panel.setDesktopManager(new DefaultDesktopManager() {
			private static final long serialVersionUID = 1L;

			@Override
			public void dragFrame(JComponent f, int newX, int newY) {
				if (!(f instanceof JInternalFrame.JDesktopIcon)) {
					super.dragFrame(f, newX, newY);
				}
			}
		});

		return panel;
	}

	private JPanel createEstoquePanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JPanel top = new JPanel();
		JPanel center = new JPanel();
		JPanel bottom = new JPanel();

		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		center.setLayout(new GridLayout(0, 1));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));

		panel.add(top, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		panel.add(bottom, BorderLayout.SOUTH);

		JLabel searchLabel = new JLabel("Item: ");
		JTextField searchField = new JTextField(20);
		JButton searchButton = new JButton("Buscar");

		top.add(searchLabel);
		top.add(searchField);
		top.add(searchButton);

		JTextField txt2 = new JTextField();
		center.add(txt2);
		txt2.setEditable(false);

		JTextField txt3 = new JTextField();
		center.add(txt3);
		txt3.setEditable(false);

		JTextField txt4 = new JTextField();
		center.add(txt4);
		txt4.setEditable(false);

		JSpinner quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
		JButton adicionarButton = new JButton("Adicionar ao Carrinho");
		adicionarButton.addActionListener(e -> buscarItem(txt2.getText()));

		bottom.add(quantidadeSpinner);
		bottom.add(adicionarButton);

		return panel;
	}

	private JPanel createCarrinhoPanel(List<Item> itens, Map<Integer, Integer> quantidades) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel itensPanel = new JPanel(new BorderLayout());
		JPanel itensInfoPanel = new JPanel(new GridLayout(2, 1));

		JTable itensTable = new JTable(new CarrinhoTableModel(itens, quantidades));
		JScrollPane itensTableScrollPane = new JScrollPane(itensTable);

		JPanel itensQtdPanel = new JPanel();
		JLabel itensQtdLabel = new JLabel("Itens: ");
		JTextField itensQtdField = new JTextField();
		itensQtdField.setEditable(false);

		itensQtdPanel.setLayout(new BoxLayout(itensQtdPanel, BoxLayout.LINE_AXIS));
		itensQtdPanel.add(itensQtdLabel);
		itensQtdPanel.add(itensQtdField);

		JPanel itensCustoPanel = new JPanel();
		JLabel itensCustoLabel = new JLabel("Custo total: ");
		JTextField itensCustoField = new JTextField();
		itensCustoField.setEditable(false);

		itensCustoPanel.setLayout(new BoxLayout(itensCustoPanel, BoxLayout.LINE_AXIS));
		itensCustoPanel.add(itensCustoLabel);
		itensCustoPanel.add(itensCustoField);

		itensInfoPanel.add(itensQtdPanel);
		itensInfoPanel.add(itensCustoPanel);

		itensPanel.add(itensTableScrollPane, BorderLayout.CENTER);
		itensPanel.add(itensInfoPanel, BorderLayout.SOUTH);

		panel.add(new Box.Filler(new Dimension(0, 5), new Dimension(0, 20), new Dimension(0, 30)));
		panel.add(itensPanel);
		panel.add(new Box.Filler(new Dimension(0, 5), new Dimension(0, 5), new Dimension(0, 20)));

		JButton comprarButton = new JButton("Finalizar Compra");
		comprarButton.addActionListener(e -> fecharVenda());
		panel.add(comprarButton);

		return panel;
	}

	private void buscarItem(String nome) {
	    
	}
	
	private void fecharVenda() {
		// Registrar uma venda nova
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
}