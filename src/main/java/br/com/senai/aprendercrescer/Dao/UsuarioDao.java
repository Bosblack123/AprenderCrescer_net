package br.com.senai.aprendercrescer.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.senai.aprendercrescer.model.Usuario;

/**
 *
 * @author Daniel
 */
public class UsuarioDao {

    Statement st;

    public UsuarioDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Usuario getUsuarioByID(int id) {
        ResultSet rs;
        Usuario usuario;
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, IDGRUPO,LOGIN,"
                    + " SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,"
                    + "FLAGINATIVO FROM WEB WHERE IDUSUARIO = " + id);
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("IDUSUARIO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                return usuario;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereUsuario(Usuario usuario) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDUSUARIO)+1, 1) AS IDUSUARIO FROM WEB";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDUSUARIO");
            }
            usuario.setIdusuario(id);
            sql = "INSERT INTO web( idusuario, login, "
                    + "senhausuario, nomeusuario, dtalteracao, flaginativo)"
                    + "VALUES (" + usuario.getIdusuario()
                    + ", 0, '" + usuario.getLogin()
                    + "' , '" + usuario.getSenha()
                    + "' , '" + usuario.getNome()
                    + "' , '" + data.toString()
                    + "', 'F' )";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean updateUsuario(Usuario usuario) {
        Date data = new Date();
        String sql = "UPDATE usuario SET "
                + "idusuario=" + usuario.getIdusuario() + ", "
                + "login='" + usuario.getLogin() + "',"
                + "senhausuario='" + usuario.getSenha() + "', "
                + "nomeusuario='" + usuario.getNome() + "',"
                + "dtalteracao='" + data + "', "
                + "flaginativo='F' "
                + "WHERE idusuario= " + usuario.getIdusuario() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :"+ex);
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() {
        ResultSet rs;
        Usuario usuario;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, LOGIN,"
                    + " SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,"
                    + "FLAGINATIVO FROM USUARIO ");
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("IDUSUARIO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setNome(rs.getString("NOMEUSUARIO"));
                usuario.setSenha(rs.getString("SENHAUSUARIO"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }

}
