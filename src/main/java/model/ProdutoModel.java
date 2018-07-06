/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import model.DAO.ProdutoDAO;
import model.entidade.Produto;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ProdutoModel {

    public void cadProdModel(Produto produto) throws Erros {
        if (produto.getNome().equals("")) {
            throw new Erros("Produto Vazio");
        } else if (produto.getQuantidade() <= 0) {
            throw new Erros("quantidade não pode ser negativa");
        } else if (produto.getPreco() <= 0) {
            throw new Erros("preço não pode ser negativo");
        } else {
            ProdutoDAO.getInstance().inserir(produto);
        }

    }

    public Produto findProduto(int codigo) {

        return (Produto) ProdutoDAO.getInstance().recuperar(codigo);

    }

    public void atualizarProduto(Produto produto) throws Erros {
        if (findProduto(produto.getCodigo()) == null) {
            throw new Erros("produto não existe");
        } else {
            ProdutoDAO.getInstance().alterar(produto);
        }

    }

    public List<Produto> listarProdutos() {
        return ProdutoDAO.getInstance().recuperarTodos();
    }

    public void removerProduto(Produto produto) throws Erros {

        ProdutoDAO.getInstance().deletar(produto);

    }
}
