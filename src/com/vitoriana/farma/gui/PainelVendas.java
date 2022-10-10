package com.vitoriana.farma.gui;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PainelVendas {
	static JPanel jp = new JPanel(new GridLayout(1,2));
	
	public PainelVendas() {
		JPanel esquerda = new JPanel();
		esquerda.setBackground(Color.GRAY);
		esquerda.setLayout(null);
		JPanel direita = new JPanel();
		direita.setLayout(null);
	//esquerda
		JTextField txt1 = new JTextField();
		esquerda.add(txt1);
		txt1.setBounds(50,50,200,30);
		
		JButton bt1 = new JButton("Buscar");
		esquerda.add(bt1);
		bt1.setBounds(250,49,75,35);
		bt1.setToolTipText("Busca por item");
		
		JTextField txt2 = new JTextField();
		esquerda.add(txt2);
		txt2.setBounds(20,200,200,22);
		txt2.setEditable(false);
		
		JTextField txt3 = new JTextField();
		esquerda.add(txt3);
		txt3.setBounds(20,225,200,22);
		txt3.setEditable(false);
		
		JTextField txt4 = new JTextField();
		esquerda.add(txt4);
		txt4.setBounds(20,250,200,22);
		txt4.setEditable(false);
		
		JButton btCmpr = new JButton("Comprar");
		esquerda.add(btCmpr);
		btCmpr.setBounds(240,477,135,80);
		
		JSpinner sp = new JSpinner(new SpinnerNumberModel(1,0,100,1));
		esquerda.add(sp);
		sp.setBounds(100, 477, 125, 80);
		
	//direita
		JButton btF = new JButton("Finalizar Compra");
		direita.add(btF);
		btF.setBounds(240,475,145,80);
		
		JTable tab2 = new JTable();
		JScrollPane tab = new JScrollPane(tab2);
		direita.add(tab);
		tab.setBackground(Color.black);
		tab.setBounds(45,30,300,300);
	
		
		JLabel l1 = new JLabel("quantidade:");
		direita.add(l1);
		l1.setBounds(30,380,80,20);
		JLabel l2 = new JLabel("valor total:");
		direita.add(l2);
		l2.setBounds(30,420,80,20);
		
		JTextField qntdItens = new JTextField();
		direita.add(qntdItens);
		qntdItens.setBounds(100,380,200,30);
		
		JTextField valorTotal = new JTextField();
		direita.add(valorTotal);
		valorTotal.setBounds(100,420,200,30);
	//finally
		jp.add(esquerda);
		jp.add(direita);
		
	//daqui pra baixo é teste	
		JFrame jf = new JFrame();
		jf.add(jp);
		jf.setSize(800, 600);
		jf.setVisible(true);
	}
	
	public JPanel mainPanel() {
		return jp;
	}
	
	public static void main(String args[]) {
		PainelVendas pv = new PainelVendas();
	}
}