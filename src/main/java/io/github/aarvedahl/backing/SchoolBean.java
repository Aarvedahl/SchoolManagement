package io.github.aarvedahl.backing;

import io.github.aarvedahl.entities.Course;
import io.github.aarvedahl.entities.Student;
import io.github.aarvedahl.facades.CourseFacade;
import io.github.aarvedahl.facades.StudentFacade;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class SchoolBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @EJB private StudentFacade studentEJB;
    @EJB private CourseFacade courseEJB;

    private List<Student> students;
    private List<Course> courses;

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

    public void addCourseToStudent() {
        System.out.println();
    }

    public StudentFacade getStudentEJB() { return studentEJB; }

    public CourseFacade getCourseEJB() { return courseEJB; }

    // Kanske ett form där man väljer studenter från en lista samt vilken kurs och så kan man lägga till på det sättet. student.courses.add("course id etc") em.persist(student)
    // TODO Bugg när man redigerar namn på en kurs, en lösning kan vara olika sidor vilket tvingar användaren att se refresha den andra tabellen
}
