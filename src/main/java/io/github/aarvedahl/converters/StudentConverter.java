package io.github.aarvedahl.converters;

import io.github.aarvedahl.backing.SchoolBean;
import io.github.aarvedahl.entities.Student;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.lang.annotation.Annotation;

@FacesConverter("io.github.aarvedahl.StudentConverter")
public class StudentConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
        int id;
        try {
            id = Integer.parseInt(value);
        } catch (NumberFormatException e){
            return "Number format Exception here";
        }
        SchoolBean schoolBean = context.getApplication().evaluateExpressionGet(context, "#{schoolBean}", SchoolBean.class);
        return schoolBean.getStudentEJB().find(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return "";
        }
        if(!(value instanceof Student)) {
            return "";
        }

        return Integer.toString(((Student) value).getStudentid());
    }
}
