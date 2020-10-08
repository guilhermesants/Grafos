package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grafo<T> {
	
	private Scanner scan = new Scanner(System.in);

	private T[] vertices;
	
	/*
	 * Contrutor, tendo como parametro o tamanho da lista (quantidade de vï¿½rtices)
	 */
	public Grafo(int vertices)
	{
		this.vertices = (T[]) new Object[vertices];
	}
	
	/*
	 * Mï¿½todo percorre o vetor adicionando os vertices adjacentes em cada posiï¿½ï¿½o
	 */
	@SuppressWarnings("unchecked")
	public void adicionaAdjacentesLista()
	{
		System.out.println("Você criou uma lista de " + this.vertices.length + " vértices");
		
		for (int i = 0; i < this.vertices.length; i++)
		{
			var posicaoVertice = i + 1;
			System.out.print("Informe a quantidade de adjacentes do " + posicaoVertice + "º vértice: ");
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
					System.out.print("Informe o vértice adjacente ao " + posicaoVertice + "º vértice: ");
					vertice = (T) scan.next();
				}
				
				listaDeVertices.adiciona(vertice);
				cont++;
			}
			
			this.vertices[i] = (T) listaDeVertices;
		}
	}
	
	/*
	 * metodo percorre a lista exibindo em cada posiï¿½ao a lista ligada de Object
	 */
	public void print()
	{
		for (int i = 0; i < this.vertices.length; i++)
		{
			ListaLigada<?> list =  (ListaLigada<?>) this.vertices[i];
			print(list);
		}
	}
	
	/*
	 * Mï¿½todo retorna uma lista Ligada, percorre o vetor e encontra o vertice
	 */
	public void getAdjacentes(T vertice)
	{
		for (int i = 0; i < this.vertices.length; i++)
		{
			ListaLigada<?> list = (ListaLigada<?>) this.vertices[i];
			
			var vert = list.getNoInicial().getValue();
			
			if (vert.equals(vertice))
			{
				System.out.println("Exibindo adjacentes do vértice " + vertice);
				print(list);
			}
			
		}
	}
	
	/*
	 * Método retorna verdadeiro se o os vértices do grafo tem a mesma
	 * quantidade de adjacentes e , falso, se contrário
	 */
	public boolean eRegular()
	{
		ListaLigada<?> list = (ListaLigada<?>) this.vertices[0];
		
		for (int i = 1; i < this.vertices.length; i++)
		{
			ListaLigada<?> proxLista = (ListaLigada<?>) this.vertices[i];
			
			if (list.tamanho() != proxLista.tamanho())
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Método retorna se o vertice é adjacentes aos demais vértices
	 * É criado um array para adicionar os vertices da ListaLigada
	 * do indice 0.
	 * Entao é verificado se as demais ListasLigadas contém vértices
	 * que foram adicionados no array;
	 */
	public boolean eCompleto()
	{
		ListaLigada<?> list = (ListaLigada<?>) this.vertices[0];
		
		for (int i = 1; i < this.vertices.length; i++)
		{
			ListaLigada<?> proxLista = (ListaLigada<?>) this.vertices[i];
			
			List<Object> listaDeVertices = new ArrayList<>();
			var it = proxLista.iterator();
			
			while (it.hasNext())
			{
				listaDeVertices.add(it.next());
			}
			
			it = list.iterator();
			
			while (it.hasNext())
			{
				if (!listaDeVertices.contains(it.next()))
				{
					return false;
				}
			}
		}
		return true;
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
