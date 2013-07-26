/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean.utils;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class AbstractBean {
    
    @ManagedProperty("#{sessionScope}")
    private Map session;
    @ManagedProperty("#{requestScope}")
    private Map request;
    @ManagedProperty("#{facesContext}")
    private FacesContext facesContext;

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public Map getRequest() {
        return request;
    }

    public void setRequest(Map request) {
        this.request = request;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }
    
    
    
}
