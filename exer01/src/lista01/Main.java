public class Main {
    public static void main(String[] args) {
        // Criando uma instância da ListaArray
        ListaArray lista = new ListaArray();

        // Adicionando elementos
        System.out.println("Adicionando elementos:");
        lista.adicionar("Elemento 1");
        lista.adicionar("Elemento 2");
        lista.adicionar("Elemento 3");
        lista.adicionar("Elemento 4"); // Deve expandir a lista
        
        // Exibindo os elementos da lista
        System.out.println("Lista após adições:");
        for (int i = 0; i < lista.obterNumElementos(); i++) {
            System.out.println("Posição " + i + ": " + lista.obter(i));
        }

        // Adicionando um elemento em uma posição específica
        System.out.println("\nAdicionando 'Elemento Extra' na posição 2:");
        lista.adicionar("Elemento Extra", 2);

        // Exibindo a lista novamente
        System.out.println("Lista após inserção:");
        for (int i = 0; i < lista.obterNumElementos(); i++) {
            System.out.println("Posição " + i + ": " + lista.obter(i));
        }

        // Removendo um elemento pela posição
        System.out.println("\nRemovendo o elemento da posição 1:");
        lista.remover(1);

        // Exibindo a lista após remoção
        System.out.println("Lista após remoção:");
        for (int i = 0; i < lista.obterNumElementos(); i++) {
            System.out.println("Posição " + i + ": " + lista.obter(i));
        }

        // Buscando a posição de um elemento
        String buscar = "Elemento Extra";
        int posicao = lista.posicaoDe(buscar);
        System.out.println("\nPosição de '" + buscar + "': " + (posicao != -1 ? posicao : "Não encontrado"));

        // Removendo um elemento pelo objeto
        System.out.println("\nRemovendo '" + buscar + "': " + lista.remover(buscar));

        // Exibindo a lista final
        System.out.println("Lista final:");
        for (int i = 0; i < lista.obterNumElementos(); i++) {
            System.out.println("Posição " + i + ": " + lista.obter(i));
        }
    }
}