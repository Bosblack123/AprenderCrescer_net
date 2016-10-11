package br.com.senai.aprendercrescer.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Senai
 */
public class Conexao {
    static EntityManager em;
    static EntityManagerFactory emf;
    
    public static EntityManager getConexao(){
        if(em == null){
            emf = Persistence.createEntityManagerFactory("AprenderCrescer");
            em = emf.createEntityManager();
        }
        return em;
    }
}