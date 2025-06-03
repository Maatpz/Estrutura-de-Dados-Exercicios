package model;

public class Automovel {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;

    public Automovel(String placa, String modelo, String marca, int ano, double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s | Modelo: %s | Marca: %s | Ano: %d | Valor: %.2f",
                placa, modelo, marca, ano, valor);
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%d,%.2f", placa, modelo, marca, ano, valor);
    }

    public static Automovel fromCSV(String linha) {
        String[] partes = linha.split(",");
        return new Automovel(
                partes[0],
                partes[1],
                partes[2],
                Integer.parseInt(partes[3]),
                Double.parseDouble(partes[4])
        );
    }
}
