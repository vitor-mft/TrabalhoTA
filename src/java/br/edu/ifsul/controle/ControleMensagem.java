package br.edu.ifsul.controle;

import EJB.BeanChat;
import EJB.BeanUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean(name = "controleMensagem")
@SessionScoped
public class ControleMensagem implements Serializable {

    @EJB
    private BeanUsuario beanUsuario;

    @EJB
    private BeanChat beanChat;
    
     @Inject
    private ControleUsuario controleUsuario;

    public ControleMensagem() {

    }
    
      public String getUsuario() {
        return controleUsuario.getBeanUsuario().getUsuario() != null
                ? controleUsuario.getBeanUsuario().getUsuario()
                : "Usuario não informado";
    }
      
      public String escreveMensagem(){
          beanChat.adicionarMensagem(controleUsuario.getBeanUsuario().getUsuario());
          return "/teste/chat?faces-redirect=true";
    
}

    public String listaChat() {
        return "/teste/chat?faces-redirect=true";
    }

    public String inicioChat() {
        return "/index?faces-redirect=true";
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }

}
