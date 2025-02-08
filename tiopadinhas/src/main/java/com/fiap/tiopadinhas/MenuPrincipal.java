package com.fiap.tiopadinhas;

import com.fiap.tiopadinhas.menu.*;


import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;



        while (true) {
            exibirCabecalho();
            exibirMenuPrincipal();

            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    MenuUsuario.menuUsuario();
                    break;
                case 2:
                    MenuTransacao.menuTransacao();
                    break;
                case 3:
                    MenuParticipacaoInvestimento.menuParticipacaoInvestimento();
                    break;
                case 4:
                    MenuEmpresa.menuEmpresa();
                    break;
                case 5:
                    MenuContaInvestimento.menuContaInvestimento();
                    break;
                case 6:
                    MenuAtivoCripto.menuAtivoCripto();
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema... Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("⚠️ Opção inválida! Por favor, tente novamente.");
            }
        }
    }

    private static void exibirCabecalho() {
        System.out.println("====================================");
        System.out.println("          Bem-vindo ao Sistema       ");
        System.out.println("====================================");
        System.out.println("⚠️  *ATENÇÃO* - IDs Necessários para Cadastro ⚠️");
        System.out.println("1️⃣  **Usuário**: Nenhum ID externo necessário.");
        System.out.println("2️⃣  **Empresa**: Requer ID de um Usuário.");
        System.out.println("3️⃣  **Conta Investimento**: Requer ID de um Usuário.");
        System.out.println("4️⃣  **Transação**: Requer ID de uma Conta Investimento.");
        System.out.println("5️⃣  **Participação Investimento**: Requer ID de Conta Investimento e Ativo Cripto.");
        System.out.println("6️⃣  **Ativo Cripto**: Nenhum ID externo necessário.");
        System.out.println("====================================");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("⚠️ Leia o cabeçalho antes de começar a utilizar o menu ⚠️");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Menu Usuário");
        System.out.println("2 - Menu Transação");
        System.out.println("3 - Menu Participação Investimento");
        System.out.println("4 - Menu Empresa");
        System.out.println("5 - Menu Conta Investimento");
        System.out.println("6 - Menu Ativo Cripto");
        System.out.println("0 - Sair");
        System.out.print("Digite a sua escolha: ");

    }

    private static int obterEscolha(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️ Entrada inválida! Por favor, digite um número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
