package menu;

import dao.RelatorioDAO;
import model.Relatorio;

public class MenuRelatorio {

    public static void exibirMenu() {
        System.out.println("\n--- RELATÓRIO GERAL ---");

        // Instanciar DAO e serviço de relatório
        RelatorioDAO dao = new RelatorioDAO();
        Relatorio relatorio = new Relatorio(dao);

        // Exibir relatório completo
        System.out.println(relatorio.gerarRelatorioGeral());
    }
}