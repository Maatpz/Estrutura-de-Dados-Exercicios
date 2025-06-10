import model.Produto;
import structure.ArvoreProduto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreProduto arvore = new ArvoreProduto();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                \n=== Menu Produtos (Árvore) ===
                1 - Adicionar Produto
                2 - Buscar Produto por ID
                3 - Listar Produtos em Ordem
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
                    arvore.inserir(new Produto(id, nome, preco));
                }
                case 2 -> {
                    System.out.print("ID para buscar: ");
                    int idBusca = sc.nextInt();
                    Produto p = arvore.buscar(idBusca);
                    if (p != null) System.out.println("Encontrado: " + p);
                    else System.out.println("Produto não encontrado.");
                }
                case 3 -> arvore.listarEmOrdem();
            }
        } while (opcao != 0);
        sc.close();
    }
}
