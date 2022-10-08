package com.vitoriana.farma.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelLogin extends JPanel{
	private JTextField login, senha;
	public PainelLogin() {
		super();
		setBackground(Color.BLACK);
		setLayout(null);
	    login = new JTextField();
		senha = new JTextField();
		login.setBounds(245,120,350,30);
		senha.setBounds(245,180,350,30);
		add(login);
		add(senha);
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(380,240,80,60);
		add(entrar);
	}
	
	//public Funcionario getFuncionario() {
		// Funcionario login = controller.login(nome.getText(), senha.getText());
	//	return new Funcionario();
	//}
}
