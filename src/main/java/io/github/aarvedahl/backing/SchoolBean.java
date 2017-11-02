package io.github.aarvedahl.backing;

import io.github.aarvedahl.entities.Course;
import io.github.aarvedahl.entities.Student;
import io.github.aarvedahl.facades.CourseFacade;
import io.github.aarvedahl.facades.StudentFacade;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class SchoolBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @EJB private StudentFacade studentEJB;
    @EJB private CourseFacade courseEJB;

    private String choosenStudent;
    private String choosenCourse;
    private List<Student> students;
    private List<Course> courses;
    private List<Integer> studentids;
    private List<Integer> courseids;

    public void setStudentids(List<Integer> studentids) {
        this.studentids = studentids;
    }

    public void setCourseids(List<Integer> courseids) {
        this.courseids = courseids;
    }

    public List<Integer> getStudentids() {
        if(studentids == null) {
            List<Integer> list = new ArrayList<>();
            for(Student student: getStudents()) {
                list.add(student.getStudentid());
            }
            list = studentids;
        }
        return studentids;
    }

    public List<Integer> getCourseids() {
        if(courseids == null) {
            List<Integer> list = new ArrayList<>();
            for(Course course: getCourses()) {
                list.add(course.getCourseid());
            }
            list = courseids;
        }
        return courseids;
    }

    public List<Student> getStudents() {
        if(students == null) {
            students = studentEJB.findAll();
        }
        return students;
    }

    public List<Course> getCourses() {
        if(courses == null) {
            courses = courseEJB.findAll();
        }
        return courses;
    }

    public void saveStudent(Student student) {
        studentEJB.edit(student);
    }

    public void saveCourse(Course course) {
        courseEJB.edit(course);
    }

    public void addCourse() {
        Course course = new Course("");
        courseEJB.create(course);
        courses.add(course);
    }

    public String getChoosenCourse() { return choosenCourse; }
    public void setChoosenCourse(String choosenCourse) { this.choosenCourse = choosenCourse; }
    public String getChoosenStudent() { return choosenStudent; }
    public void setChoosenStudent(String choosenStudent) { this.choosenStudent = choosenStudent; }
    public StudentFacade getStudentEJB() { return studentEJB; }
    public CourseFacade getCourseEJB() { return courseEJB; }

    public void findStudent() {
        int student = Integer.parseInt(choosenStudent);
        int course = Integer.parseInt(choosenCourse);
        Student student1 = studentEJB.find(student);
        Course course1 = courseEJB.find(course);
        List<Student> courseList = course1.getStudents();
        courseList.add(student1);
        saveCourse(course1);
    }
    // Kanske ett form där man väljer studenter från en lista samt vilken kurs och så kan man lägga till på det sättet. student.courses.add("course id etc") em.persist(student)
    // TODO Bugg när man redigerar namn på en kurs, en lösning kan vara olika sidor vilket tvingar användaren att se refresha den andra tabellen
    //

}
