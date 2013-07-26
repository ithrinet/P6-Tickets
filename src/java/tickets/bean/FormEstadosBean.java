/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import javax.faces.bean.ManagedBean;
import tickets.bean.utils.AbstractBean;
import tickets.dao.EstadoDao;
import tickets.pojo.Estado;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class FormEstadosBean extends AbstractBean{
    
    private Estado estado;
    private EstadoDao dao;

    public FormEstadosBean(){
        dao = new EstadoDao();
    }
    
    public Estado getEstado() {
        estado = (Estado) getSession().get("estado");
        if(estado == null){
            estado = new Estado();
            getSession().put("estado",estado);
        }
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public String save(){
        dao.update(estado);
        getSession().remove("estado");
        return "estados";
    }
    
    public String cancel(){
        getSession().remove("estado");
        return "estados";
    }
    
}
