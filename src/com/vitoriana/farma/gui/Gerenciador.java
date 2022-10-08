package com.vitoriana.farma.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Gerenciador {
	JPanel cards;
	final static String inicio = "CardInicio";
	final static String estoque = "CardA";
	final static String pdv = "CardB";
	final static String funcionarios = "CardC";

	public Gerenciador() {		
		JFrame frame = new JFrame("Projeto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setResizable(false);
	
		JToolBar tb = new JToolBar();
		JButton btnVoltar = new JButton("Voltar");
		tb.setLayout(null);
		tb.add(btnVoltar);
		btnVoltar.setBounds(720, 0, 80, 60);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, inicio);
			}
		});  
		frame.add(tb);
		tb.setBounds(0,0,800,60);
		
		JPanel card1 = new JPanel();
		card1.setLayout(null);
		int posHor = 130;
		int posVer = 160;
		int tamV = 100;
		int tamH = 150;
		JButton bt1 = new JButton("Estoque");
		bt1.setBounds(posHor,posVer,tamH,tamV);
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, estoque);
			}
		});
		bt1.setToolTipText("Abre o controle do estoque");
		card1.add(bt1);
		
		JButton bt2 = new JButton("Vendas");
		bt2.setBounds(posHor+tamH+50,posVer,tamH,tamV);
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, pdv);
			}
		});
		bt2.setToolTipText("Acessa o ponto de vendas");
		card1.add(bt2);
		
		JButton bt3 = new JButton("Funcionarios");
		bt3.setBounds(posHor+tamH*2+100,posVer,tamH,tamV);
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, funcionarios);
			}
		});
		bt3.setToolTipText("Gerenciar funcionarios");
		card1.add(bt3);

		//simula outras telas, ainda vamos ver como vamos integrar no controller
		JPanel card2 = new JPanel();
		card2.setBackground(Color.BLACK);

		
		JPanel card3 = new JPanel();
		card3.setBackground(Color.BLUE);
		
		JPanel card4 = new JPanel();
		card4.setBackground(Color.RED);

		cards = new JPanel(new CardLayout());
		cards.add(card1, inicio);
		cards.add(card2, estoque);
		cards.add(card3, pdv);
		cards.add(card4, funcionarios);

		frame.add(cards);
		cards.setBounds(0,60,800,520);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				var g = new Gerenciador();
			}
		});
	}
}
