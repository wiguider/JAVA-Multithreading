package com.iguider.java.multithreading;

import javax.swing.JPanel;

public class Processus extends JPanel implements Runnable {
	private Thread runner;
	public Processus(String name){
		runner =new Thread(this,name);
	}

	@Override
	public void run() {
		do {
			System.out.println(Thread.currentThread().getName());
		} while (true);

	}
	public void start(){
		runner.start();
	}

	public Thread getRunner() {
		return runner;
	}
}
