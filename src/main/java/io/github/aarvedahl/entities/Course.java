package io.github.aarvedahl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    @Column
    private String coursename;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public int getCourseid() { return courseid; }
    public void setCourseid(int courseid) { this.courseid = courseid; }
    public String getCoursename() { return coursename; }
    public void setCoursename(String coursename) { this.coursename = coursename; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
