/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean.tecnico;

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
public class TecnicoBean extends AbstractBean {
    
    private TicketDao dao;
    private DataTable dataTable;

    public TecnicoBean() {
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
    
    public List<Ticket> getTicketsAsignados(){
        ArrayList<Ticket> lista = (ArrayList<Ticket>) dao.getListTecnico((Usuario)getSession().get("currentUser"));
        return lista;
    }
     public List<Ticket> getTicketsCerados(){
        ArrayList<Ticket> lista = (ArrayList<Ticket>) dao.getLisCerados((Usuario)getSession().get("currentUser"));
        return lista;
    }
    public List<Ticket> getTickets(){
        ArrayList<Ticket> lista = (ArrayList<Ticket>) dao.getListNull();
        return lista;
    }
    public String nuevo(){
        return "tecnicosForm";
    }
    public String editar(){
        Ticket ticket = (Ticket) dataTable.getRowData();
        getSession().put("ticket", ticket);
        return "tecnicosForm";
    }
 
    public String asignar(){ 
        Ticket tec = (Ticket)dataTable.getRowData();
        tec.setTecnico((Usuario)getSession().get("currentUser")); 
        
        dao.update(tec);         
        dao.refresh((Usuario)getSession().get("currentUser"));
        return null;
    }
}
