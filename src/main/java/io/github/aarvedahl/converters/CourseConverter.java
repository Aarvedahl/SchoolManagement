package io.github.aarvedahl.converters;

import io.github.aarvedahl.backing.SchoolBean;
import io.github.aarvedahl.entities.Course;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Course.class)
public class CourseConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
        int id;
        try {
            id = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return "";
        }
        SchoolBean schoolBean = context.getApplication().evaluateExpressionGet(context, "#{schoolBean}", SchoolBean.class);
        return schoolBean.getCourseEJB().find(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) return "";
        if(!(value instanceof Course)) return "";

        return Integer.toString(((Course) value).getCourseid());
    }
}
