package io.github.aarvedahl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;

    @Column
    private String fullname;

    @ManyToMany
    @JoinTable(
            name="student_course",
            joinColumns = {
                    @JoinColumn(name="studentid", referencedColumnName = "studentid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="courseid", referencedColumnName = "courseid")
            }
    )
    private List<Course> courses;

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public int getStudentid() { return studentid; }
    public void setStudentid(int studentid) { this.studentid = studentid; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Student) && (studentid != 0)
                ? studentid == (((Student) other).studentid)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (studentid != 0)
                ? (this.getClass().hashCode() + studentid)
                : super.hashCode();
    }
}
