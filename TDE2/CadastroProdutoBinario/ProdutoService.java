package TDE2.CadastroProdutoBinario;

import java.util.*;

public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto novo) {
        produtos.add(novo);
        Collections.sort(produtos); // mantém ordenado por id
    }

    public Produto buscarPorId(int id) {
        int inicio = 0;
        int fim = produtos.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Produto atual = produtos.get(meio);

            if (atual.getId() == id) return atual;
            else if (atual.getId() < id) inicio = meio + 1;
            else fim = meio - 1;
        }

        return null;
    }

    public void listarProdutos() {
        produtos.forEach(System.out::println);
    }
}
