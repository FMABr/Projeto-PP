package com.vitoriana.farma.gui.estoque;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelEstoque {

	private JPanel mainPanel;

	public PainelEstoque() {
		mainPanel = new JPanel();
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			PainelEstoque estoque = new PainelEstoque();
			frame.add(estoque.getMainPanel());
		});
	}
}
