package br.com.senai.aprendercrescer.Controller;

import br.com.senai.aprendercrescer.Dao.UsuarioDao;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Web;

/**
 *
 * @author Daniel
 */
public class UsuarioController {

    UsuarioDao usuarioDao;

    public UsuarioController() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
    }

    public boolean insereUsuario(Web usuario) {
        usuarioDao.gravar(usuario);
        return true;
    }

    public ArrayList<Web> getUsuarios() {
        return usuarioDao.getall();
    }

    public boolean deleteUsuario(int id) {
        Web wb = new Web(id);
        usuarioDao.apagar(wb);
        return true;
    }
}