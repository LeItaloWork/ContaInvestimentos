package com.fiap.tiopadinhas.menu;

import com.fiap.tiopadinhas.model.Usuario;
import com.fiap.tiopadinhas.storage.Storage;

import java.util.Scanner;

public class MenuUsuario {

    public static void menuUsuario() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();
            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("Saindo do Menu Usuário...");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Usuário:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Listar Usuários");
        System.out.println("0 - Voltar");
        System.out.print("Digite a sua escolha: ");
    }

    private static int obterEscolha(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️ Entrada inválida! Digite um número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.next();
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.next();
        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.next();
        System.out.print("Digite o tipo de usuário (admin/cliente): ");
        String tipoUsuario = scanner.next();

        Usuario usuario = new Usuario(nome, email, senha, tipoUsuario);
        Storage.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        Storage.listarUsuarios();
    }
}
