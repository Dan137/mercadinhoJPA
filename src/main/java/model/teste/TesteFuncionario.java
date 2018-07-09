/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teste;

import controller.ControlerFuncionario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.entidade.Endereco;
import model.entidade.Funcionario;

/**
 *
 * @author Daniel
 */
public class TesteFuncionario {

    public static void main(String[] args) {
        Date dataAdmissao = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(dataAdmissao);

        ControlerFuncionario cf = new ControlerFuncionario();

//        ===================CADASTRO DE FUNCIONARIO===================
//        Endereco e = new Endereco("capitão pedro rodrigues", 112, "brasilia", "5535656", "Paranatama");
//        Funcionario f = new Funcionario(null, "Wevisson", "daniel.verissimo123dnl@gmail.com", "(87) 9.81355794", dataAdmissao, e);
//        cf.cadFuncionario(f);
//        ===================ATUALIZAÇÃO DE FUNCIONARIO===================
//          Endereco e = new Endereco("Rua", 113, "centro", "2121454", "sao joao");
//          Funcionario f = new Funcionario(20, "Maycon", "mayconkdfkd@gkdd", "2454254545", dataAdmissao, e);
//          cf.apdtFuncionario(f);
//        ===================LISTA PELO ID===================
//          Funcionario f = cf.procurarForId(20);
//          String str=" ";
//          str+= f.getEmail()+"\n"
//                  + f.getNome()+"\n"
//                  + f.getTelefone()+"\n"
//                  + f.getDataAdmissao()+"\n"
//                  + f.getDataAdmissao()+"\n"
//                  + f.getId()+"\n"
//                  + f.getEndereco().getBairro()+"\n"
//                  + f.getEndereco().getCep()+"\n"
//                  + f.getEndereco().getCidade()+"\n"
//                  + f.getEndereco().getNumero()+"\n"
//                  + "==================================";
//          
//          System.out.println(str);
//        ===================LISTAR FUNCIONARIOS===================
//        List<Funcionario> lista = cf.listFuncionarios();
//        String str = " ";
//        for (Funcionario f : lista) {
//            str += f.getEmail() + "\n"
//                    + f.getNome() + "\n"
//                    + f.getTelefone() + "\n"
//                    + f.getDataAdmissao() + "\n"
//                    + f.getDataAdmissao() + "\n"
//                    + f.getId() + "\n"
//                    + f.getEndereco().getBairro() + "\n"
//                    + f.getEndereco().getCep() + "\n"
//                    + f.getEndereco().getCidade() + "\n"
//                    + f.getEndereco().getNumero() + "\n"
//                    + "==================================";
//        }
//        System.out.println(str);
//        ===================REMOVER FUNCIONARIO===================
        Funcionario fun = cf.procurarForId(20);
        cf.excluirFuncionario(fun);

    }
}
