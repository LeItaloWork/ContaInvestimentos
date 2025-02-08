package com.fiap.tiopadinhas.model;

public class ParticipacaoInvestimento {
    private int idParticipacao;
    private int idConta;
    private int idAtivo;
    private double quantidade;
    private double valorInvestido;
    private int idUsuario;
    private int idEmpresa;  // Novo campo para empresa associada

    // Construtor
    public ParticipacaoInvestimento() {
    }

    // Getters e Setters
    public int getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(int idAtivo) {
        this.idAtivo = idAtivo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEmpresa() {  // Novo método getter
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {  // Novo método setter
        this.idEmpresa = idEmpresa;
    }
}
