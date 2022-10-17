package com.vitoriana.farma.gui.estoque;

import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.vitoriana.farma.model.Fornecedor;
import com.vitoriana.farma.model.Funcionario;
import com.vitoriana.farma.model.Item;
import com.vitoriana.farma.model.ItemCategoria;

public class ItemModal {

    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField localField;
    private JSpinner quantidadeSpinner;
    private JSpinner precoSpinner;
    private JComboBox<String> fornecedorCombo;
    private JComboBox<String> categoriaCombo;

    private List<Fornecedor> fornecedores;

    public ItemModal(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
        String[] fornecedorNomes = fornecedores.stream().map(f -> f.getNome())
                .toArray(size -> new String[fornecedores.size()]);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        nomeField = new JTextField(10);
        localField = new JTextField(10);

        quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        precoSpinner = new JSpinner(new SpinnerNumberModel(0.50d, 0.50d, 1000d, 0.1d));

        fornecedorCombo = new JComboBox<>(fornecedorNomes);
        categoriaCombo = new JComboBox<>(ItemCategoria.names());

        fornecedorCombo.setEditable(true);

        mainPanel.add(createTopPanel());
        mainPanel.add(createMiddlePanel());
        mainPanel.add(createBottomPanel());
    }

    public ItemModal(Item item, List<Fornecedor> fornecedores) {
        this(fornecedores);

        nomeField.setText(item.getNome());
        localField.setText(item.getLocalizacao());
        quantidadeSpinner.setValue(item.getQuantidade());
        precoSpinner.setValue(Math.round(item.getPreco() * 2) / 2.0d);
        fornecedorCombo.getEditor().setItem(item.getFornecedor().getNome());
        categoriaCombo.setSelectedItem(item.getCategoria());

        Stream.of(ItemCategoria.names()).filter(c -> c.equals(item.getCategoria().name()))
                .forEach(c -> categoriaCombo.setSelectedItem(c));

        fornecedores.stream().filter(f -> f.getNome().equals(item.getFornecedor().getNome()))
                .forEach(f -> fornecedorCombo.setSelectedItem(f.getNome()));
    }

    public ItemModal(Item item, List<Fornecedor> fornecedores, boolean editavel) {
        this(item, fornecedores);

        nomeField.setEditable(editavel);
        localField.setEditable(editavel);
        quantidadeSpinner.setEnabled(editavel);
        precoSpinner.setEnabled(editavel);
        fornecedorCombo.setEnabled(editavel);
        categoriaCombo.setEnabled(editavel);

    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel nomeLabel = new JLabel("Nome: ");
        JLabel localLabel = new JLabel("Local: ");
        JLabel fornecedorLabel = new JLabel("Fornecedor: ");
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(localLabel);
        panel.add(localField);
        panel.add(fornecedorLabel);
        panel.add(fornecedorCombo);

        return panel;
    }

    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));

        JPanel quantidadePanel = new JPanel();
        JLabel quantidadeLabel = new JLabel("Qtd: ");
        quantidadePanel.add(quantidadeLabel);
        quantidadePanel.add(quantidadeSpinner);

        JPanel precoPanel = new JPanel();
        JLabel precoLabel = new JLabel("Preço: ");
        precoPanel.add(precoLabel);
        precoPanel.add(precoSpinner);

        panel.add(quantidadePanel);
        panel.add(precoPanel);

        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        JLabel categoriaLabel = new JLabel("Categoria: ");
        panel.add(categoriaLabel);
        panel.add(categoriaCombo);

        return panel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Item getItem() {
        String nome = nomeField.getText();
        String localizacao = localField.getText();
        int quantidade = (int) quantidadeSpinner.getValue();
        double preco = (double) precoSpinner.getValue();
        ItemCategoria categoria = ItemCategoria.of(categoriaCombo.getSelectedItem().toString());
        String fornecedorNome = fornecedorCombo.getSelectedItem().toString();
        Fornecedor fornecedor = fornecedores.stream().filter(f -> f.getNome().equals(fornecedorNome)).findFirst()
                .orElse(new Fornecedor(fornecedorNome));
        Funcionario estoquista = null;

        return new Item(nome, localizacao, quantidade, fornecedor, categoria, preco, estoquista);
    }
}
