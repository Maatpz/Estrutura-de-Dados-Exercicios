package TDE2.CadastroProdutoArvore.structure;

import TDE2.CadastroProdutoBinario.Produto;


public class ArvoreProduto {

    private static class No {
        Produto produto;
        No esquerda, direita;

        No(Produto produto) {
            this.produto = produto;
        }
    }

    private No raiz;

    public void inserir(Produto produto) {
        raiz = inserirRec(raiz, produto);
    }

    private No inserirRec(No atual, Produto produto) {
        if (atual == null) return new No(produto);
        if (produto.getId() < atual.produto.getId())
            atual.esquerda = inserirRec(atual.esquerda, produto);
        else
            atual.direita = inserirRec(atual.direita, produto);
        return atual;
    }

    public Produto buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Produto buscarRec(No atual, int id) {
        if (atual == null) return null;
        if (id == atual.produto.getId()) return atual.produto;
        return id < atual.produto.getId()
            ? buscarRec(atual.esquerda, id)
            : buscarRec(atual.direita, id);
    }

    public void listarEmOrdem() {
        listarRec(raiz);
    }

    private void listarRec(No atual) {
        if (atual != null) {
            listarRec(atual.esquerda);
            System.out.println(atual.produto);
            listarRec(atual.direita);
        }
    }
}
