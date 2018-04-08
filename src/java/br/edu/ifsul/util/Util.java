package br.edu.ifsul.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author V_M_FT
 */
public class Util {

    public static String getMensagemInternacionalizada(String messageID) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String msg = "";
        Locale locale;
        if (facesContext != null) {
            locale = facesContext.getViewRoot().getLocale();
        } else {
            locale = new Locale("pt", "BR");
        }
        ResourceBundle bundle
                = ResourceBundle.getBundle("messages", locale);
        try {
            msg = bundle.getString(messageID);
        } catch (Exception e) {
            System.out.println("Não encontrou a mensagem");
            msg = messageID;
        }
        return msg;
    }

}
