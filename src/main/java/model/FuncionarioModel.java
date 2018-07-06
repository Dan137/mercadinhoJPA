/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import java.util.List;

import model.DAO.FuncionarioDao;
import model.entidade.Funcionario;

/**
 *
 * @author Daniel
 */
public class FuncionarioModel {

    public void cadFuncionarioModel(Funcionario funcionario) throws Erros {
        
        FuncionarioDao.getInstance().inserir(funcionario);

    }

    public void updatFuncionarioModel(Funcionario f) throws Erros {
        FuncionarioDao.getInstance().alterar(f);

    }

    public Funcionario findIDModel(int id) {
        Funcionario f = new Funcionario();

        return (Funcionario) FuncionarioDao.getInstance().recuperar(id);

    }

    public List<Funcionario> listFuncionariosModel() {

        return FuncionarioDao.getInstance().recuperarTodos();

    }

    public void excluirFuncionarioModel(Funcionario f) throws Erros{
        
            FuncionarioDao.getInstance().deletar(f);
        
    }
}
