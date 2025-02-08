package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    // Inserir uma nova empresa no banco de dados
    public void inserir(Empresa empresa) {
        String sql = "INSERT INTO EMPRESA (NOME, ID_USUARIO, CNPJ, SETOR) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empresa.getNome());
            stmt.setInt(2, empresa.getIdUsuario());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getSetor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar empresa por ID
    public Empresa buscarPorId(int id) {
        Empresa empresa = null;
        String sql = "SELECT * FROM EMPRESA WHERE ID_EMPRESA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    empresa = new Empresa();
                    empresa.setIdEmpresa(rs.getInt("ID_EMPRESA"));
                    empresa.setNome(rs.getString("NOME"));
                    empresa.setIdUsuario(rs.getInt("ID_USUARIO"));
                    empresa.setCnpj(rs.getString("CNPJ"));
                    empresa.setSetor(rs.getString("SETOR"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    // Atualizar empresa
    public void atualizar(Empresa empresa) {
        String sql = "UPDATE EMPRESA SET NOME = ?, ID_USUARIO = ?, CNPJ = ?, SETOR = ? WHERE ID_EMPRESA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empresa.getNome());
            stmt.setInt(2, empresa.getIdUsuario());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getSetor());
            stmt.setInt(5, empresa.getIdEmpresa());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar empresa por ID
    public void deletar(int id) {
        String sql = "DELETE FROM EMPRESA WHERE ID_EMPRESA = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as empresas
    public List<Empresa> listar() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM EMPRESA";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("ID_EMPRESA"));
                empresa.setNome(rs.getString("NOME"));
                empresa.setIdUsuario(rs.getInt("ID_USUARIO"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setSetor(rs.getString("SETOR"));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }
}
