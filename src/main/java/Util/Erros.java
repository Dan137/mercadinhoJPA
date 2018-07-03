/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Daniel
 */
// CRIADO
public class Erros extends Exception{

    public Erros(String msg) {
        super(msg);
    }

   public Erros(String msg, Throwable causa){
       super(msg, causa);
   }
}
