package br.com.senai.aprendercrescer.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
           try{
            conexao = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/acweb", 
                    "postgres", 
                    "postgres");
           }catch(SQLException ex){
               System.out.println("Erro Conexo Banco"+ex);
           }
        }
        return conexao;
    }

}
