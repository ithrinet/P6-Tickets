/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.listeners;

import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.view.facelets.FaceletContext;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
public class LoginListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map session = context.getExternalContext().getSessionMap();
        
        Usuario user = (Usuario) session.get("currentUser");
        
        String viewId = context.getViewRoot().getViewId();
        System.out.println(viewId);
        boolean isLoginPage = viewId.indexOf("login.xhtml") != -1;
        
        if( !isLoginPage && user == null){
            NavigationHandler nh = context.getApplication().getNavigationHandler();
            nh.handleNavigation(context, null, "login");
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
      
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
