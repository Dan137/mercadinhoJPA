/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import Util.Messages;
import java.io.Serializable;
import model.ProdutoModel;
import model.entidade.Produto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class ControlerProduto implements Serializable {

    private Produto produto;
    private ProdutoModel produtomodel;
    private Produto selectProduto = new Produto();

    public ControlerProduto() {
        this.produto = new Produto();
        this.produtomodel = new ProdutoModel();
        this.selectProduto = selectProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getSelectProduto() {
        return selectProduto;
    }

    public void setSelectProduto(Produto selectProduto) {
        this.selectProduto = selectProduto;
    }

    public void inserir(Produto produto) {
        try {
           
            produtomodel.cadProdModel(produto);
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso", null);
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
    }

    public void alterar(Produto produto) {
        try {
            this.produtomodel.atualizarProduto(produto);
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "Produto atualizado com sucesso", null);
        } catch (Erros ex) {
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
    }

    public void excluir(Produto produto) {
        try {
            this.produtomodel.removerProduto(produto);
            Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_INFO, "Produto excluido com sucesso", null);
        } catch (Erros ex) {
           Messages.getInstance().adicionarMensagem(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
        }
    }

    public Produto findId(int codigo) {
        return produtomodel.findProduto(codigo);
    }

    public List<Produto> listarProdutos() {
        return this.produtomodel.listarProdutos();
    }

}
