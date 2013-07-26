/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import tickets.bean.utils.AbstractBean;
import tickets.dao.EstadoDao;
import tickets.dao.MensajeDao;
import tickets.dao.TicketDao;
import tickets.pojo.Estado;
import tickets.pojo.Mensaje;
import tickets.pojo.Ticket;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
public class FormBasicoBean extends AbstractBean{
    
    private MensajeDao dao;
    private TicketDao ticketDao;
    private Ticket ticket;
    private Mensaje mensaje;

    public FormBasicoBean() {
        dao = new MensajeDao();
        ticketDao = new TicketDao();
        mensaje = new Mensaje();
    }

    public Ticket getTicket() {
        ticket = (Ticket)getSession().get("ticket");
        if(ticket == null){
            ticket = new Ticket();
            ticket.setFechaApertura(new Date());
            ticket.setCliente((Usuario)getSession().get("currentUser"));
            getSession().put("ticket", ticket);
        }
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }
    public Boolean getIsCerrado(){
        
        return ticket.getEstado() != null && ticket.getEstado().getId() == Ticket.CERRADO;
    }
    public Boolean getIsAbierto(){
        
        return ticket.getEstado() != null & ticket.getEstado().getId() != Ticket.CERRADO &  ticket.getId() == null;
    }

    public Boolean getIsVacio(){
        
        return ticket.getId() != null;
    }
    
    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    
    public String save(){
        mensaje.setTicket(ticket);
        mensaje.setMensaje(new Date());
        EstadoDao md = new EstadoDao();
        Estado m = null;
        if(ticket.getEstado()==null){  
            m = (Estado)md.getElementById(Ticket.ABIERTO);
        }else{
            m = (Estado)md.getElementById(Ticket.ESPERANDO);    
        }
        ticket.setEstado(m);
        dao.update(ticket);
        ticketDao.update(mensaje);
        dao.refresh(ticket);
        getSession().remove("ticket");
        return "basico";
        
    }
    public String cancel(){
        getSession().remove("ticket");
        return "basico";
    }
    
    public String cerrar(){
        EstadoDao md = new EstadoDao();
        Estado m = (Estado)md.getElementById(Ticket.CERRADO);
        ticket.setEstado(m);
        dao.update(m);
         getSession().remove("ticket");
        return "basico";
    }
    
    
    
    
}
