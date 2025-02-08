package com.fiap.tiopadinhas.model;

public class AtivoCripto {
    private int idAtivo;
    private String nome;
    private String simbolo;
    private double valorAtual;

    // Getters e Setters
    public int getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(int idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }
}
