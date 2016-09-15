package br.com.senai.aprendercrescer.model;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Usuario {

    private int idusuario;
    private int idgrupo;
    private String login;
    private String senha;
    private String nome;
    private char flaginativo;
    private Date dtalteracao;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(char flaginativo) {
        this.flaginativo = flaginativo;
    }

    public Date getDtalteracao() {
        return dtalteracao;
    }

    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }
}
