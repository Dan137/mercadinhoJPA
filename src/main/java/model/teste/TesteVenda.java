/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teste;

import controller.ControlerCliente;
import controller.ControlerProduto;
import controller.ControlerVenda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.entidade.Cliente;
import model.entidade.ItemVenda;
import model.entidade.Produto;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
public class TesteVenda {

    public static void main(String[] args) {
        int op = 0;
        int codProd = 0;
        ControlerVenda cv = new ControlerVenda();
        ControlerProduto cp = new ControlerProduto();
        ControlerCliente cc = new ControlerCliente();
        List<ItemVenda> lstItens = new ArrayList<>();

        Venda vend = new Venda();
        Scanner sc = new Scanner(System.in);

        Date dataVenda = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dataVenda);
        do {
            System.out.println("INFORME A OPÇÃO\n"
                    + "1. inserir item \n"
                    + "2. finalizar venda\n"
                    + "3. alterar uma venda\n"
                    + "4. listar todas as vendas\n"
                    + "5. deletar uma venda");
            op = sc.nextInt();
            switch (op) {
                case 1:
//                    solicita ao usuário o codigo do produto vendido
                    System.out.println("informe o codigo do produto");
                    int cod = sc.nextInt();
//                  busca no banco o produto
                    Produto produto = cp.findId(cod);
//                    cria um item
                    ItemVenda iv = new ItemVenda(null, 1, produto, null);
//                    adiciona um item à lista
                    lstItens.add(iv);
//                    cadastra um item no banco
//                    cv.cadItemVenda(iv);
                    break;
                case 2:
//                    seta a lista de itens na classe ItemVenda
                    vend.setItemvenda(lstItens);

//                    System.out.println("informe a forma de pagamento");
//                    String formPagamento = sc.next();
                    System.out.println("informe a matricula do cliente");
                    int matricula = sc.nextInt();

                    
                    vend.setCodVenda(null);
                    vend.setDataPagamento(dataVenda);
                    vend.setDataVenda(dataVenda);
                    vend.setFormapagamento("crédito");
                    vend.setCliente_id(null);

//                    cadastra a venda no banco
                    cv.cadVenda(vend);
                    break;
                case 3:
                    vend.setCodVenda(160);
                    vend.setCliente_id(null);
                    vend.setFormapagamento("vista");
                    vend.setDataPagamento(dataVenda);
                    vend.setDataVenda(dataVenda);
                    cv.altVenda(vend);
                    break;
                case 4:
                    List<Venda> lstVenda = cv.findAllvendas();
                    String str = "";
                    for (Venda ven : lstVenda) {
                        str += ven.getFormapagamento() + "\n"
                                + ven.getFormapagamento() + "\n"
                                + ven.getCliente_id() + "\n"
                                + ven.getDataVenda() + "\n"
                                + ven.getItemvenda() + "\n"
                                + ven.getValorTot() + "\n========";
                    }
                    System.out.println(str);
                    break;

                case 5:
                    Venda v = cv.findVenda(160);
                    cv.deletarVenda(v);
                    
                default:
                    System.out.println("você digitou um valor inválido()");
            }
        } while (op != 2);

    }
}
