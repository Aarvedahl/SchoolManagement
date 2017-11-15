package io.github.aarvedahl.dao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DaoStudent {
    @XmlElement
    private String name;

    @XmlElement
    private String course;


    public DaoStudent() {}
    public DaoStudent(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

}
