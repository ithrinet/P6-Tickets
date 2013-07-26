/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.icefaces.ace.component.datatable.DataTable;
import tickets.bean.utils.AbstractBean;
import tickets.dao.UsuarioDao;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean

public class UsuariosBean  extends  AbstractBean{
    
    private UsuarioDao dao;

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    private DataTable dataTable;
    public UsuariosBean(){
        dao = new UsuarioDao();
    }
    
    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> tmp = (ArrayList<Usuario>) dao.getList();
        return tmp;
    }

    
  
    public String editar(){
        Usuario user = (Usuario)dataTable.getRowData();
        getSession().put("usuario", user);
        return "usuariosForm";
    }
    
    public String eliminar(){
        Usuario user = (Usuario)dataTable.getRowData();
        dao.delete(user);
        return null;
    }
    
}
