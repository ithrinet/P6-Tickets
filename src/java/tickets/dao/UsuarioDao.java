/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import tickets.hibernate.HibernateManager;
import tickets.pojo.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuarioDao extends HibernateManager {
    
    public UsuarioDao(){
        myClass = new Usuario();
    }

    public Usuario getUser(String usuario, String password) {
        Usuario user = null;
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // cargar objeto por clave  
               user = (Usuario) session.createCriteria(myClass.getClass())
                       .add(Restrictions.eq("usuario", usuario))
                       .add(Restrictions.eq("password", password))
                       .uniqueResult();  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en getElementById: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return user;  
    }
    
}
