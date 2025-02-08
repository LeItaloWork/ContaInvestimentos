package com.fiap.tiopadinhas.test;

import com.fiap.tiopadinhas.model.*;
import com.fiap.tiopadinhas.storage.Storage;

public class TestStorage {

    public static void main(String[] args) {
        // Criando objetos de teste
        Usuario usuario1 = new Usuario("João", "joao@exemplo.com", "senha123", "Admin");
        Usuario usuario2 = new Usuario("Maria", "maria@exemplo.com", "senha456", "User");

        // Definindo IDs manualmente para os testes
        usuario1.setIdUsuario(1);
        usuario2.setIdUsuario(2);

        // Adicionando usuários ao Storage
        Storage.adicionarUsuario(usuario1);
        Storage.adicionarUsuario(usuario2);

        // Criando objetos de empresas para associar aos usuários
        Empresa empresa1 = new Empresa(1, "Empresa X", 1, "12.345.678/0001-99", "Tecnologia");
        Empresa empresa2 = new Empresa(2, "Empresa Y", 2, "98.765.432/0001-11", "Saúde");

        // Adicionando empresas ao Storage
        Storage.adicionarEmpresa(empresa1);
        Storage.adicionarEmpresa(empresa2);

        // Teste: listando os usuários e empresas
        System.out.println("\n=== TESTE DO ARRAYLIST ===");
        Storage.listarUsuarios();  // Listar usuários
        Storage.listarEmpresas();  // Listar empresas
        System.out.println("\n=== FIM DO TESTE DO ARRAYLIST ===\n");
    }
}
