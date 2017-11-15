package io.github.aarvedahl.dao;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DaoStudent {
    @XmlElement private String name;


    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    private List<DaoCourse> courseList;

    public DaoStudent() {}

    public DaoStudent(String name) {
        this.name = name;
        courseList = new ArrayList<>();
    }

    public void addCourse(DaoCourse course) {
        courseList.add(course);
    }

    public List<DaoCourse> getCourseList() {
        return courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
