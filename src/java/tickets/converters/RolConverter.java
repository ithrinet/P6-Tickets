/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import tickets.dao.RolDao;
import tickets.pojo.Rol;

/**
 *
 * @author Administrador
 */
public class RolConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       RolDao dao = new RolDao();
       Long id = new Long(string);
       Rol rol =(Rol) dao.getElementById(id);
        return rol;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Rol rol = (Rol)o;
        return rol.getId().toString();
    }
    
}
