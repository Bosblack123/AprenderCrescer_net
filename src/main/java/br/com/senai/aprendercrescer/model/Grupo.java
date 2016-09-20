package br.com.senai.aprendercrescer.model;

/**
 *
 * @author Senai
 */

public class Grupo {
    private int idgrupo;
    private String tipousuario;
    private String descricaogrupo;

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
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
}
