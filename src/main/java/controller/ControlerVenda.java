/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.Erros;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ItemVendaModel;
import model.VendaModel;
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

    public ControlerVenda() {
        this.venda = new Venda();
        this.itemVenda = new ItemVenda();
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

//    ======================= NO QUE SE REFERE A ITEM VENDA ====================
    public void cadItemVenda(Integer codigo) {
        try {
            ControlerProduto cv = new ControlerProduto();
            Produto prod = new Produto();
            prod = cv.findId(codigo);

            ItemVenda iv = new ItemVenda(0, 1, prod, null);
            this.ivm.persistItem(iv);
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

    public void baixaDeProdutos(List<ItemVenda> itens) {
        this.vm.updatQuantProdutos(itens);
    }
}
