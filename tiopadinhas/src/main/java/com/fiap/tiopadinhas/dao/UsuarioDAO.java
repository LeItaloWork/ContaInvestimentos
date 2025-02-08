package com.fiap.tiopadinhas.dao;

import com.fiap.tiopadinhas.model.Usuario;
import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para inserir um usuário no banco de dados
    public void inserir(Usuario usuario) {
        if (emailExiste(usuario.getEmail())) {
            throw new RuntimeException("Erro: O e-mail '" + usuario.getEmail() + "' já está em uso.");
        }

        String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, TIPO_USUARIO) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipoUsuario().toUpperCase());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long idUsuario = generatedKeys.getLong(1);
                        usuario.setIdUsuario((int) idUsuario);
                        System.out.println("Usuário adicionado com sucesso. ID: " + idUsuario);
                    } else {
                        System.err.println("Erro: Nenhum ID foi gerado.");
                    }
                }
            } else {
                System.err.println("Erro: Nenhum registro foi inserido.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Erro: Violação de integridade - " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }






    // Método para verificar se o e-mail já existe no banco
    private boolean emailExiste(String email) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE EMAIL = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar e-mail", e);
        }
        return false;
    }

    // Método para buscar um usuário por ID
    public Usuario buscarPorId(int idUsuario) {
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
        Usuario usuario = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                    usuario.setNome(rs.getString("NOME"));
                    usuario.setEmail(rs.getString("EMAIL"));
                    usuario.setSenha(rs.getString("SENHA"));
                    usuario.setTipoUsuario(rs.getString("TIPO_USUARIO"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por ID", e);
        }

        return usuario;
    }

    // Método para listar todos os usuários
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setTipoUsuario(rs.getString("TIPO_USUARIO"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários", e);
        }
        return usuarios;
    }

    // Método para deletar um usuário por ID
    public void deletar(int idUsuario) {
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Erro: Usuário não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário", e);
        }
    }
}
