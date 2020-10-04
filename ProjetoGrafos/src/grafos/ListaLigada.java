package grafos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaLigada<T> implements Iterable<T>{
		
	private No<T> noInicial;
	private No<T> noFim;
	private int tamanho;
	
	public void adiciona(T elemento)
	{
		var no = new No<T>(elemento);
		
		if (noInicial == null) {
			noInicial = noFim = no;
		} else {
			noFim.setProximo(no);
			noFim = no;
		}
		
		tamanho++;
	}
		
	public int tamanho() 
	{
		return tamanho;
	}
	
	
	
	public No<T> getNoInicial() {
		return noInicial;
	}
	

	@Override
	public Iterator<T> iterator()
	{
		return new ListaIterator();
	}
	
	class ListaIterator implements Iterator<T>
	{

		No<T> noCorrente = null;
		
		@Override
		public boolean hasNext() 
		{
			if (noCorrente == null && noInicial != null)
			{
				return true;
			} 
			else if (noCorrente != null) 
			{
				return noCorrente.getProximo() != null;
			}
			return false;
		}

		@Override
		public T next() 
		{
			
			if (noCorrente == null &&noInicial != null) 
			{
				noCorrente = noInicial;
				return noCorrente.getValue();
			} 
			else if (noCorrente != null) 
			{
				noCorrente = noCorrente.getProximo();
				return noCorrente.getValue();
			}
			
			throw new NoSuchElementException();
		}
		
	}
}

