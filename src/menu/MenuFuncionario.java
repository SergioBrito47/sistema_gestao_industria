// MenuFuncionario.java
package menu;

import dao.FuncionarioDAO;
import dao.SetorDAO;
import model.Funcionario;
import model.Setor;

import java.util.Scanner;

public class MenuFuncionario {
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static final SetorDAO setorDAO = new SetorDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU FUNCIONÁRIO ---");
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
                case 1 -> funcionarioDAO.listar().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("ID do setor: ");
                    int idSetor = scanner.nextInt();
                    scanner.nextLine();
                    Setor setor = setorDAO.buscarPorId(idSetor);
                    funcionarioDAO.cadastrar(new Funcionario(null, nome, sobrenome, setor));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo sobrenome: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("ID do setor: ");
                    int idSetor = scanner.nextInt();
                    scanner.nextLine();
                    Setor setor = setorDAO.buscarPorId(idSetor);
                    funcionarioDAO.atualizar(new Funcionario(id, nome, sobrenome, setor));
                }
                case 4 -> {
                    System.out.print("ID: ");
                    funcionarioDAO.remover(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("ID: ");
                    System.out.println(funcionarioDAO.buscarPorId(scanner.nextInt()));
                }
            }
        } while (opcao != 0);
    }
}

