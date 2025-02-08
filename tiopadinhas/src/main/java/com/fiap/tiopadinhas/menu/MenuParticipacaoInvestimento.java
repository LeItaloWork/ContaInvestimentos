package com.fiap.tiopadinhas.menu;

import com.fiap.tiopadinhas.model.ParticipacaoInvestimento;
import com.fiap.tiopadinhas.storage.Storage;

import java.util.Scanner;

public class MenuParticipacaoInvestimento {

    public static void menuParticipacaoInvestimento() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();
            opcao = obterEscolha(scanner);

            switch (opcao) {
                case 1:
                    cadastrarParticipacaoInvestimento(scanner);
                    break;
                case 2:
                    listarParticipacoesInvestimento();
                    break;
                case 0:
                    System.out.println("Saindo do Menu Participação de Investimento...");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Participação Investimento:");
        System.out.println("1 - Cadastrar Participação Investimento");
        System.out.println("2 - Listar Participações");
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

    private static void cadastrarParticipacaoInvestimento(Scanner scanner) {
        System.out.print("Digite o ID da conta de investimento: ");
        int idConta = scanner.nextInt();
        System.out.print("Digite o ID do ativo cripto: ");
        int idAtivo = scanner.nextInt();
        System.out.print("Digite a quantidade de ativo: ");
        double quantidade = scanner.nextDouble();
        System.out.print("Digite o valor investido: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite o ID do usuário: ");
        int idUsuario = scanner.nextInt();
        System.out.print("Digite o ID da empresa: ");
        int idEmpresa = scanner.nextInt();

        ParticipacaoInvestimento participacao = new ParticipacaoInvestimento();
        participacao.setIdConta(idConta);
        participacao.setIdAtivo(idAtivo);
        participacao.setQuantidade(quantidade);
        participacao.setValorInvestido(valorInvestido);
        participacao.setIdUsuario(idUsuario);
        participacao.setIdEmpresa(idEmpresa);

        Storage.adicionarParticipacaoInvestimento(participacao);
        System.out.println("Participação Investimento cadastrada com sucesso!");
    }

    private static void listarParticipacoesInvestimento() {
        Storage.listarParticipacoesInvestimento();
    }
}
