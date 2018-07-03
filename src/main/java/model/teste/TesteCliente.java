/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teste;

import controller.ControlerCliente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entidade.Cliente;
import model.entidade.Endereco;

/**
 *
 * @author Daniel
 */
public class TesteCliente {
    
    public static void main(String[] args) {
        ControlerCliente cc = new ControlerCliente();
        Date dataAbertura = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(dataAbertura);

//        ===================== CADASTRA UM CLIENTE =========================
//        Endereco e = new Endereco("rua c", 10, "centro", "Paranatama", "55355000");
//        Cliente c = new Cliente(null, "Daniel", dataAbertura, "703.968.604.00", "Daniel.verissimo123dnl@gmail.com", "(87)9.8135-5794", e);
//        cc.cadCliente(c);
//        ===================== ALTERAR CLIENTE =========================
//        Endereco e = new Endereco("Rua manoel rodrigues", 12, "centro", "Sao joão", "0000000");
//        Cliente c = new Cliente(186, "maycon", dataAbertura, "54545545", "maycon@may", "(87)9.8135-5794", e);
//        cc.updateCliente(c);
//        ===================== RETORNA UM CLIENTE ==========================
//        Cliente c = cc.obterCliente(119);
//        System.out.println(c.toString());
//        ===================== RETORNA TODOS OS CLIENTES====================
//          List <Cliente> clientes = cc.obterClientes();
//          String str="";
//          for(Cliente c : clientes){
//              str+=c.getCpf()+"\n"
//                      + c.getEmail()+"\n"
//                      + c.getTelefone()+"\n etc...\n"
//                      + c.getCodigo()+"\n"
//                      + "==============";
//              
//          }
//          System.out.println(str);
// deletar cliente
//        Cliente c = cc.obterCliente(205);
//        cc.deletarCliente(c);

//==========================BUSCA PELO CPF ============================
    Cliente c;
   c= cc.findForCpf("");
        System.out.println(c.toString());
    }
}
