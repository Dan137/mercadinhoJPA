/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Erros;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.DAO.impl.ClienteDaoImpl;
import model.entidade.Cliente;

/**
 *
 * @author Daniel
 */
public class ClienteModel {

    private static ClienteModel instanceCli;

    public static ClienteModel getInstanceCliModel() {
        if (instanceCli == null) {
            instanceCli = new ClienteModel();
        }
        return instanceCli;
    }

    public void cadClienteModel(Cliente cliente) throws Erros {
        cliente.setCodigo(null);

        if (cliente.getCpf().equals("")) {
            throw new Erros("cliente vazio");

        } else if (findForCpf(cliente.getCpf()) != null) {
            throw new Erros("cliente já cadastrado");

//        } else if (cliente.getCpf() == null || cliente.getNome() == null || cliente.getTelefone() == null
//                || cliente.getEndereco().getRua() == null || cliente.getEndereco().getBairro() == null
//                || cliente.getEndereco().getCidade() == null || cliente.getEndereco().getCep() == null) {
//
//            throw new Erros("preencha todos os campos");
//
//        
        } else if (cliente.getEndereco().getNumero() < 1) {
            throw new Erros("digite um numero da casa válido");

        } else {
            Date dateAbert = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(dateAbert);

            cliente.setDataAbertura(dateAbert);

            ClienteDaoImpl.getInstance().inserir(cliente);
        }
    }

    public void alterarClienteModel(Cliente cliente) throws Erros {
        Cliente cli = findForCpf(cliente.getCpf());

        if (cliente == null) {
            throw new Erros("preencha os campos ");

        } else if (cliente.quals(cli)) {
            throw new Erros("nenhum valor alterado");
        } else {
            ClienteDaoImpl.getInstance().alterar(cliente);

        }

    }

    public List<Cliente> findAllClientesModel() {

        return ClienteDaoImpl.getInstance().recuperarTodos();
    }

    public Cliente buscarCliente(int codigo) throws Erros {
        List<Cliente> lista = findAllClientesModel();
        for (Cliente c : lista) {
            if (c.getCodigo() == codigo) {
                return (Cliente) ClienteDaoImpl.getInstance().recuperar(codigo);
            }

        }
        throw new Erros("nenhum cliente cadastrado para o codigo informado");

    }

    public void excluirClient(Cliente c) throws Erros {
        if (c == null) {
            throw new Erros("erroo !");
        } else if (buscarCliente(c.getCodigo()) == null) {
            throw new Erros("nenhum cliente selecionado");
        } else {
            ClienteDaoImpl.getInstance().deletar(c);
        }

    }

    public Cliente findForCpf(String cpf) throws Erros {

        return ClienteDaoImpl.getInstance().recuperarPorCPF(cpf);

    }

}
