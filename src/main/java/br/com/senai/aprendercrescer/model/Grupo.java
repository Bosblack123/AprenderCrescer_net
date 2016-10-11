/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

import java.io.Serializable;
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
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdgrupo", query = "SELECT g FROM Grupo g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "Grupo.findByTipousuario", query = "SELECT g FROM Grupo g WHERE g.tipousuario = :tipousuario"),
    @NamedQuery(name = "Grupo.findByDescricaogrupo", query = "SELECT g FROM Grupo g WHERE g.descricaogrupo = :descricaogrupo")})
public class Grupo extends AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgrupo")
    private Integer idgrupo;
    @Size(max = 1)
    @Column(name = "tipousuario")
    private String tipousuario;
    @Size(max = 40)
    @Column(name = "descricaogrupo")
    private String descricaogrupo;

    public Grupo() {
    }

    public Grupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getDescricaogrupo() {
        return descricaogrupo;
    }

    public void setDescricaogrupo(String descricaogrupo) {
        this.descricaogrupo = descricaogrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senai.aprendercrescer.model.banco.Grupo[ idgrupo=" + idgrupo + " ]";
    }

    @Override
    public boolean isNew() {
        if (idgrupo == null) {
            return true;
        } else {
            return false;
        }
    }
    
}
