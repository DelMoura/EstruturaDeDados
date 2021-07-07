package application;

import entities.ObjetoVetor;

public class MainVetor {
	public static void main(String[] args) {

		ObjetoVetor v = new ObjetoVetor(new int[10]);

		int numero = -1;

		while (numero != 0) {

			v.Menu(numero = v.Menu());
		}

	}

}
