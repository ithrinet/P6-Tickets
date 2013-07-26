/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Administrador
 */
public class GenderConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if("h".equals(string)){
            return (Boolean) true;
        }else if("m".equals(string)){
            return (Boolean)false;
        }
        throw new ConverterException(new FacesMessage("El valor no es válido"));
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       if(o instanceof Boolean && o != null){
           return ((Boolean) o) ? "h" : "m";
       }
       return "";
    }
    
}
