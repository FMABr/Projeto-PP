package com.vitoriana.farma.gui.estoque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.vitoriana.farma.controller.EstoqueController;
import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.model.ItemCategoria;

public class PainelEstoque {

    private EstoqueController controller;

    private JPanel mainPanel;
    private JTable itemTable;
    private ItemTableModel tableModel;
    private JButton limparButton;

    public PainelEstoque(EstoqueController controller) {
        this.mainPanel = createMainPanel();
        this.controller = controller;

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        this.tableModel = createEstoqueTableModel(this.controller.getEstoque());
        this.itemTable = new JTable(tableModel);
        this.itemTable.setAutoCreateRowSorter(true);
        JScrollPane tablePane = new JScrollPane(itemTable);

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
        JPanel filtrosPanel = new JPanel(new GridLayout(1, 2, 2, 0));

        JButton buscarButton = new JButton("Filtrar");
        limparButton = new JButton("Limpar");
        JButton criarButton = new JButton("Cadastrar");
        JButton deletarButton = new JButton("Deletar");
        JButton atualizarButton = new JButton("Atualizar");

        buscarButton.addActionListener(e -> pesquisarItem());
        limparButton.addActionListener(e -> setFilter(null));
        criarButton.addActionListener(e -> cadastrarNovoItem());
        deletarButton.addActionListener(e -> deletarItem(itemTable.getSelectedRow()));
        atualizarButton.addActionListener(e -> atualizarItem(itemTable.getSelectedRow()));

        limparButton.setEnabled(false);

        filtrosPanel.add(buscarButton);
        filtrosPanel.add(limparButton);

        buttonPanel.add(filtrosPanel);
        buttonPanel.add(criarButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(deletarButton);

        panel.add(buttonPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 1)));

        return panel;
    }

    private ItemTableModel createEstoqueTableModel(List<Item> tableData) {
        ItemTableModel model = new ItemTableModel(tableData);

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
        ItemModal modal = new ItemModal(this.controller.getFornecedores());

        int result = JOptionPane.showConfirmDialog(mainPanel, modal.getMainPanel(), "Cadastrar novo Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Item itemNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            itemNovo = modal.getItem();
        }

        return itemNovo;
    }

    private Item atualizarItemModal(Item item) {
        ItemModal modal = new ItemModal(item, this.controller.getFornecedores());

        int result = JOptionPane.showConfirmDialog(mainPanel, modal.getMainPanel(), "Atualizar Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Item itemNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            itemNovo = modal.getItem();
        }

        return itemNovo;
    }

    private void pesquisarItemModal() {
        List<Fornecedor> fornecedores = this.controller.getFornecedores();
        String[] fornecedorNomes = fornecedores.stream().map(f -> f.getNome())
                .toArray(size -> new String[fornecedores.size()]);

        String[] categoriaNomes = { "", null, null, null, null };
        System.arraycopy(ItemCategoria.names(), 0, categoriaNomes, 1, 4);

        JPanel modalPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel nomeLabel = new JLabel("Nome: ");
        JLabel localLabel = new JLabel("Local: ");
        JLabel fornecedorLabel = new JLabel("Fornecedor: ");
        JLabel categoriaLabel = new JLabel("Categoria: ");

        JTextField nomeField = new JTextField(10);
        JTextField localField = new JTextField(10);
        JComboBox<String> fornecedorCombo = new JComboBox<>(fornecedorNomes);
        JComboBox<String> categoriaCombo = new JComboBox<>(categoriaNomes);

        fornecedorCombo.setEditable(true);

        modalPanel.add(nomeLabel);
        modalPanel.add(nomeField);
        modalPanel.add(localLabel);
        modalPanel.add(localField);
        modalPanel.add(fornecedorLabel);
        modalPanel.add(fornecedorCombo);
        modalPanel.add(categoriaLabel);
        modalPanel.add(categoriaCombo);

        int result = JOptionPane.showConfirmDialog(mainPanel, modalPanel, "Filtrar Itens", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String localizacao = localField.getText();
            String fornecedor = (String) fornecedorCombo.getSelectedItem();
            
            if (categoriaCombo.getSelectedIndex() != 0) {
                ItemCategoria categoria = ItemCategoria.of(categoriaCombo.getSelectedItem().toString());                
                setFilter(tableModel.filtrar(nome, localizacao, fornecedor, categoria));
            } else {
                setFilter(tableModel.filtrar(nome, localizacao, fornecedor));
            }

        }

    }

    private void setFilter(RowFilter<ItemTableModel, Integer> filter) {
        TableRowSorter<ItemTableModel> sorter = new TableRowSorter<>(tableModel);
        sorter.setRowFilter(filter);
        itemTable.setRowSorter(sorter);

        limparButton.setEnabled(filter != null);
    }

    private void pesquisarItem() {
        pesquisarItemModal();
        tableModel.refresh();
    }

    private void cadastrarNovoItem() {
        Item item = cadastrarItemModal();

        if (item != null) {
            if (controller.cadastrarItem(item)) {
                controller.cadastrarFornecedor(item.getFornecedor());
                JOptionPane.showMessageDialog(mainPanel, "Item cadastrado com sucesso");
                tableModel.refresh();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Falha ao cadastrar o item");
            }
        }

    }

    private void deletarItem(int row) {
        int modelIndex = itemTable.convertRowIndexToModel(row);
        controller.removerItem(modelIndex, tableModel.getRowData(modelIndex));
        tableModel.refresh();
    }

    private void atualizarItem(int row) {
        int modelIndex = itemTable.convertRowIndexToModel(row);
        Item antigo = tableModel.getRowData(modelIndex);

        Item item = atualizarItemModal(antigo);
        if (item != null) {
            item.setId(antigo.getId());

            if (controller.atualizarItem(modelIndex, item)) {
                JOptionPane.showMessageDialog(mainPanel, "Item atualizado com sucesso");
                tableModel.refresh();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Falha ao atualizar o item");
            }
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
