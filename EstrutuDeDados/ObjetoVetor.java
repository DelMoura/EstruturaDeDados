package entities;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ObjetoVetor {

	public int vetor[];
	public int totalValidos;

	public ObjetoVetor(int[] vetor, int totalValidos) {
		this.vetor = vetor;
		this.totalValidos = totalValidos;
	}

	public ObjetoVetor(int[] vetor) {

		this.vetor = vetor;
	}

	// atribui valores pseudo-randômicos a todos os elementos do vetor
	public void povoaVetor() {
		Random numerosRandom = new Random();

		for (int i = 0; i < this.vetor.length; i++) {
			this.vetor[i] = numerosRandom.nextInt(30);

		}

	}

// atribui em ordem crescente, valores pseudo-randômicos a todos os elementos do vetor!
	public void povoaVetorSequencial(int vetor[]) {
		Random numerosRandom = new Random();
		int a = numerosRandom.nextInt(30);
		int b = numerosRandom.nextInt(30);
		int aux;

		for (int i = 0; i < vetor.length; i++) {
			aux = a;
			a = a + b;
			b = aux;

			vetor[i] = a;

		}

	}

// atribui um valor a um elemento do vetor
	public void atribuiValor(int vetor[]) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Qual elemento você deseja inserir: ");
		System.out.print("DIGITE: ");
		int elemento = teclado.nextInt();

		if (vetor[elemento - 1] == 0) {
			System.out.println("Qual valor você deseja inserir: ");
			System.out.print("DIGITE: ");
			int valor = teclado.nextInt();

			vetor[elemento - 1] = valor;
		} else {
			System.out.println("Elemento já ocupado!");
		}
	}

// informa o valor existente em determinado elemento do vetor 
	public int retornaValor(int vetor[], int elemento) {

		if (elemento <= vetor.length) {

			System.out.println(
					"O valor dentro do elemento " + elemento + " contém" + vetor.toString().indexOf(elemento - 1));

		} else {
			System.out.println("Elemento não encontrado!");
		}

		return vetor.toString().indexOf(elemento - 1);

	}

// informa o "length" do vetor
	public void informaTamanho() {
		System.out.println("O tamanho do vetor é: " + this.vetor.length);

	}

//informa quantos dos elementos do vetor possuem valor válido (diferente do valor referência para vazio)
	public int informaQuantosOcupados(int vetor[]) {
		int soma = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != 0) {
				soma++;

			}

		}

		System.out.println("São " + soma + " vetores ocupados!");

		return soma;

	}

//insere um valor no próximo elemento livre do vetor - de acordo com alguma estratégia adotada pelo programador (pode fazer uso do método atribuiValor)
	public void adicionaValor(int vetor[]) {
		System.out.println();
		System.out.println("Qual valor você deseja inserir!: ");
		System.out.print("DIGITE: ");
		Scanner teclado = new Scanner(System.in);
		int valor = 0;
		int numero = teclado.nextInt();
		for (int i = 0; i < vetor.length; i++) {

			if (vetor[valor] == 0) {

				vetor[valor] = numero;

				break;
			} else {
				valor++;

			}

			if (valor == vetor.length) {
				System.out.println("Não há elemento para inserir tal valor!");
				break;
			}

		}

	}

//remove um valor (atribuindo o valor referência para vazio) em um determinado elemento do vetor
	public void removeValor(int vetor[]) {
		Scanner teclado = new Scanner(System.in);

		int indice = teclado.nextInt();

		if (vetor[indice] != 0) {
			vetor[indice] = 0;

		} else {
			System.out.println();
			System.out.println("Essa posição já está vazia" + vetor[indice]);

		}

	}

//remove um valor informado (atribuindo o valor referência para vazio), caso ele exista no vetor
	public void removeValor1(int vetor[]) {
		int valor = buscaSequencial(vetor);

		if (valor != 0) {
			vetor[valor] = 0;
			System.out.println("Valor apagado!");
		} else {
			System.out.println("Valor não encontrado!");
		}

	}

//informa o menor valor válido armazenado no vetor;
	public void menorValor(int vetor[]) {
		int menor = vetor[0];
		int elemento = 0;
		int index = informaQuantosOcupados(vetor);

		for (int i = 1; i < index; i++) {
			if (menor > vetor[i] && vetor[i] != 0) {
				menor = vetor[i];
				elemento = i;

			}

		}

		System.out.println("O menor número, do elemento " + elemento + ", é: " + menor);

	}

