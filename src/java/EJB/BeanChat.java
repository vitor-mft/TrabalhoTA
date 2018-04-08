/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import br.edu.ifsul.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author V_M_FT
 */
@Singleton
public class BeanChat {

    private List<String> listaMensagem = new ArrayList<>();
    @NotBlank (message = "A Mensagem não pode estar em branco! ")
    @NotNull (message = "A Mensagem Não pode ser Nula")
    private String msg;
    private List<String> listaUsuarios = new ArrayList<>();
   
   // private String usuario;

    public BeanChat() {
    }

    public String adicionarUsuario(String usuario) {
        System.out.println("Chegou no Adicionar Usuario");
        if (listaUsuarios.contains(usuario)) {
            FacesMessage msg3 = new FacesMessage("Este Nome de Usuario não está disponivel!");
            FacesContext.getCurrentInstance().addMessage(null, msg3);
        } else {
            listaUsuarios.add(usuario);
            listaMensagem.add(usuario + " entrou!");
            FacesMessage msg2 = new FacesMessage("Usuario Adicionado a Lista com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg2);
        }
        return "/teste/chat?faces-redirect=true";
    }

     public String removerUsuario(String usuario) {
        //System.out.println("Chegou no Adicionar Usuario");
       listaUsuarios.remove(usuario);
       listaMensagem.add(usuario + " saiu!");
        return "index?faces-redirect=true";
    }

    public void adicionarMensagem(String usuario) {
        //isso se faz para ter acesso as msg de Internacionalização
        FacesMessage teste = new FacesMessage(FacesMessage.SEVERITY_INFO,
                Util.getMensagemInternacionalizada("msg.dissee"),"");
        //Aqui deveria mostrar a mensagem que esta dentro do 
        System.out.println(teste);
        System.out.println("Chegou no Adicionar Mensagem ");
        listaMensagem.add(usuario + " disse: " + msg);
        msg = "";
       // return "/teste/chat?faces-redirect=true";
       
    }

    public List<String> getListaMensagem() {
        return listaMensagem;
    }

    public void setListaMensagem(List<String> listaMensagem) {
        this.listaMensagem = listaMensagem;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }

    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
