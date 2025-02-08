package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.ContaInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoDAO {

    // Inserir uma nova ContaInvestimento
    public void inserir(ContaInvestimento contaInvestimento) {
        String sql = "INSERT INTO CONTAINVESTIMENTO (ID_USUARIO, SALDO, DATA_CRIACAO) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contaInvestimento.getIdUsuario());
            stmt.setDouble(2, contaInvestimento.getSaldo());
            stmt.setDate(3, contaInvestimento.getDataCriacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as contas
    public List<ContaInvestimento> listar() {
        List<ContaInvestimento> contas = new ArrayList<>();
        String sql = "SELECT * FROM CONTAINVESTIMENTO";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ContaInvestimento conta = new ContaInvestimento();
                conta.setIdConta(rs.getInt("ID_CONTA"));
                conta.setIdUsuario(rs.getInt("ID_USUARIO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setDataCriacao(rs.getDate("DATA_CRIACAO"));
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }

    // Atualizar ContaInvestimento
    public void atualizar(ContaInvestimento contaInvestimento) {
        String sql = "UPDATE CONTAINVESTIMENTO SET SALDO = ?, DATA_CRIACAO = ? WHERE ID_CONTA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contaInvestimento.getSaldo());
            stmt.setDate(2, contaInvestimento.getDataCriacao());
            stmt.setInt(3, contaInvestimento.getIdConta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar ContaInvestimento
    public void deletar(int id) {
        String sql = "DELETE FROM CONTAINVESTIMENTO WHERE ID_CONTA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar ContaInvestimento por ID
    public ContaInvestimento buscarPorId(int id) {
        ContaInvestimento conta = null;
        String sql = "SELECT * FROM CONTAINVESTIMENTO WHERE ID_CONTA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    conta = new ContaInvestimento();
                    conta.setIdConta(rs.getInt("ID_CONTA"));
                    conta.setIdUsuario(rs.getInt("ID_USUARIO"));
                    conta.setSaldo(rs.getDouble("SALDO"));
                    conta.setDataCriacao(rs.getDate("DATA_CRIACAO"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conta;
    }
}
