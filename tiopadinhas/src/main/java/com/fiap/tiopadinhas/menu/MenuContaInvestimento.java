package com.fiap.tiopadinhas.menu;

import com.fiap.tiopadinhas.model.ContaInvestimento;
import com.fiap.tiopadinhas.storage.Storage;

import java.util.Scanner;

public class MenuContaInvestimento {

    public static void menuContaInvestimento() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();
            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    cadastrarContaInvestimento(scanner);
                    break;
                case 2:
                    listarContasInvestimento();
                    break;
                case 0:
                    System.out.println("Saindo do Menu Conta Investimento...");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Conta Investimento:");
        System.out.println("1 - Cadastrar Conta Investimento");
        System.out.println("2 - Listar Contas de Investimento");
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

    private static void cadastrarContaInvestimento(Scanner scanner) {
        System.out.print("Digite o ID do usuário: ");
        int idUsuario = scanner.nextInt();
        System.out.print("Digite o saldo da conta: ");
        double saldo = scanner.nextDouble();
        System.out.print("Digite a data de criação (AAAA-MM-DD): ");
        String dataCriacao = scanner.next(); // Podemos fazer uma conversão de String para Date se necessário

        ContaInvestimento conta = new ContaInvestimento();
        conta.setIdUsuario(idUsuario);
        conta.setSaldo(saldo);
        conta.setDataCriacao(java.sql.Date.valueOf(dataCriacao)); // Convertendo string para Date

        Storage.adicionarContaInvestimento(conta);
        System.out.println("Conta de Investimento cadastrada com sucesso!");
    }

    private static void listarContasInvestimento() {
        Storage.listarContasInvestimento();
    }
}
