package br.com.senai.aprendercrescer.Controller;

import br.com.senai.aprendercrescer.Dao.GrupoDao;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Grupo;
/**
 *
 * @author Senai
 */
public class GrupoController {
    GrupoDao grupoDao;

    public GrupoController() {
        if (grupoDao == null) {
            grupoDao = new GrupoDao();
        }
    }

    public boolean insereGrupo(Grupo grupo) {
        grupoDao.gravar(grupo);
        return true;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getall();
    }

    public boolean deleteGrupo(int id) {
        Grupo gp = new Grupo(id);
        grupoDao.apagar(gp);
        return true;
    }
}
