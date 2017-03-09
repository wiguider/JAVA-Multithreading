package com.iguider.java.multithreading;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame implements ActionListener {
	private JPanel content = new JPanel();
	public Test() {
		exp02();
	}

	void exp01() {
		Processus p1 = new Processus("p01");
		Processus p2 = new Processus("p02");
		// Thread p1 = new Thread(p,"p01");
		p1.start();
		p2.start();

	}

	void exp02() {
		
		content.setLayout(null);
		content.setBackground(Color.black);
		getContentPane().add("Center",content);
		JButton b1= new JButton("New Penguin");
		getContentPane().add("South",b1);
		b1.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Pingouin p=new Pingouin();
		content.add(p);
		p.start();
		
	}

}
