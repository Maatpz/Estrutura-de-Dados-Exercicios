package model;

import java.io.*;
import java.util.*;

public class AutomovelRepository {
    private List<Automovel> automoveis;
    private final String NOME_ARQUIVO = "automoveis.txt";

    public AutomovelRepository() {
        automoveis = new ArrayList<>();
    }

    public boolean adicionar(Automovel a) {
        if (consultar(a.getPlaca()) != null) {
            return false;
        }
        automoveis.add(a);
        return true;
    }

    public boolean remover(String placa) {
        Automovel a = consultar(placa);
        if (a != null) {
            automoveis.remove(a);
            return true;
        }
        return false;
    }

    public Automovel consultar(String placa) {
        for (Automovel a : automoveis) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                return a;
            }
        }
        return null;
    }

    public boolean alterar(String placa, Automovel novo) {
        for (int i = 0; i < automoveis.size(); i++) {
            if (automoveis.get(i).getPlaca().equalsIgnoreCase(placa)) {
                automoveis.set(i, novo);
                return true;
            }
        }
        return false;
    }

    public List<Automovel> listarOrdenado(String criterio) {
        List<Automovel> copia = new ArrayList<>(automoveis);
        switch (criterio.toLowerCase()) {
            case "placa":
                copia.sort(Comparator.comparing(Automovel::getPlaca));
                break;
            case "modelo":
                copia.sort(Comparator.comparing(Automovel::getModelo));
                break;
            case "marca":
                copia.sort(Comparator.comparing(Automovel::getMarca));
                break;
            default:
                break;
        }
        return copia;
    }

    public void carregarDeArquivo() {
        File file = new File(NOME_ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Automovel a = Automovel.fromCSV(linha);
                automoveis.add(a);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void salvarEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Automovel a : automoveis) {
                writer.write(a.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
