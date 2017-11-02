package io.github.aarvedahl.entities;

import javax.persistence.*;

@Entity
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendenceid;

    @Column
    private int courseid;

    @Column
    private int studentid;

    @Column
    private boolean studentattedence;

    public int getAttendenceid() {
        return attendenceid;
    }

    public void setAttendenceid(int attendenceid) {
        this.attendenceid = attendenceid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public boolean getStudentattedence() {
        return studentattedence;
    }

    public void setStudentattedence(boolean studentattedence) {
        this.studentattedence = studentattedence;
    }
}
