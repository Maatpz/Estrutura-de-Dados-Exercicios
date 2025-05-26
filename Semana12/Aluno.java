public class Aluno {
    private int matricula;
    private String nome;
    private double coeficienteRendimento;

    public Aluno(int matricula, String nome, double coeficienteRendimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.coeficienteRendimento = coeficienteRendimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getCoeficienteRendimento() {
        return coeficienteRendimento;
    }

    @Override
    public String toString() {
        return matricula + "," + nome + "," + coeficienteRendimento;
    }

    public static Aluno fromString(String linha) {
        String[] partes = linha.split(",");
        int matricula = Integer.parseInt(partes[0]);
        String nome = partes[1];
        double coef = Double.parseDouble(partes[2]);
        return new Aluno(matricula, nome, coef);
    }
}
