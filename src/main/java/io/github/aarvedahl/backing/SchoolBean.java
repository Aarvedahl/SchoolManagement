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

    private String choosenStudent;
    private String choosenCourse;
    private List<Student> students;
    private List<Course> courses;
    private List<String> studentids;
    private List<String> courseids;

    public void setStudentids(List<String> studentids) {
        this.studentids = studentids;
    }

    public void setCourseids(List<String> courseids) {
        this.courseids = courseids;
    }

    public List<String> getStudentids() {
        if(studentids == null) {
            List<String> list = new ArrayList<>();
            for(Student student: getStudents()) {
                list.add(Integer.toString(student.getStudentid()));
            }
            studentids = list;
        }
        return studentids;
    }

    public List<String> getCourseids() {
        if(courseids == null) {
            List<String> list = new ArrayList<>();
            for(Course course: getCourses()) {
                list.add(Integer.toString(course.getCourseid()));
            }
            courseids = list;
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
        Student student1 = studentEJB.find(Integer.parseInt(choosenStudent));
        Course course1 = courseEJB.find(Integer.parseInt(choosenCourse));
        course1.getStudents().add(student1);
        saveCourse(course1);
    }
    // TODO Bugg när man redigerar namn på en kurs, en lösning kan vara olika sidor vilket tvingar användaren att se refresha den andra tabellen
    //

}
