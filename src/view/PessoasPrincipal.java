package view;

import java.util.concurrent.Semaphore;

import controller.PessoasController;

public class PessoasPrincipal {
	public static void main (String[] args) {
		
		Semaphore porta = new Semaphore(1);
		
		for (int i = 0; i < 4; i++) {
			PessoasController pesCon = new PessoasController(porta);
			pesCon.start();
		}
		
	}
}
