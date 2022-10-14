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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Funcionario;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.model.ItemCategoria;

public class PainelEstoque {

    private JPanel mainPanel;
    private List<Item> tableData;
    private JTable itemTable;

    public PainelEstoque(/* List<Item> tableData */) {
        this.mainPanel = createMainPanel();
        this.tableData = new ArrayList<>();

        JPanel contentPanel = new JPanel(new BorderLayout());

//		JPanel titlePanel = new JPanel(new BorderLayout());
//		titlePanel.setMinimumSize(new Dimension(0, 30));
//		titlePanel.setPreferredSize(new Dimension(0, 40));

//		JLabel titleLabel = new JLabel("ITENS DO ESTOQUE", SwingConstants.CENTER);
//		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 18));
//		titlePanel.add(titleLabel, BorderLayout.CENTER);

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
        // Todos os textfields necessários para entrada, e também uma combobox para o tipo de item :D
        // JTextField nomeField = new JTextField(10);
        
        int result = JOptionPane.showConfirmDialog(mainPanel, modalPanel, "Cadastrar novo Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Item itemNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            // Pegar os valores de entrada do usuário dos textField e instanciar o item
            // itemNovo = new Item();
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
