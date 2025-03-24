
import dominio.*;

import java.util.Scanner;

public class ControlaAluno {

    private ListaGenerica<Aluno> listaAlunos;
    private Scanner scanner;

    public ControlaAluno() {
        this.listaAlunos = new ListaGenerica<>(5);
        this.scanner = new Scanner(System.in);
        
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\nMENU DE OPÇÕES");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Exibir alunos");
            System.out.println("4 - Buscar aluno por índice");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    removerAluno();
                    break;
                case 3:
                    exibirAlunos();
                    break;
                case 4:
                    buscarAluno();
                    break;
                case 5:
                    System.out.println("Saindo");
                    scanner.close();
                    return;
                default:
                    System.out.println("inválida!");
            }
        }
    }

    private void adicionarAluno() {
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        listaAlunos.adicionar(new Aluno(matricula, nome));
        System.out.println("Aluno adicionado com sucesso!");
    }

    private void removerAluno() {
        System.out.print("Digite o índice do aluno a ser removido: ");
        int indiceRemover = scanner.nextInt();
        try {
            listaAlunos.remover(indiceRemover);
            System.out.println("Aluno removido com sucesso!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido!");
        }
    }

    private void exibirAlunos() {
        System.out.println("Lista de alunos:");
        listaAlunos.exibir();
    }

    private void buscarAluno() {
        System.out.print("Digite o índice do aluno: ");
        int indiceBuscar = scanner.nextInt();
        try {
            System.out.println("Aluno encontrado: " + listaAlunos.obter(indiceBuscar));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido!");
        }
    }
}