package grafos;

import java.util.Scanner;


public class Grafo<T> {
	
	private Scanner scan = new Scanner(System.in);

	private T[] vertices;
	
	/*
	 * Contrutor, tendo como parametro o tamanho da lista (quantidade de vértices)
	 */
	public Grafo(int vertices)
	{
		this.vertices = (T[]) new Object[vertices];
	}
	
	/*
	 * Método percorre o vetor adicionando os vertices adjacentes em cada posição
	 */
	@SuppressWarnings("unchecked")
	public void adicionaAdjacentesLista()
	{
		System.out.println("Você criou uma lista de " + this.vertices.length + " vertices");
		
		for (int i = 0; i < this.vertices.length; i++)
		{
			var posicaoVertice = i + 1;
			System.out.print("Informe a quantidade de adjacentes do " + posicaoVertice + "º vértice");
			var adjacentes = scan.nextInt();
			
			var listaDeVertices = new ListaLigada<Object>();
			
			int cont = 0;
			while (cont <= adjacentes)
			{
				T vertice = null;
				if (cont == 0)
				{
					System.out.print("Esta primeira posição recebe o vertice em si: ");
					vertice = (T) scan.next();
				}
				else 
				{
					System.out.print("Informe o Vértice adjacente ao " + posicaoVertice + "º vértice: ");
					vertice = (T) scan.next();
				}
				
				listaDeVertices.adiciona(vertice);
				cont++;
			}
			
			this.vertices[i] = (T) listaDeVertices;
		}
		scan.close();
	}
	
	/*
	 * metodo percorre a lista exibindo em cada posiçao a lista ligada de Object
	 */
	public void print()
	{
		for (int i = 0; i < this.vertices.length; i++)
		{
			ListaLigada<?> list =  (ListaLigada<?>) this.vertices[i];
			print(list);
		}
	}
	
	private void print(ListaLigada<?> lista)
	{
		for (Object t : lista)
		{
			System.out.print(t + "-> ");
			
		}
		System.out.println();
	}
	
}
