package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    // Inserir nova transação
    public void inserir(Transacao transacao) {
        String sql = "INSERT INTO TRANSACAO (ID_CONTA, VALOR, TIPO_TRANSACAO, DATA_TRANSACAO) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(true); // Garante que a transação será comitada
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, transacao.getIdConta());
                stmt.setDouble(2, transacao.getValor());
                stmt.setString(3, transacao.getTipoTransacao());
                stmt.setDate(4, new java.sql.Date(transacao.getDataTransacao().getTime()));

                stmt.executeUpdate();
                System.out.println("Transação inserida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir transação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Listar todas as transações
    public List<Transacao> listar() {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM TRANSACAO";
        System.out.println("Executando SQL: " + sql);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(rs.getInt("ID_TRANSACAO"));
                transacao.setIdConta(rs.getInt("ID_CONTA"));
                transacao.setValor(rs.getDouble("VALOR"));
                transacao.setTipoTransacao(rs.getString("TIPO_TRANSACAO"));
                transacao.setDataTransacao(rs.getDate("DATA_TRANSACAO"));

                System.out.println("Transação encontrada: " + transacao); // Debug
                transacoes.add(transacao);
            }
            System.out.println("Quantidade de transações recuperadas: " + transacoes.size());

        } catch (SQLException e) {
            System.err.println("Erro ao listar transações: " + e.getMessage());
        }
        return transacoes;
    }

    // Buscar transação por ID
    public Transacao buscarPorId(int id) {
        Transacao transacao = null;
        String sql = "SELECT * FROM TRANSACAO WHERE ID_TRANSACAO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transacao = new Transacao();
                    transacao.setIdTransacao(rs.getInt("ID_TRANSACAO"));
                    transacao.setIdConta(rs.getInt("ID_CONTA"));
                    transacao.setValor(rs.getDouble("VALOR"));
                    transacao.setTipoTransacao(rs.getString("TIPO_TRANSACAO"));
                    transacao.setDataTransacao(rs.getDate("DATA_TRANSACAO"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar transação: " + e.getMessage());
        }
        return transacao;
    }

    // Atualizar transação
    public void atualizar(Transacao transacao) {
        String sql = "UPDATE TRANSACAO SET VALOR = ?, TIPO_TRANSACAO = ?, DATA_TRANSACAO = ? WHERE ID_TRANSACAO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, transacao.getValor());
            stmt.setString(2, transacao.getTipoTransacao());
            stmt.setDate(3, new java.sql.Date(transacao.getDataTransacao().getTime()));
            stmt.setInt(4, transacao.getIdTransacao());

            stmt.executeUpdate();
            System.out.println("Transação atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar transação: " + e.getMessage());
        }
    }

    // Deletar transação por ID
    public void deletar(int id) {
        String sql = "DELETE FROM TRANSACAO WHERE ID_TRANSACAO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Transação deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar transação: " + e.getMessage());
        }
    }
}
