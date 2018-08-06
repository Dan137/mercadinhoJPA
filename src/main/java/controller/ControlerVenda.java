/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ItemVendaModel;
import model.VendaModel;
import model.entidade.Cliente;
import model.entidade.ItemVenda;
import model.entidade.Produto;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "vendaBean")
@SessionScoped
public class ControlerVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    private Venda venda;
    private ItemVenda itemVenda;
    private VendaModel vm;
    private ItemVendaModel ivm;
    private Produto produto;
    
    public ControlerVenda() {
        this.venda = new Venda();
        this.venda.setCliente_id(new Cliente());
        this.produto = new Produto();
        this.itemVenda = new ItemVenda();
        this.itemVenda.setProduto(this.produto);
        this.ivm = new ItemVendaModel();
        this.vm = new VendaModel();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

//    ======================= NO QUE SE REFERE A ITEM VENDA ====================
    public void cadItemVenda(Integer codigo) {
        
        try {
            List<Produto> produtos = new ArrayList();
                        
            ControlerProduto cv = new ControlerProduto();

            this.produto = cv.findId(codigo);

            ItemVenda iv = new ItemVenda(null, 1, this.produto, null);
            
            produtos.add(this.produto);
            this.ivm.persistItem(iv);

            this.itemVenda.setListProdutos(produtos);
            
        } catch (Erros ex) {
            Logger.getLogger(ControlerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altItemVenda(ItemVenda item) {
        try {
            this.ivm.changeItens(item);
        } catch (Erros ex) {
            Logger.getLogger(ControlerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ItemVenda> todosItens() {
        return this.ivm.buscarTodosItens();
    }

//    ======================= NO QUE SE REFERE A VENDA =========================
    public void cadVenda(Venda vend) {
        try {
            
            
            this.vm.persistVendaModel(vend);
        } catch (Erros ex) {
            Logger.getLogger(ControlerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altVenda(Venda venda) {
        try {
            this.vm.updateVenda(venda);
        } catch (Erros ex) {
            Logger.getLogger(ControlerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Venda findVenda(int codigo) {
        return this.vm.buscarVenda(codigo);
    }

    public List<Venda> findAllvendas() {
        return this.vm.buscarVendas();
    }

    public void deletarVenda(Venda venda) {
        try {
            this.vm.deletarVenda(venda);
        } catch (Erros ex) {
            Logger.getLogger(ControlerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
