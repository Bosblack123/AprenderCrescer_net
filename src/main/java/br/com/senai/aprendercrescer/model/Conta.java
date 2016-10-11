/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Senai
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByIdconta", query = "SELECT c FROM Conta c WHERE c.idconta = :idconta"),
    @NamedQuery(name = "Conta.findByDescricao", query = "SELECT c FROM Conta c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Conta.findByTipoconta", query = "SELECT c FROM Conta c WHERE c.tipoconta = :tipoconta"),
    @NamedQuery(name = "Conta.findByValor", query = "SELECT c FROM Conta c WHERE c.valor = :valor")})
public class Conta extends AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconta")
    private Integer idconta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoconta")
    private String tipoconta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private double valor;

    public Conta() {
    }

    public Conta(Integer idconta) {
        this.idconta = idconta;
    }

    public Conta(Integer idconta, String descricao, String tipoconta) {
        this.idconta = idconta;
        this.descricao = descricao;
        this.tipoconta = tipoconta;
    }

    public Integer getIdconta() {
        return idconta;
    }

    public void setIdconta(Integer idconta) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconta != null ? idconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.idconta == null && other.idconta != null) || (this.idconta != null && !this.idconta.equals(other.idconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senai.aprendercrescer.model.banco.Conta[ idconta=" + idconta + " ]";
    }

    @Override
    public boolean isNew() {
        if (idconta == null) {
            return true;
        } else {
            return false;
        }
    }
    
}
