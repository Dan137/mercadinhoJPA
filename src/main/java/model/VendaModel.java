/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import Util.Messages;
import controller.ControlerCliente;
import controller.ControlerProduto;
import controller.ControlerVenda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.VendaDao;
import model.entidade.Cliente;
import model.entidade.ItemVenda;
import model.entidade.Produto;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
public class VendaModel {

//    realizar a venda
    public void persistVendaModel(Venda venda) throws Erros {
        double valorT = 0;
        Date dataHoj = new Date();
        if (venda.getFormapagamento().contains("vista")) {
            venda.setCliente_id(null);
        } else {
            ControlerCliente cc = new ControlerCliente();
            Cliente c = cc.findForCpf(venda.getCliente_id().getCpf());
        }
//        formata data da venda
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String prazoPagamento = sdf.format(dataHoj);

        venda.setDataVenda(dataHoj);

//        quero listar todas as vendas para setar na lista de itens da tabela Vendas
        ControlerVenda cv = new ControlerVenda();

        List<Venda> lstVenda = cv.findAllvendas();
        List<ItemVenda> lstItemVenda = cv.todosItens();
        List<ItemVenda> auxLstItemVenda = new ArrayList();
        
        for (int i = 0; i < lstItemVenda.size(); i++) {
            if (lstItemVenda.get(i).getCodvend() == null) {
                auxLstItemVenda.add(lstItemVenda.get(i));
                lstItemVenda.get(i).setCodvend(lstVenda.get(lstVenda.size() - 1));
//                altera o codvenda de null, para o codigo da ultima venda cadastrada
                cv.altItemVenda(lstItemVenda.get(i));

            }
        }
        
        venda.setItemvenda(auxLstItemVenda);
        //      calcula o valor total
        for (int i = 0; i < venda.getItemvenda().size(); i++) {
            venda.getItemvenda().get(i).setIdItem(null);
            valorT += venda.getItemvenda().get(i).getProduto().getPreco();
        }
        venda.setValorTot(valorT);
        
        VendaDao.getInstance().inserir(venda);

//        atualiza a quantidade de produtos no estoque
        
        updatQuantProdutos(venda.getItemvenda());

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
