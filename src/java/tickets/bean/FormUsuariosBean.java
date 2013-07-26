/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import tickets.bean.utils.AbstractBean;
import tickets.dao.RolDao;
import tickets.dao.UsuarioDao;
import tickets.pojo.Rol;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class FormUsuariosBean extends AbstractBean{
    
    private UsuarioDao dao;
    private RolDao rolDao;
    private Usuario usuario;

    public FormUsuariosBean() {
        dao = new UsuarioDao();
        rolDao = new RolDao();
    }

    public Usuario getUsuario() {
        usuario = (Usuario) getSession().get("usuario");
        if(usuario == null){
            usuario = new Usuario();
            getSession().put("usuario",usuario);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public ArrayList<SelectItem> getOpciones(){
        ArrayList<SelectItem> al = new ArrayList<SelectItem>();
        al.add(new SelectItem(true, "Hombre"));
        al.add(new SelectItem(false, "Mujer"));
        return al;
    }
    
    public ArrayList<SelectItem> getRoles(){
        ArrayList<SelectItem> al = new ArrayList<SelectItem>();
        ArrayList<Rol> roles = (ArrayList<Rol>)  rolDao.getList();
        for(Rol item : roles){
            al.add(new SelectItem(item,item.getNombre()));
        }
        return al;
    }
    
    public String save(){
        dao.update(usuario);
        getSession().remove("usuario");
        return "usuarios";
    }
    public String rigestrar(){
        dao.update(usuario);
        getSession().remove("usuario");
        return null;
    }
    
    public String cancel(){
        getSession().remove("usuario");
        return "usuarios";
    }
    
    
    
    
}
