/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import Util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.ClienteModel;
import model.entidade.Cliente;
import model.entidade.Endereco;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class ControlerCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private Endereco endereco;
    private Cliente selectCliente;

    public ControlerCliente() {
        this.endereco = new Endereco();
        this.cliente = new Cliente();
        this.selectCliente = new Cliente();
        this.cliente.setEndereco(this.endereco);

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getSelectCliente() {
        return selectCliente;
    }

    public void setSelectCliente(Cliente selectCliente) {
        this.selectCliente = selectCliente;
    }

//    =================CRUD DE CLIENTE====================
    public void cadCliente(Cliente cli) {
        
        try {
            
            ClienteModel.getInstanceCliModel().cadClienteModel(cli);
//            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso", "Cliente cadastrado com sucesso"));
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente Salvo com sucesso", null  );
        } catch (Erros ex) {
    
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);

        }

    }

    public void updateCliente(Cliente cliente) {

        try {
            ClienteModel.getInstanceCliModel().alterarClienteModel(cliente);
             Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente Alterado com sucesso", null  );
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }

    }

    public void deletarCliente(Cliente cliente) {
        try {
            ClienteModel.getInstanceCliModel().excluirClient(cliente);

        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
    }

    public Cliente obterCliente(int codigo) {
        try {
            return ClienteModel.getInstanceCliModel().buscarCliente(codigo);
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
        return null;
    }

    public List<Cliente> obterClientes() {
        return ClienteModel.getInstanceCliModel().findAllClientesModel();

    }

    public Cliente findForCpf(String cpf) {

        try {
            return ClienteModel.getInstanceCliModel().findForCpf(cpf);
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
        return null;

    }

}
