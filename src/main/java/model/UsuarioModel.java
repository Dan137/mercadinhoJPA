/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Criptografia;
import Util.Erros;
import Util.Messages;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.impl.UsuarioDaoImpl;
import model.entidade.Usuario;

/**
 *
 * @author Daniel
 */
public class UsuarioModel {

    public void inserirUsuario(Usuario usuario) throws Erros {
        usuario.setId_usuario(null);

        if (!(UsuarioDaoImpl.getInstance().recuperarTodos().isEmpty())) {
            throw new Erros("não pode existir mais de um usuario cadastrado");

        } else if (usuario.getSenha().length() < 6 || usuario.getSenha().length() > 8) {
            throw new Erros("senha deverá ter entre 6 e 8 caracteres");

        } else if (usuario.getSenha() == null || usuario.getUser() == null || usuario.getEmail() == null) {
            throw new Erros("preencha todos os campos");
        } else {
            usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
            UsuarioDaoImpl.getInstance().inserir(usuario);
        }
    }

    public Usuario findUsuario(Integer codigo) {
        return UsuarioDaoImpl.getInstance().recuperar(codigo);

    }

    public Usuario logar(String senha, String user) throws Erros {
        Usuario us = new Usuario();
        us.setSenha(Criptografia.criptografar(senha));
        if (UsuarioDaoImpl.getInstance().autenticar(us.getSenha(), user) == null) {
            throw new Erros("usuario ou senha não confere");
        } else {
            return UsuarioDaoImpl.getInstance().autenticar(us.getSenha(), user);
        }
    }
}
