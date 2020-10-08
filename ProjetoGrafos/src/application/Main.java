package application;

import java.util.Scanner;

import grafos.Grafo;

public class Main {
	
	private static Scanner capture = new Scanner(System.in);

	public static void main(String[] args) 
	{
		Grafo<Object> grafo = null;
		int opcao = 0;
		
		do
		{
			menuOp�oes();
			opcao = capture.nextInt();
			switch (opcao)
			{
				case 1:
					grafo = (Grafo<Object>) instanciaGrafo();
					grafo.adicionaAdjacentesLista();
					break;
				case 2:
					System.out.println("\nExibindo Grafo e Adjacentes");
					grafo.print();
					break;
				case 3:
					System.out.print("\nInforme um vertice que deseja verificar os adjacentes: ");
					var vertice = capture.next();
					grafo.getAdjacentes(vertice);
					break;
				case 4:
					verificarRegularidade(grafo);
					break;
				case 5:
					verificaCompleto(grafo);
					break;
			}
		} while (opcao != 0);
		
	}
	
	private static Grafo<?> instanciaGrafo()
	{
		System.out.print("Informe o tipo de v�rtice que deseja para represeta��o (Integer ou String): ");
		var tipo = capture.next();
		System.out.print("Informe tamb�m a quantidade de v�rtices que este grafo possui: ");
		var qt = capture.nextInt();
		
		if (tipo.toLowerCase().equals("string"))
		{
			return new Grafo<String>(qt);
		}
		else
		{
			return new Grafo<Integer>(qt);
		}
	}
	
	private static void menuOp�oes()
	{
		System.out.println("****** OP��ES ******");
		System.out.println("(1) - Criar Grafo");
		System.out.println("(2) - Exibir V�rtices e Adjacentes");
		System.out.println("(3) - Informar um V�rtice para ver seus adjacentes");
		System.out.println("(4) - Verificar se Grafo � Regular");
		System.out.println("(5) - Verificar se Grafo � Completo");
		System.out.println("(0) - Sair");
		System.out.println("********************");
		System.out.print("Op��o: ");
	}
	
	private static void verificarRegularidade(Grafo<?> grafo)
	{
		if (grafo.eRegular())
		{
			System.out.println("Grafo � regular.");
		}
		else
		{
			System.out.println("Grafo n�o � regular.");
		}
	}
	
	private static void verificaCompleto(Grafo<?> grafo)
	{
		if (grafo.eCompleto())
		{
			System.out.println("Grafo � completo.");
		}
		else
		{
			System.out.println("Grafo n�o � completo.");
		}
	}
}
