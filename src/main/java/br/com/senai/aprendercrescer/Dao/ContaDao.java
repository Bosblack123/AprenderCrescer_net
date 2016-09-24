package br.com.senai.aprendercrescer.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Conta;

/**
 *
 * @author Senai
 */
public class ContaDao {

    Statement st;

    public ContaDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Conta getContaByID(int id) {
        ResultSet rs;
        Conta conta;
        try {
            rs = st.executeQuery("SELECT  IDCONTA, DESCRICAO,"
                    + " TIPOCONTA, VALOR"
                    + " FROM CONTA WHERE IDCONTA = " + id);
            while (rs.next()) {
                conta = new Conta();
                conta.setIdconta(rs.getInt("IDCONTA"));
                conta.setDescricao(rs.getString("DESCRICAO"));
                conta.setTipoconta(rs.getString("TIPOCONTA"));
                conta.setValor(rs.getDouble("VALOR"));
                return conta;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereConta(Conta conta) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDCONTA)+1, 1) AS IDCONTA FROM CONTA";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDCONTA");
            }
            conta.setIdconta(id);
            sql = "INSERT INTO conta( idconta, descricao, "
                    + "tipoconta, valor)"
                    + "VALUES (" + conta.getIdconta()
                    + ", '" + conta.getDescricao()
                    + "' , '" + conta.getTipoconta()
                    + "' , " + conta.getValor()
                    + ")";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir conta: " + ex);
        }
        return false;
    }

    public boolean updateConta(Conta conta) {
        String sql = "UPDATE web SET "
                + "idconta=" + conta.getIdconta() + ", "
                + "descricao='" + conta.getDescricao() + "', "
                + "tipoconta='" + conta.getTipoconta() + "', "
                + "valor=" + conta.getValor() + ", "
                + "WHERE idconta= " + conta.getIdconta() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :" + ex);
        }
        return false;
    }

    public ArrayList<Conta> getContas() {
        ResultSet rs;
        Conta conta;
        ArrayList<Conta> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT  IDCONTA, DESCRICAO,"
                    + " TIPOCONTA, VALOR "
                    + "FROM CONTA ORDER BY IDCONTA");
            while (rs.next()) {
                conta = new Conta();
                conta.setIdconta(rs.getInt("IDCONTA"));
                conta.setDescricao(rs.getString("DESCRICAO"));
                conta.setTipoconta(rs.getString("TIPOCONTA"));
                conta.setValor(rs.getDouble("VALOR"));
                lista.add(conta);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteConta(int id) {
        String sql = "DELETE FROM CONTA WHERE IDCONTA = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }
}
