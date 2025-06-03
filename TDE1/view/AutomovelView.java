package view;

import model.Automovel;

import java.util.List;
import java.util.Scanner;

public class AutomovelView {
    private Scanner scanner;

    public AutomovelView() {
        scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n==== MENU ====");
        System.out.println("1 - Incluir automóvel");
        System.out.println("2 - Remover automóvel");
        System.out.println("3 - Alterar dados de automóvel");
        System.out.println("4 - Consultar automóvel por placa");
        System.out.println("5 - Listar automóveis (ordenado)");
        System.out.println("6 - Salvar e sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Automovel lerDadosAutomovel() {
        System.out.println("\n-- Cadastro de Automóvel --");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        return new Automovel(placa, modelo, marca, ano, valor);
    }

    public Automovel lerDadosAlterados(Automovel original) {
        System.out.println("\n-- Alterar Automóvel (" + original.getPlaca() + ") --");

        System.out.print("Novo modelo (" + original.getModelo() + "): ");
        String modelo = scanner.nextLine();
        if (modelo.isEmpty()) modelo = original.getModelo();

        System.out.print("Nova marca (" + original.getMarca() + "): ");
        String marca = scanner.nextLine();
        if (marca.isEmpty()) marca = original.getMarca();

        System.out.print("Novo ano (" + original.getAno() + "): ");
        String anoStr = scanner.nextLine();
        int ano = anoStr.isEmpty() ? original.getAno() : Integer.parseInt(anoStr);

        System.out.print("Novo valor (" + original.getValor() + "): ");
        String valorStr = scanner.nextLine();
        double valor = valorStr.isEmpty() ? original.getValor() : Double.parseDouble(valorStr);

        return new Automovel(original.getPlaca(), modelo, marca, ano, valor);
    }

    public String solicitarPlaca() {
        System.out.print("Informe a placa: ");
        return scanner.nextLine();
    }

    public String solicitarCriterioOrdenacao() {
        System.out.print("Ordenar por (placa/modelo/marca): ");
        return scanner.nextLine();
    }

    public void exibirAutomovel(Automovel a) {
        System.out.println("\n>> Dados do Automóvel:");
        System.out.println(a);
    }

    public void exibirListaAutomoveis(List<Automovel> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum automóvel cadastrado.");
        } else {
            System.out.println("\n-- Lista de Automóveis --");
            for (Automovel a : lista) {
                System.out.println(a);
            }
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }
}
