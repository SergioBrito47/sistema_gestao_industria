// MenuProducao.java
package menu;

import dao.FuncionarioDAO;
import dao.ProducaoDAO;
import dao.ProdutoDAO;
import model.Funcionario;
import model.Producao;
import model.Produto;

import java.util.Scanner;

public class MenuProducao {
    private static final ProducaoDAO producaoDAO = new ProducaoDAO();
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU PRODUÇÃO ---");
            System.out.println("1. Listar");
            System.out.println("2. Cadastrar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("5. Buscar por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> producaoDAO.listar().forEach(System.out::println);
                case 2 -> {
                    System.out.print("ID do produto: ");
                    Produto produto = produtoDAO.buscarPorId(scanner.nextInt());
                    System.out.print("ID do funcionário: ");
                    Funcionario funcionario = funcionarioDAO.buscarPorId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Data de produção (YYYY-MM-DD): ");
                    String data = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();

                    producaoDAO.cadastrar(new Producao(null, produto, funcionario, data, qtd));
                }
                case 3 -> {
                    System.out.print("ID da produção: ");
                    int id = scanner.nextInt();
                    System.out.print("Novo ID do produto: ");
                    Produto produto = produtoDAO.buscarPorId(scanner.nextInt());
                    System.out.print("Novo ID do funcionário: ");
                    Funcionario funcionario = funcionarioDAO.buscarPorId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nova data: ");
                    String data = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int qtd = scanner.nextInt();

                    producaoDAO.atualizar(new Producao(id, produto, funcionario, data, qtd));
                }
                case 4 -> {
                    System.out.print("ID da produção: ");
                    producaoDAO.remover(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("ID da produção: ");
                    System.out.println(producaoDAO.buscarPorId(scanner.nextInt()));
                }
            }
        } while (opcao != 0);
    }
}