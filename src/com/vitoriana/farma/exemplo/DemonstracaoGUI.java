package com.vitoriana.farma.exemplo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.vitoriana.farma.gui.Gerenciador;
import com.vitoriana.farma.gui.PainelVendas;
import com.vitoriana.farma.gui.estoque.PainelEstoque;

public class DemonstracaoGUI {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 700);
			frame.setResizable(false);
			frame.setVisible(true);

			Gerenciador gerenciadorGUI = new Gerenciador();
			PainelEstoque estoqueGUI = new PainelEstoque();
			PainelVendas vendasGUI = new PainelVendas();
			
			gerenciadorGUI.setEstoquePanel(estoqueGUI.getMainPanel());
			gerenciadorGUI.setVendasPanel(vendasGUI.getMainPanel());
			
			frame.add(gerenciadorGUI.getMainPanel());
		});
	}
}
