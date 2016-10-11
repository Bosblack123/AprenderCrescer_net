package br.com.senai.aprendercrescer.Controller;

import br.com.senai.aprendercrescer.Dao.ContaDao;
import java.util.ArrayList;
import br.com.senai.aprendercrescer.model.Conta;
/**
 *
 * @author Senai
 */
public class ContaController {
    ContaDao contaDao;

    public ContaController() {
        if (contaDao == null) {
            contaDao = new ContaDao();
        }
    }

    public boolean insereConta(Conta conta) {
        contaDao.gravar(conta);
        return true;
    }

    public ArrayList<Conta> getContas() {
        return contaDao.getall();
    }

    public boolean deleteConta(int id) {
        Conta ct = new Conta(id);
        contaDao.apagar(ct);
        return true;
    }
}
