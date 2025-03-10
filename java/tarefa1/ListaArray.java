package tarefa1;

import java.util.*;

class ListaArray {

    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void adicionarposi(int elemento, int posicao){
        if (tamanho==array.length){
            System.err.println("Error");
            return;
        }
        if (posicao<0||posicao>tamanho){
            System.err.println("Error");
        }
        for(int i=tamanho;i>posicao;i--){
            array[i]=array[i-1];
        }
        array[posicao]=elemento;
        tamanho++;
    }

    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class TesteLista {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        
        ListaArray lista = new ListaArray(capacidade);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Adicionar elemento em posição específica");
            System.out.println("4. Imprimir lista");
            System.out.println("5. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do elemento a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    lista.adicionar(elemento);
                    break;
                case 2:
                    System.out.print("Digite a posição do elemento a ser removido: ");
                    int posicaoRemover = scanner.nextInt();
                    lista.remover(posicaoRemover);
                    break;
                case 3:
                    System.out.print("Digite o valor do elemento a ser adicionado: ");
                    int elementoPos = scanner.nextInt();
                    System.out.print("Digite a posição onde deseja adicionar o elemento: ");
                    int posicaoAdicionar = scanner.nextInt();
                    lista.adicionarposi(elementoPos, posicaoAdicionar);
                    break;
                case 4:
                    lista.imprimirLista();
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("inválido");
            }
        }

        scanner.close();
    }
}