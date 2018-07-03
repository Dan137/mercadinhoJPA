/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import Util.Messages;
import java.util.ArrayList;
import model.DAO.ProdutoDAO;
import model.entidade.Produto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ProdutoModel {

    public void cadProdModel(Produto produto) {
        try {
            ProdutoDAO.getInstance().inserir(produto);
        } catch (Exception e) {
            System.out.println("errooo!" + e);
        }

    }

    public Produto findProduto(int codigo) {

        return (Produto) ProdutoDAO.getInstance().recuperar(codigo);

    }

    public void atualizarProduto(Produto produto) throws Erros{

        ProdutoDAO.getInstance().alterar(produto);

    }

    public List<Produto> listarProdutos() {
        return ProdutoDAO.getInstance().recuperarTodos();
    }

    public void removerProduto(Produto produto) throws Erros{

        ProdutoDAO.getInstance().deletar(produto);

    }
}
