/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import tickets.bean.utils.AbstractBean;
import tickets.dao.UsuarioDao;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class Index extends AbstractBean{
    
    private UsuarioDao dao;
    
    public ArrayList<Usuario> getListaUsuarios(){
        Usuario usuario = new Usuario();
        usuario.setNombre("SUPERPATO!!");
        getSession().put("user",usuario);
        dao = new UsuarioDao();
        return (ArrayList<Usuario>)dao.getList();
    }
    
    public String logout(){
        getSession().remove("currentUser");
        return "login";
    }
    
}
