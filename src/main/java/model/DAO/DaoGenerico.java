/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Util.Erros;
import java.util.List;

/**
 *
 * @author Maycon
 */
public interface DaoGenerico<T> {

    public void inserir(T t) throws Erros;

    public void alterar(T t) throws Erros;

    public T recuperar(int codigo);

    public void deletar(T t) throws Erros;

    public List<T> recuperarTodos();

}
