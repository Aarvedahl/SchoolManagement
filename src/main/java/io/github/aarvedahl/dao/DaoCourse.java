package io.github.aarvedahl.dao;


import java.util.List;

public class DaoCourse {

    private String coursename;

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
