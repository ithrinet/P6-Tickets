/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import javax.faces.bean.ManagedBean;
import tickets.bean.utils.AbstractBean;
import tickets.dao.RolDao;
import tickets.pojo.Rol;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class FormRolBean extends AbstractBean {
    
    private RolDao dao;
    private Rol rol;

    public FormRolBean() {
        dao = new RolDao();
    }

    public Rol getRol() {
        rol = (Rol)getSession().get("rol");
        if(rol == null){
            rol = new Rol();
            getSession().put("rol", rol);
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public String save(){
        dao.update(rol);
        getSession().remove("rol");
        return "roles";
    }
    public String cancel(){
        getSession().remove("rol");
        return "roles";
    }
    
    
    
    
}
