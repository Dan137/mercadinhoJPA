/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import Util.Erros;
import java.util.List;
import model.entidade.Cliente;

/**
 *
 * @author Daniel
 */
public interface ClienteDao extends DaoGenerico<Cliente>{
    
    public Cliente recuperarPorCPF(String cpf) throws Erros;
}
