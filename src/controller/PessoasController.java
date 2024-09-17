package controller;

import java.util.concurrent.Semaphore;

public class PessoasController extends Thread{
	
	Semaphore porta;
	int velocidade;
	int corredor = 200;
	int iD = (int)threadId();
	
	public PessoasController(Semaphore porta) {
		this.porta = porta;
	}
	
	@Override
	public void run() {
		
		caminhada();
		
	}

	private void caminhada() {
		
		for (int i = 0; i < corredor; i = i + (int)((Math.random() * 3) + 4)) {
			System.out.println("Pessoa #" + iD + " já andou " + i + " metros do corredor.");
		}
		System.out.println("Pessoa #" + iD + " chegou ao final do corredor.");
		try {
			porta.acquire();
			sleep((long)(Math.random() * 1001) + 1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Pessoa #" + iD + " passou pela porta.");
			porta.release();
		}
	}
	
}
