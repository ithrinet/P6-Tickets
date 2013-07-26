/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.dao;

import tickets.hibernate.HibernateManager;
import tickets.pojo.Rol;

/**
 *
 * @author Administrador
 */
public class RolDao  extends HibernateManager{
    
    public RolDao(){
        myClass = new Rol();
    }
    
}
