package Produtos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto { " + "Codigo: " + codigo + ", Nome: '" + nome + "', Quantidade: " + quantidade + " }";
    }
}

class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(int codigo, String nome, int quantidade) {
        produtos.add(new Produto(codigo, nome, quantidade));
    }

    public boolean removerProduto(int codigo) {
        return produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }

    public Produto buscarPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public Produto buscarPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Estoque estoque = new Estoque();
        
        // estoque.adicionarProduto(1, "Arroz", 100);
        // estoque.adicionarProduto(2, "Feijão", 72);
        // estoque.adicionarProduto(3, "Açúcar", 27);
        
        // System.out.println("Lista de produtos:");
        // estoque.listarProdutos();
        
        // System.out.println("\nBuscando produto pelo código 2:");
        // System.out.println(estoque.buscarPorCodigo(2));
        
        // System.out.println("\nBuscando produto pelo nome 'Açúcar':");
        // System.out.println(estoque.buscarPorNome("Açúcar"));
        
        // System.out.println("\nRemovendo produto de código 1");
        // estoque.removerProduto(1);
        
        // System.out.println("\nLista de produtos após remoção:");
        // estoque.listarProdutos();

        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        
        while (true) {
            System.out.println("\n1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Buscar Produto por Código");
            System.out.println("4 - Buscar Produto por Nome");
            System.out.println("5 - Listar Produtos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    estoque.adicionarProduto(codigo, nome, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    if (estoque.removerProduto(codigoRemover)) {
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o código do produto a ser buscado: ");
                    int codigoBuscar = scanner.nextInt();
                    Produto produtoCodigo = estoque.buscarPorCodigo(codigoBuscar);
                    System.out.println(produtoCodigo != null ? produtoCodigo : "Produto não encontrado.");
                    break;
                case 4:
                    System.out.print("Digite o nome do produto a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    Produto produtoNome = estoque.buscarPorNome(nomeBuscar);
                    System.out.println(produtoNome != null ? produtoNome : "Produto não encontrado.");
                    break;
                case 5:
                    estoque.listarProdutos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}