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

        if (grupo.getIdgrupo() != 0) {
            return grupoDao.updateGrupo(grupo);
        } else {
            return grupoDao.insereGrupo(grupo);
        }
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getGrupos();
    }

    public boolean deleteGrupo(int id) {
        return grupoDao.deleteGrupo(id);
    }
}
