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
     @NotBlank(message = "{beanchat.mensagem.notblank}")
     @NotNull(message = "{beanChat.mensagem.notnull}")
       private String msg;
    private List<String> listaUsuarios = new ArrayList<>();
   
   // private String usuario;

    public BeanChat() {
    }

    public Boolean adicionarUsuario(String usuario) {
        System.out.println("Chegou no Adicionar Usuario");
        if (listaUsuarios.contains(usuario)) {
           // FacesMessage msg3 = new FacesMessage("Este Nome de Usuario não está disponivel!");
          //  FacesContext.getCurrentInstance().addMessage(null, msg3);
            return false;
        } else {
            listaUsuarios.add(usuario);
            listaMensagem.add(usuario + " " + Util.getMensagemInternacionalizada("msg.entrou"));
           // FacesMessage msg2 = new FacesMessage("Usuario Adicionado a Lista com Sucesso!");
          //  FacesContext.getCurrentInstance().addMessage(null, msg2);
       return true;
        }
        
    }

     public String removerUsuario(String usuario) {
        //System.out.println("Chegou no Adicionar Usuario");
       listaUsuarios.remove(usuario);
       
       listaMensagem.add(usuario + " " +Util.getMensagemInternacionalizada("msg.saiu")+" "+ " saiu!");
        return "index?faces-redirect=true";
    }

     
     //Nesta Caso Preciso internacionalizar a palavra Disse isso é posivel ? 
     
    public void adicionarMensagem(String usuario) {
       
       // System.out.println("Chegou no Adicionar Mensagem ");
        listaMensagem.add(usuario + " " + Util.getMensagemInternacionalizada("msg.disse")+ " " + msg);
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
