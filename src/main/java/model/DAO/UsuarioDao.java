/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;


import model.entidade.Usuario;

/**
 *
 * @author Daniel
 */
public interface UsuarioDao extends DaoGenerico<Usuario>{
        
    public Usuario autenticar(String senha, String user);
}
