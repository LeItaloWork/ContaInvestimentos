package com.fiap.tiopadinhas.model;

public class Empresa {

    private int idEmpresa;
    private String nome;
    private int idUsuario;
    private String cnpj;       // Novo campo CNPJ
    private String setor;      // Novo campo Setor

    // Construtor
    public Empresa() {}

    public Empresa(int idEmpresa, String nome, int idUsuario, String cnpj, String setor) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.cnpj = cnpj;
        this.setor = setor;
    }

    // Getters e Setters
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Empresa [idEmpresa=" + idEmpresa + ", nome=" + nome + ", idUsuario=" + idUsuario + ", cnpj=" + cnpj + ", setor=" + setor + "]";
    }
}
