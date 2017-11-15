package io.github.aarvedahl.dao;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DaoCourse {

    @XmlElement
    private String coursename;

    @XmlElementWrapper(name="students")
    @XmlElement(name="student")
    private List<DaoStudent> students;


    public DaoCourse(String coursename, List<DaoStudent> students) {
        this.coursename = coursename;
        this.students = students;
    }

    public String getCoursename() {
        return coursename;
    }

    public List<DaoStudent> getStudents() {
        return students;
    }
}
