package com.fiap.tiopadinhas.model;

import java.util.Date;

public class Transacao {

    private int idTransacao;    // ID da transação
    private int idConta;        // ID da conta associada à transação
    private double valor;       // Valor da transação
    private String tipoTransacao; // Alterado de 'tipo' para 'tipoTransacao'
    private Date dataTransacao; // Data da transação

    // Construtor padrão
    public Transacao() {
    }

    // Getters and Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoTransacao() {  // Alterado para 'getTipoTransacao'
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {  // Alterado para 'setTipoTransacao'
        this.tipoTransacao = tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    // Método toString para exibir as informações da transação
    @Override
    public String toString() {
        return "Transacao{idTransacao=" + idTransacao + ", idConta=" + idConta + ", valor=" + valor + ", tipoTransacao='" + tipoTransacao + '\'' + ", dataTransacao=" + dataTransacao + '}';
    }
}
