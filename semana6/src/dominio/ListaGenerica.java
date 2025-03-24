public class ListaGenerica<T> {

    // Array genérico para armazenar os elementos da lista
    private T[] elementos;
    
    // Representa a quantidade de elementos reais na lista
    private int tamanho;

    // Construtor da classe
    @SuppressWarnings("unchecked") // Evita o aviso do compilador sobre o cast para T[]
    public ListaGenerica(int capacidade) {
        // Inicializa o array de elementos com a capacidade especificada
        elementos = (T[]) new Object[capacidade];
        tamanho = 0; // Inicialmente, a lista está vazia
    }

    // Método para adicionar um elemento à lista
    public void adicionar(T elemento) {
        // Se o array estiver cheio, redimensiona para o dobro do tamanho atual
        if (tamanho == elementos.length) {
            redimensionarArray();
        }
        // Adiciona o novo elemento na posição disponível
        elementos[tamanho] = elemento;
        tamanho++; // Incrementa o tamanho da lista
    }

    // Método para obter um elemento com base no índice
    public T obter(int indice) {
        // Verifica se o índice fornecido é válido
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return elementos[indice]; // Retorna o elemento na posição especificada
    }

    // Método para remover um elemento com base no índice
    public void remover(int indice) {
        // Verifica se o índice é válido
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        // Desloca os elementos para preencher a posição removida
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--; // Reduz o tamanho da lista
    }

    // Método para exibir todos os elementos da lista
    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println(); // Quebra de linha após imprimir os elementos
    }

    // Método privado para redimensionar o array quando estiver cheio
    private void redimensionarArray() {
        int novoTamanho = elementos.length * 2; // Dobra o tamanho do array
        @SuppressWarnings("unchecked") // Evita aviso do compilador
        T[] novoArray = (T[]) new Object[novoTamanho]; // Cria um novo array maior

        // Copia os elementos do array antigo para o novo
        for (int i = 0; i < elementos.length; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray; // Atualiza a referência do array
    }
}