package com.iguider.java.multithreading;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Pingouin extends JPanel implements Runnable {
	private Thread runner;
	private String src[] = { "stop.gif", "left1.gif", "left2.gif", "left3.gif",
			"right1.gif", "right2.gif", "right3.gif" };
	private Image film[];
	private int current = 1;

	int x = 300, y = 100, step = 3;

	private static int cp = 0;

	@Override
	public void run() {
		do{
			int decision = (int) (Math.random() * 100);
			if(decision<40) goLeft();
			else if(decision<80) goRight();
			else stop();
		
		} while (true);
	}

	private void goLeft() {
		for (int i = 1; i < 3; i++) {
			current = i;
			x = x - step;
			setLocation(x, y);
			repaint();
			pause(100);
		}

	}

	private void stop() {
		current = 0;
		repaint();
		pause(100);

	}

	private void goRight() {
		for (int i = 4; i < 6; i++) {
			current = i;
			x = x + step;
			setLocation(x, y);
			repaint();
			pause(100);
		}
	}

	private void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void start() {
		runner.start();
	}

	public Pingouin() {
		cp++;
		runner = new Thread(this, "Pingouin" + cp);
		setSize(30, 30);
		y = cp * 30;
		setLocation(x, y);
		loadImages();
	}

	private void loadImages() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		film = new Image[src.length];
		for (int i = 0; i < film.length; i++) {
			film[i] = toolkit.getImage("ressources/" + src[i]);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * g.setColor(Color.blue); g.fillRect(0, 0, 30, 30);
		 * g.setColor(Color.red); g.drawLine(0, 0, 20, 20);
		 */
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// for (int i = 0; i < src.length; i++) {
		//
		// g.drawImage(toolkit.getImage("ressources/" + src[i]), 0, 0, this);
		//

		g.drawImage(film[current], 0, 0, null);

	}

}
