/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.icefaces.ace.component.datatable.DataTable;
import tickets.bean.utils.AbstractBean;
import tickets.dao.RolDao;
import tickets.pojo.Rol;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class RolesBean extends AbstractBean{
    
    public RolDao dao;
    public DataTable dataTable;

    public RolesBean() {
        dao = new RolDao();
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    public ArrayList<Rol> getRoles(){
        return (ArrayList<Rol>) dao.getList();
    }
    
    public String nuevo(){
        return "rolesForm";
    }
    
    public String editar(){
        Rol rol = (Rol)dataTable.getRowData();
        getSession().put("rol",rol);
        return "rolesForm";
    }
    public String eliminar(){
        Rol rol = (Rol)dataTable.getRowData();
        dao.delete(rol);
        return null;
    }
    
    
}
