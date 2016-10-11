/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Senai
 */
@Entity
@Table(name = "web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Web.findAll", query = "SELECT w FROM Web w"),
    @NamedQuery(name = "Web.findByIdusuario", query = "SELECT w FROM Web w WHERE w.idusuario = :idusuario"),
    @NamedQuery(name = "Web.findByLogin", query = "SELECT w FROM Web w WHERE w.login = :login"),
    @NamedQuery(name = "Web.findBySenha", query = "SELECT w FROM Web w WHERE w.senha = :senha"),
    @NamedQuery(name = "Web.findByNome", query = "SELECT w FROM Web w WHERE w.nome = :nome"),
    @NamedQuery(name = "Web.findByFlagnativo", query = "SELECT w FROM Web w WHERE w.flagnativo = :flagnativo"),
    @NamedQuery(name = "Web.findByDtalteracao", query = "SELECT w FROM Web w WHERE w.dtalteracao = :dtalteracao")})
public class Web extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flagnativo")
    private Character flagnativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtalteracao")
    @Temporal(TemporalType.DATE)
    private Date dtalteracao;

    public Web() {
    }

    public Web(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Web(Integer idusuario, String login, String senha, String nome, Character flagnativo, Date dtalteracao) {
        this.idusuario = idusuario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.flagnativo = flagnativo;
        this.dtalteracao = dtalteracao;
    }

    public Integer getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Integer idusuario) {
        this.idusuario = idusuario;
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

    public Character getFlagnativo() {
        return flagnativo;
    }

    public void setFlagnativo(Character flagnativo) {
        this.flagnativo = flagnativo;
    }

    public Date getDtalteracao() {
        return dtalteracao;
    }

    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Web)) {
            return false;
        }
        Web other = (Web) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senai.aprendercrescer.model.banco.Web[ idusuario=" + idusuario + " ]";
    }

    @Override
    public boolean isNew() {
        if (idusuario == null) {
            return true;
        } else {
            return false;
        }
    }
}
