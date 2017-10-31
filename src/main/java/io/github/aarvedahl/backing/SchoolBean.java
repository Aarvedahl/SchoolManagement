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

    // TODO Bugg när man redigerar namn på en kurs, en lösning kan vara olika sidor vilket tvingar användaren att se refresha den andra tabellen
    // TODO Lägga till studenter samt redigera vilka kurser de läser.
    // TODO Alternativt på alla kurser så visar man en lista med checkboxar på varje student när man kan välja om de går i kursen eller inte.
}
