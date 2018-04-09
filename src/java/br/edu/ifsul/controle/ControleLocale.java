
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
/**
 *
 * @author V_M_FT
 */
@ManagedBean(name = "controleLocale")
@javax.faces.bean.SessionScoped
public class ControleLocale implements Serializable {

    private Locale currentLocale = new Locale("pt", "BR");

    public ControleLocale() {
    }
    
    public void englishLocale(){
        UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = Locale.US;
        uiViewRoot.setLocale(currentLocale);
    }
        
    public void portugueseLocale(){
        UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("pt", "BR");
        uiViewRoot.setLocale(currentLocale);
    }    
    
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
}
