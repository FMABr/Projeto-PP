package com.vitoriana.farma;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.vitoriana.farma.controller.EstoqueController;
import com.vitoriana.farma.controller.FuncionarioController;
import com.vitoriana.farma.controller.VendasController;
import com.vitoriana.farma.gui.Gerenciador;
import com.vitoriana.farma.gui.estoque.PainelEstoque;
import com.vitoriana.farma.gui.funcionarios.PainelFuncionario;
import com.vitoriana.farma.gui.vendas.PainelVendas;

public class Main {

    public static void main(String[] args) {
        EstoqueController estoque = new EstoqueController();
        VendasController pdv = new VendasController();
        FuncionarioController funcionarios = new FuncionarioController();

        Gerenciador gerenciadorGUI = new Gerenciador();
        PainelEstoque estoqueGUI = new PainelEstoque(estoque);
        PainelVendas vendasGUI = new PainelVendas();
        PainelFuncionario funcionariosGUI = new PainelFuncionario(funcionarios);

        gerenciadorGUI.setEstoquePanel(estoqueGUI.getMainPanel());
        gerenciadorGUI.setVendasPanel(vendasGUI.getMainPanel());
        gerenciadorGUI.setFuncionariosPanel(funcionariosGUI.getMainPanel());

        startGUI(gerenciadorGUI.getMainPanel());
    }

    public static void startGUI(JComponent gui) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(gui);
            frame.setSize(1000, 1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
