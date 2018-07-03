/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import Util.Messages;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FuncionarioModel;
import model.entidade.Funcionario;

/**
 *
 * @author Daniel
 */
public class ControlerFuncionario {

    private Funcionario funcionario;
    private FuncionarioModel fm;

    public ControlerFuncionario() {
        this.funcionario = new Funcionario();
        this.fm = new FuncionarioModel();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
