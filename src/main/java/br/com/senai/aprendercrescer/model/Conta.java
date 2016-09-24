package br.com.senai.aprendercrescer.model;

/**
 *
 * @author Senai
 */
public class Conta {
    private int idconta;
    private String descricao;
    private String tipoconta;
    private double valor;

    public int getIdconta() {
        return idconta;
    }

    public void setIdconta(int idconta) {
        this.idconta = idconta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(String tipoconta) {
        this.tipoconta = tipoconta;
    }
        public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
