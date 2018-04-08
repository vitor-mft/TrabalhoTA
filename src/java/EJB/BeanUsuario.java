
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author V_M_FT
 */
@Stateful
@StatefulTimeout(value = 1, unit = TimeUnit.MINUTES)
public class BeanUsuario implements Serializable {


     @NotBlank (message = "O Nome do Usuario deve ser informado! ")
    @NotNull (message = "O Usuaroi não pode ser Nulo")
    private String usuario;


  

    public BeanUsuario() {
        System.out.println("Usuou o construtor do bean usuario");
    }

    @PreDestroy
    public void destruir() {
        System.out.println("Eliminou o Bean do Usuario");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
