package application;


import grafos.Grafo;

public class Main {

	public static void main(String[] args) 
	{

		Grafo<String> grafo = new Grafo<String>(3);
		
		grafo.adicionaAdjacentesLista();
		
		System.out.println("\nExibindo Grafo e Adjacentes");
		grafo.print();
		
	}

}
