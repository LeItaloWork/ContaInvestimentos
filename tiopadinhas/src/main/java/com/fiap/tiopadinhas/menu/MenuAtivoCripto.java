package com.fiap.tiopadinhas.menu;

import java.util.Scanner;
import com.fiap.tiopadinhas.dao.AtivoCriptoDAO;
import com.fiap.tiopadinhas.model.AtivoCripto;

public class MenuAtivoCripto {

    public static void menuAtivoCripto() {
        Scanner scanner = new Scanner(System.in);
        AtivoCriptoDAO ativoCriptoDAO = new AtivoCriptoDAO();

        System.out.println("Menu Ativo Cripto:");
        System.out.println("1 - Adicionar Ativo Cripto");
        System.out.println("2 - Atualizar Ativo Cripto");
        System.out.println("3 - Listar Ativos Cripto");
        System.out.println("4 - Deletar Ativo Cripto");
        System.out.println("0 - Voltar");

        int escolha = scanner.nextInt();
        scanner.nextLine();  // Captura a quebra de linha deixada pelo nextInt()

        switch (escolha) {
            case 1:
                AtivoCripto ativoCripto = new AtivoCripto();

                System.out.print("Digite o nome do ativo (Ex: Bitcoin): ");
                ativoCripto.setNome(scanner.nextLine());

                System.out.print("Digite o símbolo do ativo (Ex: BTC): ");
                ativoCripto.setSimbolo(scanner.nextLine());

                double valorAtual = obterValorNumericoValido(scanner, "Digite o valor atual do ativo (Ex: 20000.50): ");
                ativoCripto.setValorAtual(valorAtual);

                ativoCriptoDAO.inserir(ativoCripto);
                System.out.println("Ativo adicionado com sucesso.");
                break;

            case 2:
                System.out.print("Digite o ID do ativo para atualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Captura a quebra de linha deixada pelo nextInt()

                AtivoCripto ativoAtualizar = ativoCriptoDAO.buscarPorId(id);

                if (ativoAtualizar != null) {
                    System.out.print("Novo nome (Ex: Ethereum): ");
                    ativoAtualizar.setNome(scanner.nextLine());

                    System.out.print("Novo símbolo (Ex: ETH): ");
                    ativoAtualizar.setSimbolo(scanner.nextLine());

                    double novoValorAtual = obterValorNumericoValido(scanner, "Novo valor atual (Ex: 3000.75): ");
                    ativoAtualizar.setValorAtual(novoValorAtual);

                    ativoCriptoDAO.atualizar(ativoAtualizar);
                    System.out.println("Ativo atualizado com sucesso.");
                } else {
                    System.out.println("Ativo não encontrado.");
                }
                break;

            case 3:
                ativoCriptoDAO.listar().forEach(a -> System.out.println(a.getNome() + " - " + a.getSimbolo() + " - " + a.getValorAtual()));
                break;

            case 4:
                System.out.print("Digite o ID do ativo para deletar: ");
                int idDeletar = scanner.nextInt();
                ativoCriptoDAO.deletar(idDeletar);
                System.out.println("Ativo deletado com sucesso.");
                break;

            case 0:
                return;

            default:
                System.out.println("Opção inválida.");
        }
    }

    // Função auxiliar para validar a entrada numérica
    private static double obterValorNumericoValido(Scanner scanner, String mensagem) {
        double valor = 0;
        boolean valorValido = false;

        while (!valorValido) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                valor = Double.parseDouble(entrada.replace(",", "."));  // Troca vírgula por ponto, se necessário
                valorValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
            }
        }
        return valor;
    }
}
