package io.github.aarvedahl.entities;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    @Column
    private String coursename;

    public int getCourseid() { return courseid; }

    public void setCourseid(int courseid) { this.courseid = courseid; }

    public String getCoursename() { return coursename; }

    public void setCoursename(String coursename) { this.coursename = coursename; }
}
