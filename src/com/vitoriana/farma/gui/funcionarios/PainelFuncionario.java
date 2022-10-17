package com.vitoriana.farma.gui.funcionarios;

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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.vitoriana.farma.controller.FuncionarioController;
import com.vitoriana.farma.model.Funcionario;

public class PainelFuncionario {

    private FuncionarioController controller;

    private JPanel mainPanel;
    private JTable funcionarioTable;
    private FuncionarioTableModel tableModel;
    private JButton limparButton;

    public PainelFuncionario(FuncionarioController controller) {
        this.mainPanel = createMainPanel();
        this.controller = controller;

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        this.tableModel = createFuncionarioTableModel(this.controller.getFuncionarios());
        this.funcionarioTable = new JTable(tableModel);
        this.funcionarioTable.setAutoCreateRowSorter(true);
        JScrollPane tablePane = new JScrollPane(funcionarioTable);

        contentPanel.add(tablePane, BorderLayout.CENTER);
        contentPanel.add(actionPanel, BorderLayout.SOUTH);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 15, 10, 15);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1d;
        c.weighty = 1d;

        this.mainPanel.add(createInternalFrame("GERENCIAR FUNCIONARIOS", contentPanel), c);
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

        buscarButton.addActionListener(e -> pesquisarFuncionario());
        limparButton.addActionListener(e -> setFilter(null));
        criarButton.addActionListener(e -> cadastrarNovoFuncionario());
        deletarButton.addActionListener(e -> deletarFuncionario(funcionarioTable.getSelectedRow()));
        atualizarButton.addActionListener(e -> atualizarFuncionario(funcionarioTable.getSelectedRow()));

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

    private FuncionarioTableModel createFuncionarioTableModel(List<Funcionario> tableData) {
        FuncionarioTableModel model = new FuncionarioTableModel(tableData);

        return model;
    }

    private JInternalFrame createInternalFrame(String title, Container contentPane) {
        JInternalFrame frame = new JInternalFrame(title, false, false, false, false);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.show();

        return frame;
    }

    private Funcionario cadastrarFuncionarioModal() {
        FuncionarioModal modal = new FuncionarioModal();

        int result = JOptionPane.showConfirmDialog(mainPanel, modal.getMainPanel(), "Cadastrar novo Funcionario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Funcionario funcionarioNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            funcionarioNovo = modal.getFuncionario();
        }

        return funcionarioNovo;
    }

    private Funcionario atualizarFuncionarioModal(Funcionario funcionario) {
        FuncionarioModal modal = new FuncionarioModal(funcionario);

        int result = JOptionPane.showConfirmDialog(mainPanel, modal.getMainPanel(), "Atualizar Funcionario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Funcionario itemNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            itemNovo = modal.getFuncionario();
        }

        return itemNovo;
    }

    private void pesquisarFuncionarioModal() {
        FuncionarioModal modal = new FuncionarioModal();

        int result = JOptionPane.showConfirmDialog(mainPanel, modal.getMainPanel(), "Atualizar Funcionario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        Funcionario itemNovo = null;
        if (result == JOptionPane.OK_OPTION) {
            itemNovo = modal.getFuncionario();
            setFilter(tableModel.filtrar(itemNovo.getNome(), itemNovo.getMatricula(), itemNovo.isAdministrador()));
        }

    }

    private void setFilter(RowFilter<FuncionarioTableModel, Integer> filter) {
        TableRowSorter<FuncionarioTableModel> sorter = new TableRowSorter<>(tableModel);
        sorter.setRowFilter(filter);
        funcionarioTable.setRowSorter(sorter);

        limparButton.setEnabled(filter != null);
    }

    private void pesquisarFuncionario() {
        pesquisarFuncionarioModal();
        tableModel.refresh();
    }

    private void cadastrarNovoFuncionario() {
        Funcionario funcionario = cadastrarFuncionarioModal();

        if (funcionario != null) {
            if (controller.cadastrarFuncionario(funcionario)) {
                JOptionPane.showMessageDialog(mainPanel, "Funcionario cadastrado com sucesso");
                tableModel.refresh();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Falha ao cadastrar o Funcionario");
            }
        }

    }

    private void deletarFuncionario(int row) {
        int modelIndex = funcionarioTable.convertRowIndexToModel(row);
        controller.removerFuncionario(modelIndex, tableModel.getRowData(modelIndex));
        tableModel.refresh();
    }

    private void atualizarFuncionario(int row) {
        int modelIndex = funcionarioTable.convertRowIndexToModel(row);
        Funcionario antigo = tableModel.getRowData(modelIndex);

        Funcionario item = atualizarFuncionarioModal(antigo);
        if (item != null) {
            item.setId(antigo.getId());

            if (controller.atualizarFuncionario(modelIndex, item)) {
                JOptionPane.showMessageDialog(mainPanel, "Funcionario atualizado com sucesso");
                tableModel.refresh();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Falha ao atualizar o Funcionario");
            }
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
