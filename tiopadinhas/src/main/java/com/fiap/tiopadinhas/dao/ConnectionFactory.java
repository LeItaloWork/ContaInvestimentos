package com.fiap.tiopadinhas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USER = "RM551500";
    private static final String PASSWORD = "101094";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão realizada com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
