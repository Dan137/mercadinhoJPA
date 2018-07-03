/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import Util.Messages;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Transient;
import model.UsuarioModel;
import model.entidade.Usuario;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class ControlerUsuario implements Serializable {

    private Usuario usuario;
    private transient UsuarioModel usuarioM;

    public ControlerUsuario() {
        this.usuario = new Usuario();
        this.usuarioM = new UsuarioModel();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cadUsuario(Usuario us) {
        try {
            this.usuarioM.inserirUsuario(us);
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "usuario cadastrado com sucesso", null);
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
    }

    public Usuario findUsuario(Integer codigo) {
        return this.usuarioM.findUsuario(codigo);
    }

    public String logar(String senha, String user) {
        Usuario us = this.usuarioM.logar(senha, user);
        if (us == null) {

            return "/index.xhtml";
        }
        return "/templates/template.xhtml";
    }
}
