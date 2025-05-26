import java.io.*;
import java.util.*;

public class CadastroAlunos {
    private static final String NOME_ARQUIVO = "alunos.txt";
    private static List<Aluno> listaAlunos = new ArrayList<>();

    public static void main(String[] args) {
        carregarAlunos();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    salvarAlunos();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Coeficiente de Rendimento: ");
        double coef = scanner.nextDouble();

        Aluno aluno = new Aluno(matricula, nome, coef);
        listaAlunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n--- Lista de Alunos ---");
            for (Aluno a : listaAlunos) {
                System.out.println("Matrícula: " + a.getMatricula() +
                                   ", Nome: " + a.getNome() +
                                   ", CR: " + a.getCoeficienteRendimento());
            }
        }
    }

    private static void salvarAlunos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Aluno a : listaAlunos) {
                writer.write(a.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void carregarAlunos() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Aluno aluno = Aluno.fromString(linha);
                listaAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
