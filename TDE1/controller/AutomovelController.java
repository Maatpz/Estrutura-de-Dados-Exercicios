package controller;

import model.Automovel;
import model.AutomovelRepository;
import view.AutomovelView;

import java.util.List;

public class AutomovelController {
    private AutomovelRepository repository;
    private AutomovelView view;

    public AutomovelController(AutomovelRepository repository, AutomovelView view) {
        this.repository = repository;
        this.view = view;
    }

    public void iniciar() {
        repository.carregarDeArquivo();

        boolean executando = true;
        while (executando) {
            int opcao = view.exibirMenu();

            switch (opcao) {
                case 1:
                    Automovel novo = view.lerDadosAutomovel();
                    if (repository.adicionar(novo)) {
                        view.exibirMensagem("Automóvel incluído com sucesso.");
                    } else {
                        view.exibirMensagem("Erro: placa já cadastrada.");
                    }
                    break;
                case 2:
                    String placaExcluir = view.solicitarPlaca();
                    if (repository.remover(placaExcluir)) {
                        view.exibirMensagem("Automóvel removido com sucesso.");
                    } else {
                        view.exibirMensagem("Automóvel não encontrado.");
                    }
                    break;
                case 3:
                    String placaAlterar = view.solicitarPlaca();
                    Automovel existente = repository.consultar(placaAlterar);
                    if (existente != null) {
                        Automovel atualizado = view.lerDadosAlterados(existente);
                        repository.alterar(placaAlterar, atualizado);
                        view.exibirMensagem("Automóvel alterado com sucesso.");
                    } else {
                        view.exibirMensagem("Automóvel não encontrado.");
                    }
                    break;
                case 4:
                    String placaConsulta = view.solicitarPlaca();
                    Automovel encontrado = repository.consultar(placaConsulta);
                    if (encontrado != null) {
                        view.exibirAutomovel(encontrado);
                    } else {
                        view.exibirMensagem("Automóvel não encontrado.");
                    }
                    break;
                case 5:
                    String criterio = view.solicitarCriterioOrdenacao();
                    List<Automovel> listaOrdenada = repository.listarOrdenado(criterio);
                    view.exibirListaAutomoveis(listaOrdenada);
                    break;
                case 6:
                    repository.salvarEmArquivo();
                    view.exibirMensagem("Dados salvos.");
                    executando = false;
                    break;
                default:
                    view.exibirMensagem("Opção inválida.");
            }
        }
    }
}
