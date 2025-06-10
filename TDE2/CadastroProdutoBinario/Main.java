package TDE2.CadastroProdutoBinario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService service = new ProdutoService();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                \n=== Menu Produtos ===
                1 - Adicionar produto
                2 - Buscar por ID (binária)
                3 - Listar produtos
                0 - Sair
                """);
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    service.adicionarProduto(new Produto(id, nome, preco));
                }
                case 2 -> {
                    System.out.print("ID para buscar: ");
                    int idBusca = sc.nextInt();
                    Produto encontrado = service.buscarPorId(idBusca);
                    if (encontrado != null) {
                        System.out.println("Produto encontrado: " + encontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 3 -> service.listarProdutos();
            }
        } while (opcao != 0);
        sc.close();
    }
}