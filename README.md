# Grafos
Trabalho prático para representação de Grafos na disciplina Grafos

# Integrantes
Guilherme Teixeira e José Jhonatan

## Descrição
Dentre as formas para representar grafos, este código apresenta a Lista de Adjacência que consiste em um vetor e, em cada indice deste vetor, uma lista encadeada do tipo T.

O projeto tem implementado, até o momento, a classe No (do tipo T), a classe ListaLigada onde são implementados os métodos de "adicionar", "tamanho" e, "iterator". Tem implementado a classe Grafo (do tipo T), nesta classe temos um atributo (vetor[]) do tipo t, onde representa os vértices, no contrutor é passado o tamanho desde vetor. Dentro desta classe possui um método "adcionaAdjacentesLista", onde é percorrido este vetor. Em cada índice é informado o número (quantidade) de adjacentes que o vertice terá, tendo como primeiro elemento da ListaLigada o próprio vértice. Então é criado um loop para captura destes elementos e adicionado na ListaLigada. Por conseguinte este índice recebe o endereço da ListaLigada. A classe Grafo tem tambem implementado um método publico "print" onde é percorrido o vetor e em cada índice uma ListaLigada, tem implementado um método privado também "print", onde recebe como parametro uma ListaLigada de Objectos para exibir os elementos deste Lista. Método criado para evitar repetiçao de código, caso posteriormente seja necessario exibir novamente a lista.

Na classe Main é instanciado um objeto Grafo passando tres Vértices.

Exemplo da execução: Irá solicitar a quantidade de adjacentes deste prmeiro vértice,e por exemplo é colocado a quantidade 3. Então será informado o proprio vértice (para primeiro elemento da ListaLigada), por exemplo "A". Em seguida é percorrido três vezes o loop solicitando os adjacentes desde vertice "A". Como exemplo "C" e "D". Assim que sair do método para adicionar os adjacentes é exibido no console: A -> C -> D Este foi apenas um exemplo da execução.
