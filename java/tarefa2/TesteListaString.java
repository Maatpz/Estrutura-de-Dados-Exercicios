package tarefa2;

import java.util.*; 

class ListaArrayString {
    private String[] array;
    private int tamanho;
    public ListaArrayString(int capacidade) {
    this.array = new String[capacidade];
    this.tamanho = 0;
    }
    public void adicionar(String elemento) {
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
    public void imprimirLista() {
    System.out.print("Lista de Nomes: ");
    for (int i = 0; i < tamanho; i++) {
    System.out.print(array[i] + " ");
    }
    System.out.println();
    }
    public boolean buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equals(nome)) {
                return true;
            }
        }
        return false;
    }
    }

    public class TesteListaString {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Digite a capacidade da lista: ");
            int capacidade = scanner.nextInt();
            scanner.nextLine(); 
    
            ListaArrayString lista = new ListaArrayString(capacidade);
    
            int opcao = 0;
    
            while (opcao != 5) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar nome");
                System.out.println("2. Remover nome");
                System.out.println("3. Buscar nome");
                System.out.println("4. Imprimir lista");
                System.out.println("5. Sair");
    
                opcao = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome a ser adicionado: ");
                        String nomeAdicionar = scanner.nextLine();
                        lista.adicionar(nomeAdicionar);
                        break;
    
                    case 2:
                        System.out.print("Digite a posição do nome a ser removido: ");
                        int posicaoRemover = scanner.nextInt();
                        lista.remover(posicaoRemover);
                        break;
    
                    case 3:
                        System.out.print("Digite o nome a ser buscado: ");
                        String nomeBuscar = scanner.nextLine();
                        if (lista.buscar(nomeBuscar)) {
                            System.out.println(nomeBuscar + " encontrado na lista!");
                        } else {
                            System.out.println(nomeBuscar + " não encontrado na lista.");
                        }
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