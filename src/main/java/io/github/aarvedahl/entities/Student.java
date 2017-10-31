package io.github.aarvedahl.entities;

import javax.persistence.Entity;

@Entity
public class Student {

    private int studentid;

    private String fullname;

    public String getFullname() { return fullname; }

    public void setFullname(String fullname) { this.fullname = fullname; }

    public int getStudentid() { return studentid; }

    public void setStudentid(int studentid) { this.studentid = studentid; }
}
