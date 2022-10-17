package com.vitoriana.farma.gui.funcionarios;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.vitoriana.farma.model.Funcionario;

public class FuncionarioModal {

    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField matriculaField;
    private JComboBox<String> cargoCombo;

    public FuncionarioModal() {
        nomeField = new JTextField(10);
        matriculaField = new JTextField(10);

        cargoCombo = new JComboBox<>(new String[] { "Gerente", "Funcionario" });

        mainPanel = createMainPanel();
    }

    public FuncionarioModal(Funcionario funcionario) {
        this();

        nomeField.setText(funcionario.getNome());
        matriculaField.setText(funcionario.getMatricula());
        cargoCombo.setSelectedIndex(funcionario.isAdministrador() ? 0 : 1);
    }

    public FuncionarioModal(Funcionario item, boolean editavel) {
        this(item);

        nomeField.setEditable(editavel);
        matriculaField.setEditable(editavel);
        cargoCombo.setEnabled(editavel);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel nomeLabel = new JLabel("Nome: ");
        JLabel matriculaLabel = new JLabel("Matricula: ");
        JLabel cargoLabel = new JLabel("Cargo: ");
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(matriculaLabel);
        panel.add(matriculaField);
        panel.add(cargoLabel);
        panel.add(cargoCombo);

        return panel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Funcionario getFuncionario() {
        String nome = nomeField.getText();
        String matricula = matriculaField.getText();
        boolean administrador = cargoCombo.getSelectedIndex() == 0;

        return new Funcionario(nome, matricula, administrador, "");
    }
}
