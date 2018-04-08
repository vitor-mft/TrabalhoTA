/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import EJB.BeanChat;
import EJB.BeanUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author V_M_FT
 */
@Named (value = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable{
    
    @EJB
    private BeanUsuario beanUsuario;
    
     @EJB
    private BeanChat beanChat;

    public ControleUsuario(){
       // System.out.println("Usou ");
        
    }
    
    public String informarUsuario(){
        beanChat.adicionarUsuario(beanUsuario.getUsuario());
        return "/teste/chat?faces-redirect=true";
    }
    
     public void removerUsuario(){
        beanChat.removerUsuario(beanUsuario.getUsuario());
        //return "/index/chat?faces-redirect=true";
    }
    
    
    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
    
}
