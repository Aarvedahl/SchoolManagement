package io.github.aarvedahl.backing;

import io.github.aarvedahl.converters.StudentConverter;
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

    private List<Student> students;
    private List<Course> courses;
    private Student selectedStudent;
    private Course selectedCourse;

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Course getSelectedCourse() {
        return selectedCourse;    }

    public void setSelectedCourse(Course selectedCourse) { this.selectedCourse = selectedCourse; }


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

    public StudentFacade getStudentEJB() { return studentEJB; }
    public CourseFacade getCourseEJB() { return courseEJB; }

    public void addStudentToCourse() {
        selectedCourse.getStudents().add(selectedStudent);
        saveCourse(selectedCourse);
    }

    // TODO ADD

}
