package br.com.senai.aprendercrescer.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Grupo;

/**
 *
 * @author Senai
 */
public class GrupoDao {
    Statement st;

    public GrupoDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Grupo getGrupoByID(int id) {
        ResultSet rs;
        Grupo grupo;
        try {
            rs = st.executeQuery("SELECT IDGRUPO, TIPOUSUARIO,"
                    + " DESCRICAOGRUPO FROM GRUPO WHERE IDGRUPO = " + id);
            while (rs.next()) {
                grupo = new Grupo();
                grupo.setIdgrupo(rs.getInt("IDGRUPO"));
                grupo.setTipousuario(rs.getString("TIPOUSUARIO"));
                grupo.setDescricaogrupo(rs.getString("DESCRICAOGRUPO"));
                return grupo;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereGrupo(Grupo grupo) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDGRUPO)+1, 1) AS IDGRUPO FROM GRUPO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDGRUPO");
            }
            grupo.setIdgrupo(id);
            sql = "INSERT INTO grupo( idgrupo, tipousuario, "
                    + "descricaogrupo)"
                    + " VALUES (" + grupo.getIdgrupo()
                    + ", '" + grupo.getTipousuario()
                    + "', '" + grupo.getDescricaogrupo()
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir grupo: " + ex);
        }
        return false;
    }

    public boolean updateGrupo(Grupo grupo) {
        String sql = "UPDATE web SET "
                + "idgrupo=" + grupo.getIdgrupo() + ", "
                + "tipousuario='" + grupo.getTipousuario() + "',"
                + "descricaogrupo='" + grupo.getDescricaogrupo() + "', "
                + "WHERE idgrupo= " + grupo.getIdgrupo() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :"+ex);
        }
        return false;
    }

    public ArrayList<Grupo> getGrupos() {
        ResultSet rs;
        Grupo grupo;
        ArrayList<Grupo> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT  IDGRUPO, TIPOUSUARIO,"
                    + " DESCRICAOGRUPO FROM GRUPO");
            while (rs.next()) {
                grupo = new Grupo();
                grupo.setIdgrupo(rs.getInt("IDGRUPO"));
                grupo.setTipousuario(rs.getString("TIPOUSUARIO"));
                grupo.setDescricaogrupo(rs.getString("DESCRICAOGRUPO"));
                lista.add(grupo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteGrupo(int id) {
        String sql = "DELETE FROM GRUPO WHERE IDGRUPO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }
}
