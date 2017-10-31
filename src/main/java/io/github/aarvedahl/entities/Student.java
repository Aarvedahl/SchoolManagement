package io.github.aarvedahl.entities;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;

    @Column
    private String fullname;

    public String getFullname() { return fullname; }

    public void setFullname(String fullname) { this.fullname = fullname; }

    public int getStudentid() { return studentid; }

    public void setStudentid(int studentid) { this.studentid = studentid; }
}
