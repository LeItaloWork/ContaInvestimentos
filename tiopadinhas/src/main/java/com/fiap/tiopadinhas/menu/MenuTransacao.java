package com.fiap.tiopadinhas.menu;

import com.fiap.tiopadinhas.model.Transacao;
import com.fiap.tiopadinhas.storage.Storage;

import java.util.Scanner;

public class MenuTransacao {

    public static void menuTransacao() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();
            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    cadastrarTransacao(scanner);
                    break;
                case 2:
                    listarTransacoes();
                    break;
                case 0:
                    System.out.println("Saindo do Menu Transação...");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Transação:");
        System.out.println("1 - Cadastrar Transação");
        System.out.println("2 - Listar Transações");
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

    private static void cadastrarTransacao(Scanner scanner) {
        System.out.print("Digite o ID da conta de investimento: ");
        int idConta = scanner.nextInt();
        System.out.print("Digite o valor da transação: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o tipo de transação (exemplo: 'deposito', 'saque'): ");
        String tipoTransacao = scanner.next();
        System.out.print("Digite a data da transação (AAAA-MM-DD): ");
        String dataTransacao = scanner.next(); // Convertendo para Date

        Transacao transacao = new Transacao();
        transacao.setIdConta(idConta);
        transacao.setValor(valor);
        transacao.setTipoTransacao(tipoTransacao);
        transacao.setDataTransacao(java.sql.Date.valueOf(dataTransacao)); // Convertendo string para Date

        Storage.adicionarTransacao(transacao);
        System.out.println("Transação cadastrada com sucesso!");
    }

    private static void listarTransacoes() {
        Storage.listarTransacoes();
    }
}
