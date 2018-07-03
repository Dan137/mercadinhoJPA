/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.teste;

import controller.ControlerUsuario;
import model.entidade.Usuario;

/**
 *
 * @author Daniel
 */
public class TesteUsuario {

    public static void main(String[] args) {
        ControlerUsuario uc = new ControlerUsuario();

//        ======================CADASTRA NOVO USUARIO =====================
        Usuario u = new Usuario(null,"daniel", "1234 ", "email");
        uc.cadUsuario(u);

//        ======================TESTE LOGIN DO USUARIO=====================
        
//        System.out.println(uc.logar("yz132", "daniel"));
    }
}
