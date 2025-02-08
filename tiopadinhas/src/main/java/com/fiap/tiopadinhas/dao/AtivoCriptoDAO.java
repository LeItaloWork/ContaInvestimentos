package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.AtivoCripto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtivoCriptoDAO {

    // Inserir um novo AtivoCripto
    public void inserir(AtivoCripto ativoCripto) {
        String sql = "INSERT INTO ATIVOCRIPTO (NOME, SIMBOLO, VALOR_ATUAL) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ativoCripto.getNome());
            stmt.setString(2, ativoCripto.getSimbolo());
            stmt.setDouble(3, ativoCripto.getValorAtual());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os AtivosCripto
    public List<AtivoCripto> listar() {
        List<AtivoCripto> ativos = new ArrayList<>();
        String sql = "SELECT * FROM ATIVOCRIPTO";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AtivoCripto ativo = new AtivoCripto();
                ativo.setIdAtivo(rs.getInt("ID_ATIVO"));
                ativo.setNome(rs.getString("NOME"));
                ativo.setSimbolo(rs.getString("SIMBOLO"));
                ativo.setValorAtual(rs.getDouble("VALOR_ATUAL"));
                ativos.add(ativo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ativos;
    }

    // Buscar um AtivoCripto por ID
    public AtivoCripto buscarPorId(int id) {
        AtivoCripto ativo = null;
        String sql = "SELECT * FROM ATIVOCRIPTO WHERE ID_ATIVO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ativo = new AtivoCripto();
                    ativo.setIdAtivo(rs.getInt("ID_ATIVO"));
                    ativo.setNome(rs.getString("NOME"));
                    ativo.setSimbolo(rs.getString("SIMBOLO"));
                    ativo.setValorAtual(rs.getDouble("VALOR_ATUAL"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ativo;
    }

    // Atualizar os dados de um AtivoCripto
    public void atualizar(AtivoCripto ativoCripto) {
        String sql = "UPDATE ATIVOCRIPTO SET NOME = ?, SIMBOLO = ?, VALOR_ATUAL = ? WHERE ID_ATIVO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ativoCripto.getNome());
            stmt.setString(2, ativoCripto.getSimbolo());
            stmt.setDouble(3, ativoCripto.getValorAtual());
            stmt.setInt(4, ativoCripto.getIdAtivo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar um AtivoCripto por ID
    public void deletar(int id) {
        String sql = "DELETE FROM ATIVOCRIPTO WHERE ID_ATIVO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
