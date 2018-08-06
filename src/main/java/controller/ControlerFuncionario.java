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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.FuncionarioModel;
import model.entidade.Endereco;
import model.entidade.Funcionario;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class ControlerFuncionario implements Serializable{

    private static final long serialVersionUID = 1L;
    private Funcionario funcionario;
    private FuncionarioModel fm;
    private Endereco endereco;
    private Funcionario selectFuncionario;
    
    public ControlerFuncionario() {
        this.endereco=new Endereco();
        this.funcionario = new Funcionario();
        this.fm = new FuncionarioModel();
        this.funcionario.setEndereco(this.endereco);
        this.selectFuncionario = new Funcionario();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcionario getSelectFuncionario() {
        return selectFuncionario;
    }

    public void setSelectFuncionario(Funcionario clienteAux) {
        this.selectFuncionario = clienteAux;
    }
    
//    ============CRUD DO FUNCIONARIO==================
    public void cadFuncionario(Funcionario f) {
        try {
          
            this.fm.cadFuncionarioModel(f);
        } catch (Erros ex) {
            Logger.getLogger(ControlerFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apdtFuncionario(Funcionario f) {
        try {
            this.fm.updatFuncionarioModel(f);
        } catch (Erros ex) {
            Logger.getLogger(ControlerFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Funcionario procurarForId(int id) {
        return this.fm.findIDModel(id);
    }
    
    public List<Funcionario> listFuncionarios(){
        return this.fm.listFuncionariosModel();
    }
    
    public void excluirFuncionario(Funcionario f){
        try {
            this.fm.excluirFuncionarioModel(f);
        } catch (Erros ex) {
            Logger.getLogger(ControlerFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
