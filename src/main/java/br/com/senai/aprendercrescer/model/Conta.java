package br.com.senai.aprendercrescer.model;

/**
 *
 * @author Senai
 */
public class Conta {
    private int idconta;
    private String descricao;
    private String tipoconta;
    private int valor;

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
