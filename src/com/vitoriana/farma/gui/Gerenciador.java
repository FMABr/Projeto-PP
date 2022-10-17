package com.vitoriana.farma.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Gerenciador {

    private JPanel mainPanel;
    private JPanel cards;

    private JPanel estoquePanel;
    private JPanel vendasPanel;
    private JPanel funcionariosPanel;

    public static final String MENU = "MENU";
    public static final String ESTOQUE = "ESTOQUE";
    public static final String VENDAS = "PDV";
    public static final String FUNCIONARIOS = "FUNCIONARIOS";

    public Gerenciador() {
        mainPanel = new JPanel(new BorderLayout());
        cards = new JPanel(new CardLayout());

        mainPanel.add(createToolbar(), BorderLayout.NORTH);
        mainPanel.add(cards, BorderLayout.CENTER);

        JPanel menu = new JPanel(new GridLayout(1, 3));
        cards.add(menu, MENU);

        JButton buttonEstoque = createMenuButton("Estoque", "Abre o controle do estoque", ESTOQUE);
        JButton buttonVendas = createMenuButton("Vendas", "Acessa o ponto de vendas", VENDAS);
        JButton buttonFuncionarios = createMenuButton("Funcionarios", "Gerenciar funcionarios", FUNCIONARIOS);

        menu.add(buttonEstoque);
        menu.add(buttonVendas);
        menu.add(buttonFuncionarios);
    }

    private JButton createMenuButton(String value, String tooltip, String card) {
        JButton button = new JButton(value);
        button.setToolTipText(tooltip);
        button.addActionListener(e -> this.showCard(card));

        return button;
    }

    private JToolBar createToolbar() {
        JButton buttonVoltar = createMenuButton("Voltar", null, MENU);
        JToolBar toolbar = new JToolBar();
        toolbar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        toolbar.setFloatable(false);
        toolbar.add(buttonVoltar);

        return toolbar;
    }

    public void setEstoquePanel(JPanel estoquePanel) {
        if (this.estoquePanel != null) {
            cards.remove(this.estoquePanel);
        }

        if (estoquePanel != null) {
            this.estoquePanel = estoquePanel;
            cards.add(this.estoquePanel, ESTOQUE);
        }
    }

    public void setVendasPanel(JPanel vendasPanel) {
        if (this.vendasPanel != null && vendasPanel != null) {
            cards.remove(this.vendasPanel);
        }

        if (vendasPanel != null) {
            this.vendasPanel = vendasPanel;
            cards.add(this.vendasPanel, VENDAS);
        }
    }

    public void setFuncionariosPanel(JPanel funcionariosPanel) {
        if (this.funcionariosPanel != null && funcionariosPanel != null) {
            cards.remove(this.funcionariosPanel);
        }

        if (funcionariosPanel != null) {
            this.funcionariosPanel = funcionariosPanel;
            cards.add(this.funcionariosPanel, FUNCIONARIOS);
        }
    }

    public void showCard(String card) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, card);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
