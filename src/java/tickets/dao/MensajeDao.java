/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.dao;

import tickets.hibernate.HibernateManager;
import tickets.pojo.Mensaje;

/**
 *
 * @author Administrador
 */
public class MensajeDao extends HibernateManager {
    
    public MensajeDao(){
        myClass = new Mensaje();
    }
    
}
