# Grafos
Trabalho prático para representação de Grafos na disciplina Grafos

# Integrantes
Guilherme Teixeira e José Jhonatan

## Descrição
Dentre as formas para representar grafos, este código apresenta a Lista de Adjacência que consiste em um vetor e, em cada indice deste vetor, uma lista encadeada do tipo T.

O projeto tem implementado até o momento a classe "No", a classe "ListaLigada", a classe "Grafo" e classe "Main"
Na classe "Grafo<T>" encontram-se os métodos "adicionaAdjacentesLista", método "print", método "getAdjacentes", método "eRegular", método "eCompleto".
  
O método adicionaAdjacentesLista vai percorrer o vetor (atributo da classe) e em cada indice apontando para uma ListaLigada instanciada em mémoria, com 
aquantidade de vértices também informados, sendo que o primeiro vértice da lista é o proprio vértice que está sendo informado seus adjacentes.

O método print vai exibir o grafo e adjacentes. Dentro do loop ele exibe a ListaLigada em cada índice.

O método getAdjacentes vai retornar a ListaLigada de determinado vértice. Na classe No<T> existe um método getNoInicial, onde retorna o primeiro elemento da lista.
O primeiro elemento da ListaLigada então é comparado com o vertice passado como parâmetro.
  
O método eRegular vai retornar true caso os vértices possuiem a mesma quantidade de adjacentes, caso contrario retorna false.
É pego a ListaLigada da primeira posição do vetor e comparado o tamanho dela com as demais ListasLigadas dos outros índices.

O método eCompleto vai retornar true caso dado vertice é adjacentes aos demais vértices, caso contrário, false.
É instanciado uma ListaLigada recebendo a Lista do vetor na posição zero.
Então é instanciado um array onde serão adicionados os vértices das proximas ListasLigadas, isto em cada iteração. Por conseguinte, é verificado se os vértices
da ListaLigada da posicao zero estão dentro do array.

Na classe Main:
Possui o método "instanciaGrafo" onde é solicitado o tipo de objeto para representar os vértices (Integer ou String).
Foram criados os métodos "verificaRegularidade", "verificaCompleto" e "menuOpcoes" para melhor organização do código
No método main possui as opções de entrada onde a pessoa escolhe escolher.
