package com.fiap.tiopadinhas.menu;

import com.fiap.tiopadinhas.model.Empresa;
import com.fiap.tiopadinhas.storage.Storage;

import java.util.Scanner;

public class MenuEmpresa {

    public static void menuEmpresa() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();
            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    cadastrarEmpresa(scanner);
                    break;
                case 2:
                    listarEmpresas();
                    break;
                case 0:
                    System.out.println("Saindo do Menu Empresa...");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Empresa:");
        System.out.println("1 - Cadastrar Empresa");
        System.out.println("2 - Listar Empresas");
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

    private static void cadastrarEmpresa(Scanner scanner) {
        System.out.print("Digite o nome da empresa: ");
        String nome = scanner.next();
        System.out.print("Digite o CNPJ da empresa: ");
        String cnpj = scanner.next();
        System.out.print("Digite o setor da empresa: ");
        String setor = scanner.next();
        System.out.print("Digite o ID do usuário responsável: ");
        int idUsuario = scanner.nextInt();

        Empresa empresa = new Empresa(0, nome, idUsuario, cnpj, setor);
        Storage.adicionarEmpresa(empresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }

    private static void listarEmpresas() {
        Storage.listarEmpresas();
    }
}
