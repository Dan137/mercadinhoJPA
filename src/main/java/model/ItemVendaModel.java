/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import Util.Messages;
import controller.ControlerVenda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.ItemVendaDao;
import model.entidade.ItemVenda;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
public class ItemVendaModel {

    private Venda venda;

    public ItemVendaModel() {
        this.venda = new Venda();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

//    ============= CADASTRO DE ITENS =================
    public void persistItem(ItemVenda itemVenda) throws Erros {
            ItemVendaDao.getInstance().inserir(itemVenda);
        
           

    }

//    ============= ALTERAÇÃO DE ITEM =================
    public void changeItens(ItemVenda item) throws Erros {
        
            ItemVendaDao.getInstance().alterar(item);

    }
//    ============= LISTAR TODOS OS ITENS =================

    public List<ItemVenda> buscarTodosItens() {

        return ItemVendaDao.getInstance().recuperarTodos();

    }

}
