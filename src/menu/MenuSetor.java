// MenuSetor.java
package menu;

import dao.SetorDAO;
import model.Setor;

import java.util.Scanner;

public class MenuSetor {
    private static final SetorDAO setorDAO = new SetorDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU SETOR ---");
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
                case 1 -> setorDAO.listar().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Responsável: ");
                    String resp = scanner.nextLine();
                    setorDAO.cadastrar(new Setor(null, nome, resp));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo responsável: ");
                    String resp = scanner.nextLine();
                    setorDAO.atualizar(new Setor(id, nome, resp));
                }
                case 4 -> {
                    System.out.print("ID: ");
                    setorDAO.remover(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("ID: ");
                    System.out.println(setorDAO.buscarPorId(scanner.nextInt()));
                }
            }
        } while (opcao != 0);
    }
}