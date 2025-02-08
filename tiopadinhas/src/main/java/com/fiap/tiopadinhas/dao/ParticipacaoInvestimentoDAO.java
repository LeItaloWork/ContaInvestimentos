package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.ParticipacaoInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipacaoInvestimentoDAO {

    // Inserir uma nova Participação no Investimento
    public void inserir(ParticipacaoInvestimento participacao) {
        String sql = "INSERT INTO PARTICIPACAOINVESTIMENTO (ID_CONTA, ID_ATIVO, QUANTIDADE) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, participacao.getIdConta());
            stmt.setInt(2, participacao.getIdAtivo());
            stmt.setDouble(3, participacao.getQuantidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar Participação no Investimento por ID
    public ParticipacaoInvestimento buscarPorId(int id) {
        ParticipacaoInvestimento participacao = null;
        String sql = "SELECT * FROM PARTICIPACAOINVESTIMENTO WHERE ID_PARTICIPACAO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    participacao = new ParticipacaoInvestimento();
                    participacao.setIdParticipacao(rs.getInt("ID_PARTICIPACAO"));
                    participacao.setIdConta(rs.getInt("ID_CONTA"));
                    participacao.setIdAtivo(rs.getInt("ID_ATIVO"));
                    participacao.setQuantidade(rs.getDouble("QUANTIDADE"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participacao;
    }

    // Atualizar uma Participação no Investimento
    public void atualizar(ParticipacaoInvestimento participacao) {
        String sql = "UPDATE PARTICIPACAOINVESTIMENTO SET ID_CONTA = ?, ID_ATIVO = ?, QUANTIDADE = ? WHERE ID_PARTICIPACAO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, participacao.getIdConta());
            stmt.setInt(2, participacao.getIdAtivo());
            stmt.setDouble(3, participacao.getQuantidade());
            stmt.setInt(4, participacao.getIdParticipacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar uma Participação no Investimento
    public void deletar(int id) {
        String sql = "DELETE FROM PARTICIPACAOINVESTIMENTO WHERE ID_PARTICIPACAO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as Participações no Investimento
    public List<ParticipacaoInvestimento> listar() {
        List<ParticipacaoInvestimento> participacoes = new ArrayList<>();
        String sql = "SELECT * FROM PARTICIPACAOINVESTIMENTO";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ParticipacaoInvestimento participacao = new ParticipacaoInvestimento();
                participacao.setIdParticipacao(rs.getInt("ID_PARTICIPACAO"));
                participacao.setIdConta(rs.getInt("ID_CONTA"));
                participacao.setIdAtivo(rs.getInt("ID_ATIVO"));
                participacao.setQuantidade(rs.getDouble("QUANTIDADE"));
                participacoes.add(participacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participacoes;
    }
}
