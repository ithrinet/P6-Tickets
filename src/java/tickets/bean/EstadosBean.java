/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.icefaces.ace.component.datatable.DataTable;
import tickets.bean.utils.AbstractBean;
import tickets.dao.EstadoDao;
import tickets.pojo.Estado;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class EstadosBean extends AbstractBean{
    
    private EstadoDao dao;
    private DataTable dataTable;

    public EstadosBean() {
        dao = new EstadoDao();
    }
    
    
    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    
    public ArrayList<Estado> getEstados(){
        return (ArrayList<Estado>)dao.getList();
    }
    
    public String nuevo(){
        return "estadosForm";
    }
    public String editar(){
        Estado estado = (Estado) dataTable.getRowData();
        getSession().put("estado", estado);
        return "estadosForm";
    }
    
    
    public String eliminar(){
        Estado estado = (Estado)dataTable.getRowData();
        dao.delete(estado);
        return null;
    }
    
    
}
