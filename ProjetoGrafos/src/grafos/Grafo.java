package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grafo<T> {
	
	private Scanner scan = new Scanner(System.in);

	private T[] vertices;
	
	/*
	 * Contrutor, tendo como parametro o tamanho da lista (quantidade de v�rtices)
	 */
	public Grafo(int vertices)
	{
		this.vertices = (T[]) new Object[vertices];
	}
	
	/*
	 * M�todo percorre o vetor adicionando os vertices adjacentes em cada posi��o
	 */
	@SuppressWarnings("unchecked")
	public void adicionaAdjacentesLista()
	{
		System.out.println("Voc� criou uma lista de " + this.vertices.length + " v�rtices");
		
		for (int i = 0; i < this.vertices.length; i++)
		{
			var posicaoVertice = i + 1;
			System.out.print("Informe a quantidade de adjacentes do " + posicaoVertice + "� v�rtice: ");
			var adjacentes = scan.nextInt();
			
			var listaDeVertices = new ListaLigada<Object>();
			
			int cont = 0;
			while (cont <= adjacentes)
			{
				T vertice = null;
				if (cont == 0)
				{
					System.out.print("Esta primeira posi��o recebe o vertice em si: ");
					vertice = (T) scan.next();
				}
				else 
				{
					System.out.print("Informe o v�rtice adjacente ao " + posicaoVertice + "� v�rtice: ");
					vertice = (T) scan.next();
				}
				
				listaDeVertices.adiciona(vertice);
				cont++;
			}
			
			this.vertices[i] = (T) listaDeVertices;
		}
	}
	
	/*
	 * metodo percorre a lista exibindo em cada posi�ao a lista ligada de Object
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
	 * M�todo retorna uma lista Ligada, percorre o vetor e encontra o vertice
	 */
	public void getAdjacentes(T vertice)
	{
		for (int i = 0; i < this.vertices.length; i++)
		{
			ListaLigada<?> list = (ListaLigada<?>) this.vertices[i];
			
			var vert = list.getNoInicial().getValue();
			
			if (vert.equals(vertice))
			{
				System.out.println("Exibindo adjacentes do v�rtice " + vertice);
				print(list);
			}
			
		}
	}
	
	/*
	 * M�todo retorna verdadeiro se o os v�rtices do grafo tem a mesma
	 * quantidade de adjacentes e , falso, se contr�rio
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
	 * M�todo retorna se o vertice � adjacentes aos demais v�rtices
	 * � criado um array para adicionar os vertices da ListaLigada
	 * do indice 0.
	 * Entao � verificado se as demais ListasLigadas cont�m v�rtices
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
