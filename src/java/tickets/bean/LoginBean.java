/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import tickets.bean.utils.AbstractBean;
import tickets.dao.UsuarioDao;
import tickets.pojo.Rol;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class LoginBean extends AbstractBean{
    
    private String usuario;
    private String password;
    private UsuarioDao dao;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        dao = new UsuarioDao();
        Usuario user =dao.getUser(usuario,password);
        if(user != null){
            getSession().put("currentUser", user);
            switch( user.getRol().getId().intValue()){
                case Rol.ROL_BASICO: return "main";
                case Rol.ROL_TECNICO: return "main"; 
                case Rol.ROL_ADMIN: return "main";
                
            }
            return "main";
        }
        FacesMessage fm = new FacesMessage("Usario y/o password es incorrecto");
        getFacesContext().addMessage(null, fm);
        return null;
    }
    
    
}
