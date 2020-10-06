package application;


import java.util.Scanner;

import grafos.Grafo;

public class Main {

	public static void main(String[] args) 
	{
		Scanner capture = new Scanner(System.in); 
		
		Grafo<String> grafo = new Grafo<String>(3);
		
		grafo.adicionaAdjacentesLista();
		
		System.out.println("\nExibindo Grafo e Adjacentes");
		grafo.print();
		
		System.out.print("\nInforme um vertice que deseja verificar os adjacentes: ");
		var vertice = capture.next();
		
		grafo.getAdjacentes(vertice);
	
	}

}
