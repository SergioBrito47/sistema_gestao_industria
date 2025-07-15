// MenuProduto.java
package menu;

import dao.ProdutoDAO;
import model.Produto;

import java.util.Scanner;

public class MenuProdutos {
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU PRODUTO ---");
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
                case 1 -> produtoDAO.listar().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    produtoDAO.cadastrar(new Produto(null, nome, desc));
                }
                case 3 -> {
                    System.out.print("ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String desc = scanner.nextLine();
                    produtoDAO.atualizar(new Produto(id, nome, desc));
                }
                case 4 -> {
                    System.out.print("ID do produto: ");
                    produtoDAO.remover(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("ID do produto: ");
                    System.out.println(produtoDAO.buscarPorId(scanner.nextInt()));
                }
            }
        } while (opcao != 0);
    }
}