package Estoque;
import java.util.ArrayList;
import java.util.List;

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
        Estoque estoque = new Estoque();
        
        estoque.adicionarProduto(1, "Arroz", 50);
        estoque.adicionarProduto(2, "Feijão", 30);
        estoque.adicionarProduto(3, "Açúcar", 20);
        
        System.out.println("Lista de produtos:");
        estoque.listarProdutos();
        
        System.out.println("\nBuscando produto pelo código 2:");
        System.out.println(estoque.buscarPorCodigo(2));
        
        System.out.println("\nBuscando produto pelo nome 'Açúcar':");
        System.out.println(estoque.buscarPorNome("Açúcar"));
        
        System.out.println("\nRemovendo produto de código 1");
        estoque.removerProduto(1);
        
        System.out.println("\nLista de produtos após remoção:");
        estoque.listarProdutos();
    }
}