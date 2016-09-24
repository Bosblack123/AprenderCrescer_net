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

        if (conta.getIdconta() != 0) {
            return contaDao.updateConta(conta);
        } else {
            return contaDao.insereConta(conta);
        }
    }

    public ArrayList<Conta> getContas() {
        return contaDao.getContas();
    }

    public boolean deleteConta(int id) {
        return contaDao.deleteConta(id);
    }
}
