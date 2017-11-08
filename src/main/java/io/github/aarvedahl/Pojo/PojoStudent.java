package io.github.aarvedahl.Pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PojoStudent {
    @XmlElement
    private String name;
    @XmlElement
    private int id;
    @XmlElement
    private String course;


    public PojoStudent() {}
    public PojoStudent(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
