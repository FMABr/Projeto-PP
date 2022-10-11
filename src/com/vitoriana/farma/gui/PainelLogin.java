package com.vitoriana.farma.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PainelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField login, senha;

	public PainelLogin() {
		super();
		setLayout(null);
		login = new JTextField();
		senha = new JTextField();
		login.setBounds(245, 120, 350, 30);
		senha.setBounds(245, 180, 350, 30);
		add(login);
		add(senha);
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(380, 240, 80, 60);
		add(entrar);
	}

	// public Funcionario getFuncionario() {
	// Funcionario login = controller.login(nome.getText(), senha.getText());
	// return new Funcionario();
	// }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 400);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.add(new PainelLogin());
		});
	}
}
