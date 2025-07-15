// Main.java
import menu.*;
import dao.RelatorioDAO;
import model.Relatorio;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int modulo;
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        Relatorio relatorio = new Relatorio(relatorioDAO);

        do {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1. Setor");
            System.out.println("2. Funcionário");
            System.out.println("3. Produto");
            System.out.println("4. Produção");
            System.out.println("5. Relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha o módulo: ");
            modulo = scanner.nextInt();


            switch (modulo) {
                case 1 -> MenuSetor.exibirMenu();
                case 2 -> MenuFuncionario.exibirMenu();
                case 3 -> MenuProdutos.exibirMenu();
                case 4 -> MenuProducao.exibirMenu();
                case 5 -> MenuRelatorio.exibirMenu();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (modulo != 0);
    }
}
