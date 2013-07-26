/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.dao;

import tickets.hibernate.HibernateManager;
import tickets.pojo.Estado;

/**
 *
 * @author Administrador
 */
public class EstadoDao extends HibernateManager {
    
    public EstadoDao(){
        myClass = new Estado();
    }
    
}
