/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean.admin;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.icefaces.ace.component.datatable.DataTable;
import tickets.bean.utils.AbstractBean;
import tickets.dao.TicketDao;
import tickets.pojo.Ticket;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class AdminBean extends AbstractBean {
    
    private TicketDao dao;
    private DataTable dataTable;

    public AdminBean() {
        dao = new TicketDao();
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
    
    public Boolean getIsCerrado(){
        Ticket ticket = (Ticket) dataTable.getRowData();
        return ticket.getEstado() != null && ticket.getEstado().getId() == Ticket.CERRADO;
    }
    
 
    public List<Ticket> getTickets(){
        ArrayList<Ticket> lista = (ArrayList<Ticket>) dao.getList();
        return lista;
    }
    public String nuevo(){
        return "adminsForm";
    }
    public String editar(){
        Ticket ticket = (Ticket) dataTable.getRowData();
        getSession().put("ticket", ticket);
        return "adminsForm";
    }
        
    public String eliminar(){
        Ticket ticket = (Ticket)dataTable.getRowData();
        dao.delete(ticket);
        return null;
    }
    
    
}
