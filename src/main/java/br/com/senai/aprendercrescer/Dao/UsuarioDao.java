package br.com.senai.aprendercrescer.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
            rs = st.executeQuery("SELECT  IDUSUARIO, LOGIN,"
                    + " SENHA, NOME, DTALTERACAO,"
                    + "FLAGNATIVO FROM WEB WHERE IDUSUARIO = " + id);
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
                    + "senha, nome, dtalteracao, flagnativo)"
                    + "VALUES (" + usuario.getIdusuario()
                    + ", '" + usuario.getLogin()
                    + "' , '" + usuario.getSenha()
                    + "' , '" + usuario.getNome()
                    + "' , '" + data.toString()
                    + "', 'F')";
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
        String sql = "UPDATE web SET "
                + "idusuario=" + usuario.getIdusuario() + ", "
                + "login='" + usuario.getLogin() + "',"
                + "senha='" + usuario.getSenha() + "', "
                + "nome='" + usuario.getNome() + "', "
                + "dtalteracao='" + data + "', "
                + "flagnativo='"+ usuario.getFlagnativo()+"'"
                + "WHERE idusuario=" + usuario.getIdusuario() + ";";
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
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, LOGIN,"
                    + " SENHA, NOME,DTALTERACAO,"
                    + "FLAGNATIVO FROM WEB ORDER BY IDUSUARIO");
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("IDUSUARIO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setFlagnativo(rs.getString("FLAGNATIVO").toCharArray()[0]);
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM WEB WHERE IDUSUARIO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }

}
