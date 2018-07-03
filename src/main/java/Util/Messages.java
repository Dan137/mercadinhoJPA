/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */

public class Messages {

    public static Messages messages;

    private Messages() {
        
    }

    public static Messages getInstance() {
        if (messages == null) {
            messages = new Messages();
        }
        return messages;
    }

    
    
    public void adicionarMensagem(FacesMessage.Severity tipoErro, String sumario, String detalhe){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
         
    }
    
   

}
