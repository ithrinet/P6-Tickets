/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tickets.hibernate;

    
import java.sql.Connection;
    import java.util.ArrayList;  
    import java.util.List;  
import javax.faces.context.FacesContext;
    import org.hibernate.Session;  
import org.hibernate.SessionFactory;
    import org.hibernate.criterion.Projections;  
    import org.hibernate.criterion.Restrictions;  
     
    public abstract class HibernateManager {  
     
       protected Object myClass = new Object(); // tipo de objeto  
       protected String TABLE = ""; // nombre de la tabla  
     
       /**  
        * Obtener un elemento a partir de su identificador  
        * Se supone que en todas las entidades existe el atributo id que las identifica  
        * @param id  
        * @return  
        */  
       public Object getElementById(Long id){  
           Object obj = new Object();  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // cargar objeto por clave  
               obj = session.createCriteria(myClass.getClass()).add(Restrictions.eq("id", id)).uniqueResult();  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en getElementById: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return obj;  
       }  
     
       /**  
        * Guardar un objeto en la base de datos  
        * @param o  
        */  
       public boolean create(Object o) {  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // almacenarlo  
               session.save(o);  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en create: " + e);  
               // deshacer transaccion  
               this.rollback();  
               return false;  
           }  
           return true;  
       }  
     
       /**  
        * Actualizar un objeto en la base de datos  
        * @param o  
        */  
       public boolean update(Object o){  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // actualizarlo  
               session.saveOrUpdate(o);  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en update: " + e);  
               // deshacer transaccion  
               this.rollback();  
               return false;  
           }  
           return true;  
       }  
     
       /**  
        * Borrar un objeto de la base de datos  
        * @param o  
        */  
       public boolean delete(Object o) {  
           if(o == null){  
               return false;  
           }  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // borrarlo  
               session.delete(o);  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en delete: " + e);  
               // deshacer transaccion  
               this.rollback();  
               return false;  
           }  
           return true;  
       }  
     
       /**  
        * Obtener la lista de registros para una entidad  
        * @return  
        */  
       public List getList(){  
           // obtener la sesion actual  
           Session session = getSession();  
           List result = new ArrayList();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // obtener la lista de eventos  
               result = session.createCriteria(myClass.getClass()).list();  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en getList: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return result;  
       }  
     
       /**  
        * Obtener una lista de registros de una entidad limitada  
        * @param ini Indice inicial  
        * @param batch Cantidad de registros a obtener  
        * @return  
        */  
       public List getSubList(int ini, int batch){  
           // obtener la sesion actual  
           Session session = getSession();  
           List result = new ArrayList();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // obtener la lista de eventos  
               List aux = session.createCriteria(myClass.getClass()).list();  
               for(int i = ini; i < aux.size() && i < ini + batch; i++){  
                   result.add(aux.get(i));  
               }  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en getSubList: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return result;  
       }  
     
       /**  
        * Cantidad de registros de una entidad  
        * @return  
        */  
       public int getListCount() {  
           Number count = 0;  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // obtener la cantidad  
               count = (Number) session.createCriteria(myClass.getClass()).setProjection(Projections.rowCount()).uniqueResult();  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en getListCount: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return count.intValue();  
       }  
     
       /**  
        * Comprobar si esta repetido un objeto a partir de un valor de un atributo  
        * @param attr  
        * @param value  
        * @return  
        */  
       public boolean checkRepeated(String attr, String value){  
           Object obj = new Object();  
           // obtener la sesion actual  
           Session session = getSession();  
           try {  
               // comenzar la transaccion  
               session.beginTransaction();  
               // cargar objeto por clave  
               obj = session.createCriteria(myClass.getClass()).add(Restrictions.eq(attr, value)).uniqueResult();  
               // confirmar transaccion  
               session.getTransaction().commit();  
           } catch (Exception e) {  
               System.out.println("Error en checkRepeated: " + e);  
               // deshacer transaccion  
               this.rollback();  
           }  
           return obj != null ? true : false;  
       }  
     
       /**  
        * Obtener la sesion de hibernate para el acceso a la base de datos  
        * @return  
        */  
       protected Session getSession(){  
            //Session session = (Session) FacesContext.getCurrentInstance().getAttributes().get("Hibernate.session");
            Session session = (Session) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Hibernate.session");
            if (session == null) {
                try {
                    session = HibernateUtil.getSessionFactory().getCurrentSession();
                    if (!session.isOpen()) {
                        session = HibernateUtil.getSessionFactory().openSession();
                    }
                } catch (Exception e) {
                    session = HibernateUtil.getSessionFactory().openSession();
                }
                //FacesContext.getCurrentInstance().getAttributes().put("Hibernate.session",session);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Hibernate.session",session);
            }
            return session;
        }
     
       /**  
        * Obtener el nombre de la tabla al que hace referencia  
        * @return  
        */  
       public String getTableName(){  
           return TABLE;  
       }  
     
       /**  
        * Hacer rollback y que no se termine la aplicacion tras un fallo  
        */  
       public void rollback(){  
           Session session = getSession();  
           try {  
               // deshacer transaccion  
               session.getTransaction().rollback();  
           } catch (Exception e) {  
               System.out.println("Error en rollback: " + e);  
           }  
       }
       
       public void refresh(Object obj){
           Session session = getSession();  
           session.flush();
           session.refresh(obj);
       }
       public Connection getConnection(){
           return getSession().connection();
       }
    } 