//maiorValor : informa o maior valor válido armazenado no vetor;	
	public void maiorValor(int vetor[]) {
		int maior = 0;
		int elemento = 0;

		for (int i = 0; i < vetor.length - 1; i++) {
			if (vetor[1 + i] > vetor[i]) {
				maior = vetor[1 + i];
				elemento = 1 + i;

			}

		}

		System.out.println("O maior número, do elemento " + elemento + " é: " + maior);

	}

	public int buscaSequencial(int vetor[]) {
		Scanner teclado = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite qual valor você busca:");
		System.out.print("DIGITE: ");
		int valor = teclado.nextInt();
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == valor) {
				return i;

			}

		}
		return 0;

	}

	public int buscaBinaria(int vetor[]) {
		Scanner teclado = new Scanner(System.in);
		System.out.println();
		System.out.println("Insira qual valor você busca");
		System.out.print("DIGITE: ");
		int valor = teclado.nextInt();
		return Busca(vetor, valor, 0, vetor.length - 1);

	}

	private int Busca(int[] vetor, int elemento, int menor, int maior) {
		int media = (menor + maior) / 2;

		if (menor > maior) {
			System.out.println("Não foi encontrado o elemento! :( Por favor, tente outro.");
			return -1;
		}
		if (vetor[media] == elemento) {
			System.out.println("Valor: " + elemento + ", foi encontrado no elemento: " + (media + 1)
					+ " <= :D de maneira recursiva binária.");
			return media;

		}
		if (vetor[media] < elemento) {
			return Busca(vetor, elemento, media + 1, maior);

		} else {
			return Busca(vetor, elemento, menor, media - 1);

		}
	}

	public static void ordenaBubble(int v[]) {
		for (int last = v.length - 1; last > 0; last--) {
			for (int i = 0; i < last; i++) {
				if (v[i] > v[i + 1]) {

					trocarBubble(v, i, i + 1);
				}

			}

		}

	}

	private static void trocarBubble(int v[], int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;

	}

	public void ordenaInsert(int[] v) {
		int x, j;
		for (int i = 1; i < v.length; i++) {
			x = v[i];
			j = i - 1;

			while ((j >= 0) && v[j] > x) {
				v[j + 1] = v[j];
				j -= 1;
			}
			v[j + 1] = x;

		}

	}

	public void ordenaSelect(int[] v) {
		for (int i = 0; i < v.length; i++) {
			int menor = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[menor]) {
					menor = j;
				}
			}
			trocar(v, i, menor);

		}

	}

	private void trocar(int[] v, int i, int menor) {
		int aux = v[i];
		v[i] = v[menor];
		v[menor] = aux;

	}

	public int Menu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println();
		System.out.println("=======================MENU DO PROGRAMA===============================================");
		System.out.println("Aperte (1) Povoar o vetor com números pseudo-randômicos. ");
		System.out.println("Aperte (2) Povoar o vetor com números em ordem crescente. ");
		System.out.println("Aperte (3) Informar o total de elementos válidos. ");
		System.out.println("Aperte (4) Informar o maior e o menor valores. ");
		System.out.println("Aperte (5) Listar todo o conteúdo do vetor. ");
		System.out.println("Aperte (6) Para adicionar um valor entre os elementos disponíveis.");
		System.out.println();
		System.out.println("====================INSERIR OU APAGAR VALORES=========================================");
		System.out.println("Aperte (11) Inserir um valor no vetor em uma determinada posição. ");
		System.out.println("Aperte (12) Apagar um valor do vetor, informando o valor a ser removido. ");
		System.out.println("Aperte (13) Apagar um valor do vetor, informando a posição do valor a ser removido.");
		System.out.println();
		System.out.println("===========================CONSULTA===================================================");
		System.out.println("Aperte (21) Consultar a existência de um valor no vetor, utilizando busca sequencial.");
		System.out.println("Aperte (22) Consultar a existência de um valor no vetor, utilizando busca binária.");
		System.out.println();
		System.out.println("==========================ORDENAÇÃO====================================================");
		System.out.println("Aperte (31) Ordenar o vetor, utilizando o método Bubblesort");
		System.out.println("Aperte (32) Ordenar o vetor, utilizando o método Insertsort");
		System.out.println("Aperte (33) Ordenar o vetor, utilizando o método Selectionsort");
		System.out.print("DIGITE:  ");
		int numero = teclado.nextInt();

		return numero;

	}

	public void Menu(int x) {
		switch (x) {
		case 1:
			povoaVetor();
			break;
		case 2:
			povoaVetorSequencial(this.vetor);
			break;
		case 3:
			informaQuantosOcupados(this.vetor);
			break;
		case 4:
			menorValor(this.vetor);
			maiorValor(this.vetor);
			break;
		case 5:
			listarVetor(this.vetor);
			break;
		case 6:
			adicionaValor(this.vetor);
			break;
		case 11:
			atribuiValor(this.vetor);
			break;
		case 12:
			removeValor1(this.vetor);
			break;
		case 13:
			removeValor(this.vetor);
			break;
		case 21:
			int valor = buscaSequencial(this.vetor);
			if (valor != 0) {
				System.out.println();
				System.out.println("O valor " + this.vetor[valor] + ", foi encontrado no elemento: " + (valor + 1)
						+ " <= :D de maneira sequencial.");

			} else {
				System.out.println();
				System.out.println("Valor não encontrado!");
			}
			break;
		case 22:
			buscaBinaria(this.vetor);
			break;
		case 31:
			ordenaBubble(this.vetor);
			break;
		case 32:
			ordenaInsert(this.vetor);
			break;
		case 33:
			ordenaSelect(this.vetor);
			break;

		}

	}

	public static void listarVetor(int vetor[]) {
		System.out.println("");
		int i = 0;
		for (int v : vetor) {
			i++;
			System.out.println("Elemento " + i + " contém valor: " + v);

		}

	}

}
