/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import Util.Messages;
import controller.ControlerProduto;
import controller.ControlerVenda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.VendaDao;
import model.entidade.ItemVenda;
import model.entidade.Produto;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
public class VendaModel {

//    realizar a venda
    public void persistVendaModel(Venda venda) throws Erros{
        double valorT = 0;

        for (int i = 0; i < venda.getItemvenda().size(); i++) {
            venda.getItemvenda().get(i).setIdItem(null);
            valorT += venda.getItemvenda().get(i).getProduto().getPreco();
        }

        venda.setValorTot(valorT);
        VendaDao.getInstance().inserir(venda);

//        quero listar todas as vendas para setar na lista de itens da tabela Vendas
        ControlerVenda cv = new ControlerVenda();

        List<Venda> lstVenda = cv.findAllvendas();
        List<ItemVenda> lstItemVenda = cv.todosItens();
        for (int i = 0; i < lstItemVenda.size(); i++) {
            if (lstItemVenda.get(i).getCodvend() == null) {
                lstItemVenda.get(i).setCodvend(lstVenda.get(lstVenda.size() - 1));
//                altera o codvenda de null, para o codigo da ultima venda cadastrada
                cv.altItemVenda(lstItemVenda.get(i));

            }
        }
//        atualiza a quantidade de produtos no estoque
        cv.baixaDeProdutos(venda.getItemvenda());

    }

//    atualiza uma venda
    public void updateVenda(Venda venda) throws Erros {
       
            VendaDao.getInstance().alterar(venda); 
        
    }

//    recuperar uma venda pelo id
    public Venda buscarVenda(int codigo) {

        return (Venda) VendaDao.getInstance().recuperar(codigo);

    }

//    lista todos
    public List<Venda> buscarVendas() {

        return VendaDao.getInstance().recuperarTodos();

    }

//    deletar
    public void deletarVenda(Venda venda) throws Erros {
       
            VendaDao.getInstance().deletar(venda);
       
    }
//    atualizar a quantidade no estoque do mercadinho

    public void updatQuantProdutos(List<ItemVenda> iv) {
        ControlerProduto cp = new ControlerProduto();
        ControlerVenda cv = new ControlerVenda();

        List<Produto> produtos = cp.listarProdutos();
        for (int i = 0; i < iv.size(); i++) {
            for (int j = 0; j < produtos.size(); j++) {
                if (iv.get(i).getProduto().getCodigo().equals(produtos.get(j).getCodigo())) {
                    produtos.get(j).setQuantidade(produtos.get(j).getQuantidade() - 1);
                    cp.alterar(produtos.get(j));
                }
            }
        }
    }

}
