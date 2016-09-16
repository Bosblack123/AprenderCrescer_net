package br.com.senai.aprendercrescer.Controller;

import br.com.senai.aprendercrescer.Dao.UsuarioDao;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Usuario;

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

    public boolean insereUsuario(Usuario usuario) {

        if (usuario.getIdusuario() != 0) {
            return usuarioDao.updateUsuario(usuario);
        } else {
            return usuarioDao.insereUsuario(usuario);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    public boolean deleteUsuario(int id) {
        return usuarioDao.deleteUsuario(id);
    }

}
