package com.fiap.tiopadinhas.storage;

import com.fiap.tiopadinhas.model.*;

import java.util.ArrayList;

public class Storage {

    // Listas para armazenar objetos temporários
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Empresa> empresas = new ArrayList<>();
    private static ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<>();
    private static ArrayList<Transacao> transacoes = new ArrayList<>();
    private static ArrayList<ParticipacaoInvestimento> participacoesInvestimento = new ArrayList<>();
    private static ArrayList<AtivoCripto> ativosCripto = new ArrayList<>();

    // Métodos para adicionar objetos às listas
    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public static void adicionarContaInvestimento(ContaInvestimento conta) {
        contasInvestimento.add(conta);
    }

    public static void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public static void adicionarParticipacaoInvestimento(ParticipacaoInvestimento participacao) {
        participacoesInvestimento.add(participacao);
    }

    public static void adicionarAtivoCripto(AtivoCripto ativoCripto) {
        ativosCripto.add(ativoCripto);
    }

    // Métodos para buscar objetos nas listas (busca por ID)
    public static Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static Empresa buscarEmpresaPorId(int id) {
        for (Empresa empresa : empresas) {
            if (empresa.getIdEmpresa() == id) {
                return empresa;
            }
        }
        return null;
    }

    public static ContaInvestimento buscarContaInvestimentoPorId(int id) {
        for (ContaInvestimento conta : contasInvestimento) {
            if (conta.getIdConta() == id) {
                return conta;
            }
        }
        return null;
    }

    public static AtivoCripto buscarAtivoCriptoPorId(int id) {
        for (AtivoCripto ativo : ativosCripto) {
            if (ativo.getIdAtivo() == id) {
                return ativo;
            }
        }
        return null;
    }

    public static ParticipacaoInvestimento buscarParticipacaoInvestimentoPorId(int id) {
        for (ParticipacaoInvestimento participacao : participacoesInvestimento) {
            if (participacao.getIdParticipacao() == id) {
                return participacao;
            }
        }
        return null;
    }

    public static Transacao buscarTransacaoPorId(int id) {
        for (Transacao transacao : transacoes) {
            if (transacao.getIdTransacao() == id) {
                return transacao;
            }
        }
        return null;
    }

    // Métodos para listar objetos armazenados
    public static void listarUsuarios() {
        System.out.println("\nLista de Usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public static void listarEmpresas() {
        System.out.println("\nLista de Empresas:");
        for (Empresa empresa : empresas) {
            System.out.println(empresa);
        }
    }

    public static void listarContasInvestimento() {
        System.out.println("\nLista de Contas de Investimento:");
        for (ContaInvestimento conta : contasInvestimento) {
            System.out.println(conta);
        }
    }

    public static void listarAtivosCripto() {
        System.out.println("\nLista de Ativos Cripto:");
        for (AtivoCripto ativo : ativosCripto) {
            System.out.println(ativo);
        }
    }

    public static void listarParticipacoesInvestimento() {
        System.out.println("\nLista de Participações de Investimento:");
        for (ParticipacaoInvestimento participacao : participacoesInvestimento) {
            System.out.println(participacao);
        }
    }

    public static void listarTransacoes() {
        System.out.println("\nLista de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }
}
